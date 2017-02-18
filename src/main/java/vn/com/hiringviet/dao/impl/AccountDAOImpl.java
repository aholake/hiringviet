package vn.com.hiringviet.dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.hibernate.transform.Transformers;
import org.hibernate.type.LongType;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import vn.com.hiringviet.common.StatusEnum;
import vn.com.hiringviet.dao.AccountDAO;
import vn.com.hiringviet.dto.AccountDTO;
import vn.com.hiringviet.dto.LoggerDTO;
import vn.com.hiringviet.model.Account;

@Repository
@Transactional
public class AccountDAOImpl extends CommonDAOImpl<Account> implements AccountDAO {

	@Override
	public Account checkLogin(String email, String password) {
		Session session = getSession();

		Criteria criteria = session.createCriteria(Account.class)
				.add(Restrictions.eq("status", StatusEnum.ACTIVE))
				.add(Restrictions.eq("email", email))
				.add(Restrictions.eq("password", password));
		Account account = (Account) criteria.uniqueResult();

		return account;
	}

	@SuppressWarnings("unchecked")
	@Override
	public boolean isExistedAccount(String email) {
		Session session = getSession();
		StringBuilder sb = new StringBuilder();
		sb.append("FROM Account ");
		sb.append("WHERE email = :email");
		Query query = session.createQuery(sb.toString());
		query.setParameter("email", email);

		List<Account> list = query.list();
		if (list.isEmpty()) {
			return false;
		}
		return true;
	}

	@SuppressWarnings("unchecked")
	@Override
	public Account getAccountByEmail(String email) {
		String hql = "FROM Account WHERE email = :email";
		Query query = getSession().createQuery(hql);
		query.setParameter("email", email);
		List<Account> accounts = query.list();
		if (accounts.isEmpty()) {
			return null;
		}
		return accounts.get(0);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<AccountDTO> getFollowList(String accountId) {

		StringBuffer sb = new StringBuffer();
		sb.append("SELECT ");
		sb.append("member.id AS id, ");
		//sb.append("c.display_name AS displayName,  ");
		sb.append("account.avatar_image AS avatarImage ");
		sb.append("FROM account ");
		sb.append("INNER JOIN member ON member.account_id = account.id ");
		sb.append("INNER JOIN follow ON (follow.from_account = account.id AND follow.to_account = :accountId)");
		Query query = getSession().createSQLQuery(sb.toString());
		query.setParameter("accountId", accountId);
		query.setResultTransformer(Transformers.aliasToBean(AccountDTO.class));

		List<AccountDTO> accountDTOs = query.list();
		if (accountDTOs.isEmpty()) {
			return null;
		}
		return accountDTOs;
	}

	@Override
	public boolean updateEmail(Integer accountId, String email) {

		StringBuffer sb = new StringBuffer();
		sb.append("UPDATE ");
		sb.append("account ");
		sb.append("SET email = :email ");
		sb.append("WHERE id = :accountId");
		Query query = getSession().createSQLQuery(sb.toString());
		query.setParameter("email", email);
		query.setParameter("accountId", accountId);

		if (query.executeUpdate() > 0) {
			return true;
		}

		return false;
	}

	@Override
	public boolean updateLocale(Integer accountId, String locale) {

		StringBuffer sb = new StringBuffer();
		sb.append("UPDATE ");
		sb.append("account ");
		sb.append("SET locale = :locale ");
		sb.append("WHERE id = :accountId");
		Query query = getSession().createSQLQuery(sb.toString());
		query.setParameter("locale", locale);
		query.setParameter("accountId", accountId);

		if (query.executeUpdate() > 0) {
			return true;
		}

		return false;
	}

	@Override
	public boolean hasFollow(Integer fromAccountId, Integer toAccountId) {

		StringBuffer sb = new StringBuffer();
		sb.append("SELECT ");
		sb.append("COUNT(*) AS count ");
		sb.append("FROM follow ");
		sb.append("WHERE from_account = :fromAccountId AND to_account = :toAccountId");
		Query query = getSession().createSQLQuery(sb.toString()).addScalar("count", LongType.INSTANCE);
		query.setParameter("fromAccountId", fromAccountId);
		query.setParameter("toAccountId", toAccountId);

		Long result = (Long) query.uniqueResult();
		if (result != null && result > 0) {
			return true;
		}

		return false;
	}

	@Override
	public Account getAccountByActiveUrl(String activeCode) {
		Criteria criteria = getSession().createCriteria(Account.class)
				.add(Restrictions.eq("activeUrl", activeCode));
		return (Account) criteria.uniqueResult();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<LoggerDTO> getListLogger(Integer accountId) {

		StringBuffer sb = new StringBuffer();
		sb.append("SELECT ");
		sb.append("id AS id, ");
		sb.append("date_time AS dateTime, ");
		sb.append("image AS image, ");
		sb.append("info AS info ");
		sb.append("FROM logger ");
		sb.append("WHERE account_id = :accountId AND type = 1 ");
		sb.append("ORDER BY date_time DESC");
		Query query = getSession().createSQLQuery(sb.toString());
		query.setParameter("accountId", accountId);
		query.setMaxResults(10);
		query.setResultTransformer(Transformers.aliasToBean(LoggerDTO.class));

		List<LoggerDTO> loggerDTOs = query.list();
		if (loggerDTOs.isEmpty()) {
			return null;
		}
		return loggerDTOs;
	}
}
