package vn.com.hiringviet.dao;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import vn.com.hiringviet.dto.MessageDTO;

@Repository
@Transactional
public interface MailboxDAO {

	public List<MessageDTO> getOwnerMailList(Integer accountId);
}
