package vn.com.hiringviet.service.impl;

import java.text.MessageFormat;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import vn.com.hiringviet.auth.AuthenticationUtil;
import vn.com.hiringviet.constant.ConstantValues;
import vn.com.hiringviet.dao.ApplyDAO;
import vn.com.hiringviet.dto.ApplyDTO;
import vn.com.hiringviet.model.Account;
import vn.com.hiringviet.model.Apply;
import vn.com.hiringviet.model.Job;
import vn.com.hiringviet.model.Member;
import vn.com.hiringviet.model.Message;
import vn.com.hiringviet.service.AccountService;
import vn.com.hiringviet.service.ApplyService;
import vn.com.hiringviet.service.JobService;
import vn.com.hiringviet.service.LoggerService;
import vn.com.hiringviet.service.MailService;
import vn.com.hiringviet.service.MailboxService;
import vn.com.hiringviet.util.FileUtil;
import vn.com.hiringviet.util.Utils;

// TODO: Auto-generated Javadoc
/**
 * The Class ApplyServiceImpl.
 */
@Service("applyService")
@Transactional
public class ApplyServiceImpl implements ApplyService {
	
	/** The Constant CONFIRM_APPLY_DENIED_SIGN. */
	private static final String CONFIRM_APPLY_DENIED_SIGN = "Please update personal information to be more trusted";

	/** The apply dao. */
	@Autowired
	private ApplyDAO applyDao;

	/** The job service. */
	@Autowired
	private JobService jobService;

	/** The mail box service. */
	@Autowired
	private MailboxService mailBoxService;

	/** The mail service. */
	@Autowired
	private MailService mailService;
	
	/** The account service. */
	@Autowired
	private AccountService accountService;

	/** The logger service. */
	@Autowired
	private LoggerService loggerService;

	/* (non-Javadoc)
	 * @see vn.com.hiringviet.service.ApplyService#addApply(vn.com.hiringviet.model.Apply)
	 */
	@Override
	public void addApply(Apply apply) {
		applyDao.create(apply);
	}

	/* (non-Javadoc)
	 * @see vn.com.hiringviet.service.ApplyService#addApplyByDTO(vn.com.hiringviet.dto.ApplyDTO, vn.com.hiringviet.model.Member)
	 */
	@Override
	public void addApplyByDTO(ApplyDTO applyDTO, Member member) {
		String[] jobIds = applyDTO.getJobList().split("\\+");
		String description = applyDTO.getDescription();
		for (String id : jobIds) {
			Job job = jobService.getJobById(Integer.parseInt(id));
			Apply apply = new Apply();
			apply.setJob(job);
			apply.setMember(member);
			apply.setDisscription(description);
			apply.setCurriculumVitae(applyDTO.getCurriculumVitae());
			apply.setChangeLog(Utils.createDefaultChangeLog());
			apply.setAccepted(null);
			applyDao.addApplyByNativeSQL(apply);
			String info = "<p><b>" + member.getFirstName() + " " + member.getLastName() + "</b> vừa apply vào công việc \"" + job.getTitle() + "\"</p>";
			info += "</p><a href=\"/company/apply?companyId=" + job.getCompany().getId() + "&jobId=" + job.getId() + "\">Xác thực ngay!</a><p>";
			loggerService.create(job.getCompany().getAccount().getId(), member.getAccount().getId(), info, false);
		}

	}

	/* (non-Javadoc)
	 * @see vn.com.hiringviet.service.ApplyService#findApplies(int)
	 */
	@Override
	public List<Apply> findApplies(int jobId) {
		Job job = jobService.getJobById(jobId);
		return applyDao.getApplies(job);
	}

	/* (non-Javadoc)
	 * @see vn.com.hiringviet.service.ApplyService#get(int)
	 */
	@Override
	public Apply get(int id) {
		return applyDao.findOne(id);
	}

	/* (non-Javadoc)
	 * @see vn.com.hiringviet.service.ApplyService#update(vn.com.hiringviet.model.Apply)
	 */
	@Override
	public void update(Apply apply) {
		applyDao.update(apply);
	}

	/* (non-Javadoc)
	 * @see vn.com.hiringviet.service.ApplyService#getAllApplyByJobId(java.lang.Integer)
	 */
	@Override
	public List<ApplyDTO> getAllApplyByJobId(Integer jobId) {
		return applyDao.getAllApplyByJobId(jobId);
	}
	
	/* (non-Javadoc)
	 * @see vn.com.hiringviet.service.ApplyService#sendApprovedApplyMessage(int, vn.com.hiringviet.model.Message)
	 */
	public void sendApprovedApplyMessage(int applyId, Message approveMessage) {
		Apply apply = get(applyId);
		Account receiverAcc = apply.getMember().getAccount();
		Account company = AuthenticationUtil.getLoggedAccount();

		if (receiverAcc != null && company != null && apply != null) {
			approveMessage.setSenderAccount(company);
			approveMessage.setOwnerAccount(receiverAcc);
			approveMessage.setChangeLog(Utils.createDefaultChangeLog());
			apply.setAccepted(true);
			this.update(apply);
			
			mailBoxService.createMessageNativeSQL(approveMessage);
			
			sendEmailConfirmApply(receiverAcc, apply, true, approveMessage.getContent());
		} else {
			throw new RuntimeException("Internal Error");
		}
	}
	
	/**
	 * Send email confirm apply.
	 *
	 * @param to the to
	 * @param apply the apply
	 * @param isApproved the is approved
	 * @param approveMessage the approve message
	 */
	private void sendEmailConfirmApply(Account to, Apply apply, boolean isApproved, String approveMessage) {
		String title = null;
		if(isApproved) {
			title = "HiringViet - Your apply has been accepted";
		} else  {
			title = "HiringViet - Your apply has been denied";
		}
		
		String content = FileUtil.getConfigProperties().getProperty("email.confirmApply");
		content = MessageFormat.format(content, to.getMember().getFirstName() + to.getMember().getLastName(), apply.getJob().getTitle(), isApproved ? "APPROVED": "DENIED", approveMessage);
		mailService.sendMail(to.getEmail(), title, content);
	}

	/* (non-Javadoc)
	 * @see vn.com.hiringviet.service.ApplyService#sendDeniedApplyMessage(int)
	 */
	@Override
	public void sendDeniedApplyMessage(int applyId) {
		String title = ConstantValues.MESSAGE_PROPS.getProperty("apply.deniedTitle");
		String content = ConstantValues.MESSAGE_PROPS
				.getProperty("apply.deniedContent");
		Apply apply = get(applyId);
		Account receiverAcc = apply.getMember().getAccount();
		Account company = AuthenticationUtil.getLoggedAccount();

		if (receiverAcc != null && company != null && apply != null) {
			Member receiverMember = receiverAcc.getMember();
			title = MessageFormat.format(title, apply.getApplyID(),company.getCompany().getDisplayName());
			
			content = MessageFormat.format(
					content,
					receiverMember.getFirstName()
							+ receiverMember.getLastName(), company.getCompany().getDisplayName());
			Message message = new Message();
			message.setOwnerAccount(receiverAcc);
			message.setSenderAccount(company);
			message.setTitle(title);
			message.setContent(content);
			
			apply.setAccepted(false);
			this.update(apply);
			
			mailBoxService.createMessageNativeSQL(message);
			
			sendEmailConfirmApply(receiverAcc, apply, false, content);
		} else {
			throw new RuntimeException("Internal Error");
		}
	}
}
