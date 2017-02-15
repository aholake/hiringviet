package vn.com.hiringviet.service.impl;

import java.text.MessageFormat;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import vn.com.hiringviet.auth.AuthenticationUtil;
import vn.com.hiringviet.constant.ConstantValues;
import vn.com.hiringviet.dao.MailboxDAO;
import vn.com.hiringviet.dto.MessageDTO;
import vn.com.hiringviet.model.Account;
import vn.com.hiringviet.model.Apply;
import vn.com.hiringviet.model.Member;
import vn.com.hiringviet.model.Message;
import vn.com.hiringviet.service.AccountService;
import vn.com.hiringviet.service.ApplyService;
import vn.com.hiringviet.service.LoggerService;
import vn.com.hiringviet.service.MailboxService;

@Service("mailboxService")
public class MailboxServiceImpl implements MailboxService {

	@Autowired
	private MailboxDAO mailboxDAO;

	@Autowired
	private AccountService accountService;

	@Autowired
	private ApplyService applyService;
	
	@Autowired
	private LoggerService logger;

	@Override
	public List<MessageDTO> getOwnerMailList(Integer accountId) {

		return mailboxDAO.getOwnerMailList(accountId);
	}

	@Override
	public void sendDeniedApplyMessage(int applyId, String receiverEmail)
			throws RuntimeException {
		String title = ConstantValues.MESSAGE_PROPS.getProperty("apply.deniedTitle");
		String content = ConstantValues.MESSAGE_PROPS
				.getProperty("apply.deniedContent");
		Apply apply = applyService.get(applyId);
		Account receiverAcc = accountService.getAccountByEmail(receiverEmail);
		Account company = AuthenticationUtil.getLoggedAccount();

		if (receiverAcc != null && company != null && apply != null) {
			Member receiverMember = receiverAcc.getMember();
			title = MessageFormat.format(title, apply.getApplyID());
			
			content = MessageFormat.format(
					content,
					receiverMember.getFirstName()
							+ receiverMember.getLastName());
			Message message = new Message();
			message.setOwnerAccount(receiverAcc);
			message.setSenderAccount(company);
			message.setTitle(title);
			message.setContent(content);
			
			apply.setAccepted(false);
			applyService.update(apply);
			
			mailboxDAO.createMessageByNativeSQL(message);
		} else {
			throw new RuntimeException("Internal Error");
		}

	}

	@Override
	public void sendMessageNativeSQL(Message message) {
		mailboxDAO.createMessageByNativeSQL(message);
		triggerLogger(message);
	}

	@Override
	public void sendApprovalApplyMessage(int applyId, String receiverEmail) {
		String title = ConstantValues.MESSAGE_PROPS.getProperty("apply.approvalTitle");
		String content = ConstantValues.MESSAGE_PROPS
				.getProperty("apply.approvalContent");
		Apply apply = applyService.get(applyId);
		Account receiverAcc = accountService.getAccountByEmail(receiverEmail);
		Account company = AuthenticationUtil.getLoggedAccount();

		if (receiverAcc != null && company != null && apply != null) {
			Member receiverMember = receiverAcc.getMember();
			title = MessageFormat.format(title, apply.getJob().getId(), apply.getJob().getCompany().getDisplayName());
			
			content = MessageFormat.format(
					content,
					receiverMember.getFirstName()
							+ receiverMember.getLastName(), apply.getJob().getCompany().getDisplayName());
			Message message = new Message();
			message.setOwnerAccount(receiverAcc);
			message.setSenderAccount(company);
			message.setTitle(title);
			message.setContent(content);
			
			apply.setAccepted(true);
			applyService.update(apply);
			
			mailboxDAO.createMessageByNativeSQL(message);
		} else {
			throw new RuntimeException("Internal Error");
		}
	}

	@Override
	public void sendMessageViaDto(MessageDTO messageDTO) {
		Message message = new Message();
		Account sender = AuthenticationUtil.getLoggedAccount();
		if(sender != null) {
			message.setOwnerAccount(accountService.getAccountByEmail(messageDTO.getEmailReceiver()));
			message.setTitle(message.getTitle());
			message.setContent(messageDTO.getDateTime());
			message.setSenderAccount(sender);
			
			sendMessageNativeSQL(message);
		} else {
			throw new RuntimeException("Haven't login yet");
		}
	}
	
	private void triggerLogger(Message message) {
		logger.create(message.getSenderAccount().getId(), message.getOwnerAccount().getId(), null, "You have received a message", true);
	}
}
