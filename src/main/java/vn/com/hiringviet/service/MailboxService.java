package vn.com.hiringviet.service;

import java.util.List;

import org.springframework.stereotype.Service;

import vn.com.hiringviet.dto.MessageDTO;

@Service("mailboxService")
public interface MailboxService {

	public List<MessageDTO> getOwnerMailList(Integer accountId);
}
