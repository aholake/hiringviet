package vn.com.hiringviet.auth;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import vn.com.hiringviet.common.AccountRoleEnum;
import vn.com.hiringviet.model.Account;
import vn.com.hiringviet.service.AccountService;
import vn.com.hiringviet.util.SecurityUtil;

@Component
public class CustomAuthenticationProvider implements AuthenticationProvider,
		Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private static final Logger LOGGER = Logger
			.getLogger(CustomAuthenticationProvider.class);

	@Autowired
	private AccountService accountService;

	@Override
	public Authentication authenticate(Authentication auth)
			throws AuthenticationException {
		String email = auth.getName();
		String password = (String) auth.getCredentials();
		password = SecurityUtil.encodeStringToBase64(password);
		System.out.println("Password: "+password); 

		if (email.isEmpty() || password.isEmpty()) {
			LOGGER.info("Empty Field");
			throw new UsernameNotFoundException("Empty Field");
		}

		Account account = accountService.checkLogin(email, password);
		if (account == null) {
			LOGGER.info("Wrong username and password");
			throw new UsernameNotFoundException("Wrong username and password");
		}

		return new UsernamePasswordAuthenticationToken(account, password,
				buildAuthorities(account.getUserRole()));
	}

	public List<GrantedAuthority> buildAuthorities(AccountRoleEnum role) {
		List<GrantedAuthority> roles = new ArrayList<>();
		roles.add(new SimpleGrantedAuthority(role.name()));
		LOGGER.info(roles);
		return roles;
	}

	@Override
	public boolean supports(Class<?> arg0) {
		return true;
	}

}
