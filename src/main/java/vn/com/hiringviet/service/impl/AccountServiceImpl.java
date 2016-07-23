package vn.com.hiringviet.service.impl;

import java.util.Arrays;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import vn.com.hiringviet.dao.AccountDAO;
import vn.com.hiringviet.model.Account;
import vn.com.hiringviet.service.AccountService;

@Service("AccountService")
public class AccountServiceImpl implements AccountService, UserDetailsService {
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

	@Override
	public UserDetails loadUserByUsername(String username)
			throws UsernameNotFoundException {
		LOGGER.info("run authentication " + username);
		Account account = accountDAO.getAccountByEmail(username);
		LOGGER.info(account);
		if (account == null) {
			System.out.println("account not found");
			throw new UsernameNotFoundException("account not found");
		}
		GrantedAuthority grantedAuthority = new SimpleGrantedAuthority(account
				.getRoleID().toString());
		UserDetails userDetails = (UserDetails) new User(account.getEmail(),
				account.getPassword(), Arrays.asList(grantedAuthority));
		return userDetails;
	}

	public AccountDAO getAccountDAO() {
		return accountDAO;
	}

	public void setAccountDAO(AccountDAO accountDAO) {
		this.accountDAO = accountDAO;
	}

}
