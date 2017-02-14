package vn.com.hiringviet.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.transform.Transformers;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import vn.com.hiringviet.dao.MailboxDAO;
import vn.com.hiringviet.dto.MessageDTO;
import vn.com.hiringviet.model.Message;

@Repository
@Transactional
public class MailboxDAOImpl extends CommonDAOImpl<Message> implements MailboxDAO {

	@SuppressWarnings("unchecked")
	@Override
	public List<MessageDTO> getOwnerMailList(Integer accountId) {

		StringBuffer sb = new StringBuffer();
		sb.append("SELECT ");
		sb.append("message.id, ");
		sb.append("account.email AS emailSender, ");
		sb.append("message.type_mail AS typeMail, ");
		sb.append("message.title AS title, ");
		sb.append("message.content AS content, ");
		sb.append("DATE_FORMAT(change_log.created_date, '%d-%m-%Y') AS dateTime ");
		sb.append("FROM account ");
		sb.append("INNER JOIN message ON (message.sender_account_id = account.id AND message.owner_account_id = :accountId) ");
		sb.append("INNER JOIN change_log ON (message.change_log_id = change_log.id AND change_log.status = 1)");
		Query query = getSession().createSQLQuery(sb.toString());
		query.setParameter("accountId", accountId);
		query.setResultTransformer(Transformers.aliasToBean(MessageDTO.class));

		List<MessageDTO> messageDTOs = query.list();
		if (messageDTOs.isEmpty()) {
			return null;
		}
		return messageDTOs;
	}

	@Override
	public void createMessageByNativeSQL(Message message) {
		StringBuilder query = new StringBuilder();
		query = query.append("INSERT INTO message(title, content, owner_account_id, sender_account_id) VALUES(")
				.append("'"+message.getTitle()+"',")
				.append("'"+message.getContent()+"',")
				.append("'"+message.getOwnerAccount().getId()+"',")
				.append("'"+message.getSenderAccount().getId()+"')");
		
		SQLQuery sqlQuery = getSession().createSQLQuery(query.toString());
		sqlQuery.executeUpdate();
	}

}
