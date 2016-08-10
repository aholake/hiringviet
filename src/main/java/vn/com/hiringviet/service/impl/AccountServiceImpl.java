package vn.com.hiringviet.service.impl;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import vn.com.hiringviet.dao.AccountDAO;
import vn.com.hiringviet.model.Account;
import vn.com.hiringviet.service.AccountService;

@Service("AccountService")
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

}
