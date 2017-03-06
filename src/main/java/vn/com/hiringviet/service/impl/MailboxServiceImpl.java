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

// TODO: Auto-generated Javadoc
/**
 * The Class MailboxServiceImpl.
 */
@Service("mailboxService")
public class MailboxServiceImpl implements MailboxService {

	/** The mailbox dao. */
	@Autowired
	private MailboxDAO mailboxDAO;

	/** The account service. */
	@Autowired
	private AccountService accountService;

	/** The apply service. */
	@Autowired
	private ApplyService applyService;
	
	/** The logger. */
	@Autowired
	private LoggerService logger;

	/* (non-Javadoc)
	 * @see vn.com.hiringviet.service.MailboxService#getOwnerMailList(java.lang.Integer)
	 */
	@Override
	public List<MessageDTO> getOwnerMailList(Integer accountId) {

		return mailboxDAO.getOwnerMailList(accountId);
	}

	/* (non-Javadoc)
	 * @see vn.com.hiringviet.service.MailboxService#createMessageNativeSQL(vn.com.hiringviet.model.Message)
	 */
	@Override
	public void createMessageNativeSQL(Message message) {
		mailboxDAO.createMessageByNativeSQL(message);
		triggerLogger(message);
	}

	/* (non-Javadoc)
	 * @see vn.com.hiringviet.service.MailboxService#sendMessageViaDto(vn.com.hiringviet.dto.MessageDTO)
	 */
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
	
	/**
	 * Trigger logger.
	 *
	 * @param message the message
	 */
	private void triggerLogger(Message message) {
		logger.create( message.getSenderAccount().getId(), message.getOwnerAccount().getId(), "You have received a message", true);
	}
}
