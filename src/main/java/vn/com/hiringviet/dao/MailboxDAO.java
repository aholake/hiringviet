package vn.com.hiringviet.dao;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import vn.com.hiringviet.dto.MessageDTO;
import vn.com.hiringviet.model.Message;

// TODO: Auto-generated Javadoc
/**
 * The Interface MailboxDAO.
 */
@Repository
@Transactional
public interface MailboxDAO extends CommonDAO<Message>{

	/**
	 * Gets the owner mail list.
	 *
	 * @param accountId the account id
	 * @return the owner mail list
	 */
	public List<MessageDTO> getOwnerMailList(Integer accountId);
	
	/**
	 * Creates the message by native sql.
	 *
	 * @param message the message
	 */
	public void createMessageByNativeSQL(Message message);
}
