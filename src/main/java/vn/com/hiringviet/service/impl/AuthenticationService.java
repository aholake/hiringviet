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

import vn.com.hiringviet.model.Account;
import vn.com.hiringviet.service.AccountService;

@Service("authenticationService")
public class AuthenticationService implements UserDetailsService {
	private static final Logger LOGGER = Logger
			.getLogger(AuthenticationService.class);

	@Autowired
	private AccountService accountService;

	@Override
	public UserDetails loadUserByUsername(String username)
			throws UsernameNotFoundException {
		LOGGER.info("run authentication " + username);
		Account account = accountService.getAccountByEmail(username);
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

}
