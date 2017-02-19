package vn.com.hiringviet.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import vn.com.hiringviet.auth.AuthenticationUtil;
import vn.com.hiringviet.dao.MailboxDAO;
import vn.com.hiringviet.dto.MessageDTO;
import vn.com.hiringviet.model.Account;
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
	public void createMessageNativeSQL(Message message) {
		mailboxDAO.createMessageByNativeSQL(message);
		triggerLogger(message);
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
			
			createMessageNativeSQL(message);
		} else {
			throw new RuntimeException("Haven't login yet");
		}
	}
	
	private void triggerLogger(Message message) {
		logger.create(message.getSenderAccount().getId(), message.getOwnerAccount().getId(), null, "You have received a message", true);
	}
}
