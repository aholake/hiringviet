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
import vn.com.hiringviet.service.MailService;
import vn.com.hiringviet.service.MailboxService;
import vn.com.hiringviet.util.FileUtil;
import vn.com.hiringviet.util.Utils;

@Service("applyService")
@Transactional
public class ApplyServiceImpl implements ApplyService {
	private static final String CONFIRM_APPLY_DENIED_SIGN = "Please update personal information to be more trusted";

	@Autowired
	private ApplyDAO applyDao;

	@Autowired
	private JobService jobService;

	@Autowired
	private MailboxService mailBoxService;

	@Autowired
	private MailService mailService;
	
	@Autowired
	private AccountService accountService;
	
	@Override
	public void addApply(Apply apply) {
		applyDao.create(apply);
	}

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
		}

	}

	@Override
	public List<Apply> findApplies(int jobId) {
		Job job = jobService.getJobById(jobId);
		return applyDao.getApplies(job);
	}

	@Override
	public Apply get(int id) {
		return applyDao.findOne(id);
	}

	@Override
	public void update(Apply apply) {
		applyDao.update(apply);
	}

	@Override
	public List<ApplyDTO> getAllApplyByJobId(Integer jobId) {
		return applyDao.getAllApplyByJobId(jobId);
	}
	
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
