package vn.com.hiringviet.service;

import java.util.List;

import org.springframework.stereotype.Service;

import vn.com.hiringviet.dto.MessageDTO;
import vn.com.hiringviet.model.Message;

@Service("mailboxService")
public interface MailboxService {

	List<MessageDTO> getOwnerMailList(Integer accountId);
	
	void sendMessageNativeSQL(Message message);
	
	void sendDeniedApplyMessage(int applyId, String receiverEmail);
	
	void sendApprovalApplyMessage(int applyId, String receiverEmail);
}
