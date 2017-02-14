package vn.com.hiringviet.dao;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import vn.com.hiringviet.dto.MessageDTO;
import vn.com.hiringviet.model.Message;

@Repository
@Transactional
public interface MailboxDAO extends CommonDAO<Message>{

	public List<MessageDTO> getOwnerMailList(Integer accountId);
	
	public void createMessageByNativeSQL(Message message);
}
