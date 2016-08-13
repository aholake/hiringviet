package vn.com.hiringviet.service.impl;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import vn.com.hiringviet.common.StatusRecordEnum;
import vn.com.hiringviet.dao.AccountDAO;
import vn.com.hiringviet.model.Account;
import vn.com.hiringviet.service.AccountService;

@Service("accountService")
@Transactional
public class AccountServiceImpl implements AccountService {
	private static final Logger LOGGER = Logger
			.getLogger(AccountServiceImpl.class);

	@Autowired
	private AccountDAO accountDAO;

	@Override
	public Account checkLogin(String email, String password) {

		return accountDAO.checkLogin(email, password);
	}

	@Override
	public boolean isExistedAccount(String email) {
		return accountDAO.isExistedAccount(email);
	}

	@Override
	public Account getAccountByEmail(String email) {
		return accountDAO.getAccountByEmail(email);
	}

	public AccountDAO getAccountDAO() {
		return accountDAO;
	}

	public void setAccountDAO(AccountDAO accountDAO) {
		this.accountDAO = accountDAO;
	}

	@Override
	public void deleteUnactiveAccount(Account account) {
		if (!account.getActiveUrl().isEmpty()) {
			accountDAO.delete(account);
			LOGGER.info("Account has been deleted");
		}
	}

	@Override
	public void activeAccount(String randomText) {
		int accountId = Integer.parseInt(randomText.substring(0, 2));
		Account account = accountDAO.findOne(accountId);
		account.setActiveUrl(null);
		account.setStatus(StatusRecordEnum.ACTIVE);
		accountDAO.update(account);
	}
}
