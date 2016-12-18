package vn.com.hiringviet.auth;

import org.springframework.security.core.context.SecurityContextHolder;

import vn.com.hiringviet.model.Account;

public class AuthenticationUtil {
	public static boolean isAuthenticated() {
		Object principal = SecurityContextHolder.getContext()
				.getAuthentication().getPrincipal();
		if (principal instanceof Account) {
			return true;
		}
		return false;
	}
	
	public static Account getLoggedAccount() {
		Object principal = SecurityContextHolder.getContext()
				.getAuthentication().getPrincipal();
		if (principal instanceof Account) {
			Account loginedAccount = (Account) principal;
			return loginedAccount;
		}
		return null;
	}
}
