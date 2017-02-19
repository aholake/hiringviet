package vn.com.hiringviet.service;

import java.util.List;

import org.springframework.stereotype.Service;

import vn.com.hiringviet.dto.MessageDTO;
import vn.com.hiringviet.model.Message;

@Service("mailboxService")
public interface MailboxService {

	List<MessageDTO> getOwnerMailList(Integer accountId);
	
	void createMessageNativeSQL(Message message);
	
	void sendMessageViaDto(MessageDTO messageDTO);
}
