package vn.com.hiringviet.util;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

import vn.com.hiringviet.constant.ConstantValues;

// TODO: Auto-generated Javadoc
/**
 * The Class CookieUtil.
 */
public class CookieUtil {
	
	/**
	 * Creates the cookie.
	 *
	 * @param response the response
	 * @param name the name
	 * @param value the value
	 */
	public static void createCookie(HttpServletResponse response, String name, String value) {
		Cookie cookie = new Cookie(name, value);
		cookie.setMaxAge(ConstantValues.EXPIRY_TIME_COOKIE);
		cookie.setPath(ConstantValues.COOKIE_PATH);
		
		response.addCookie(cookie);
	}
}
