package vn.com.hiringviet.service.impl;

import java.util.Arrays;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import vn.com.hiringviet.dto.SecurityAccount;
import vn.com.hiringviet.model.Account;
import vn.com.hiringviet.service.AccountService;
import vn.com.hiringviet.service.AuthenticationService;

@Service("authenticationService")
public class AuthenticationServiceImpl implements UserDetailsService,
		AuthenticationService {
	private static final Logger LOGGER = Logger
			.getLogger(AuthenticationServiceImpl.class);

	@Autowired
	private AccountService accountService;

	@Override
	public UserDetails loadUserByUsername(String username)
			throws UsernameNotFoundException {
		LOGGER.info("run authentication " + username);
		Account account = accountService.getAccountByEmail(username);
		LOGGER.info(account);
		if (account == null) {
			LOGGER.error("account not found");
			throw new UsernameNotFoundException("account not found");
		}
		GrantedAuthority grantedAuthority = new SimpleGrantedAuthority(account
				.getUserRole().name());
		LOGGER.info(account.getUserRole().name());
		SecurityAccount securityAccount = new SecurityAccount(
				account.getEmail(), account.getPassword(),
				Arrays.asList(grantedAuthority), account.getCompany(),
				account.getMember());
		return securityAccount;
	}

	@Override
	public SecurityAccount getSecurityAccountAfterLogin() {
		Object principal = SecurityContextHolder.getContext()
				.getAuthentication().getPrincipal();
		if (principal instanceof SecurityAccount) {
			SecurityAccount securityAccount = (SecurityAccount) principal;
			return securityAccount;
		}
		return null;
	}
}
