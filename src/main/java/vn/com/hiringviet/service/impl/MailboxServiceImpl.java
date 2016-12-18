package vn.com.hiringviet.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import vn.com.hiringviet.dao.MailboxDAO;
import vn.com.hiringviet.dto.MessageDTO;
import vn.com.hiringviet.service.MailboxService;

@Service("mailboxService")
public class MailboxServiceImpl implements MailboxService{

	@Autowired
	private MailboxDAO mailboxDAO;

	@Override
	public List<MessageDTO> getOwnerMailList(Integer accountId) {

		return mailboxDAO.getOwnerMailList(accountId);
	}

}
