package vn.com.hiringviet.service;

import java.util.List;

import org.springframework.stereotype.Service;

import vn.com.hiringviet.dto.MessageDTO;
import vn.com.hiringviet.model.Message;

// TODO: Auto-generated Javadoc
/**
 * The Interface MailboxService.
 */
@Service("mailboxService")
public interface MailboxService {

	/**
	 * Gets the owner mail list.
	 *
	 * @param accountId the account id
	 * @return the owner mail list
	 */
	List<MessageDTO> getOwnerMailList(Integer accountId);
	
	/**
	 * Creates the message native sql.
	 *
	 * @param message the message
	 */
	void createMessageNativeSQL(Message message);
	
	/**
	 * Send message via dto.
	 *
	 * @param messageDTO the message dto
	 */
	void sendMessageViaDto(MessageDTO messageDTO);
}
