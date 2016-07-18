package vn.com.hiringviet.service.impl;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import vn.com.hiringviet.dao.AccountDAO;
import vn.com.hiringviet.model.Account;

public class AuthenticationService implements UserDetailsService{
	@Autowired
	private AccountDAO accountDAO;

	@Override
	public UserDetails loadUserByUsername(String email)
			throws UsernameNotFoundException {
		Account account = accountDAO.getAccountByEmail(email);
		GrantedAuthority grantedAuthority = new SimpleGrantedAuthority(account.getRoleID().toString());
		UserDetails userDetails = (UserDetails) new User(account.getEmail(), account.getPassword(), Arrays.asList(grantedAuthority));
		return userDetails;
	}

}
