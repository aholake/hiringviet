package vn.com.hiringviet.auth;

import org.springframework.security.core.context.SecurityContextHolder;

import vn.com.hiringviet.model.Account;

// TODO: Auto-generated Javadoc
/**
 * The Class AuthenticationUtil.
 */
public class AuthenticationUtil {
	
	/**
	 * Checks if is authenticated.
	 *
	 * @return true, if is authenticated
	 */
	public static boolean isAuthenticated() {
		Object principal = SecurityContextHolder.getContext()
				.getAuthentication().getPrincipal();
		if (principal instanceof Account) {
			return true;
		}
		return false;
	}
	
	/**
	 * Gets the logged account.
	 *
	 * @return the logged account
	 */
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
