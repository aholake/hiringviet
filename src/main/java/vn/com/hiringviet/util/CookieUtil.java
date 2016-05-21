package vn.com.hiringviet.util;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

import vn.com.hiringviet.constant.ConstantValues;

public class CookieUtil {
	public static void createCookie(HttpServletResponse response, String name, String value) {
		Cookie cookie = new Cookie(name, value);
		cookie.setMaxAge(ConstantValues.EXPIRY_TIME_COOKIE);
		cookie.setPath(ConstantValues.COOKIE_PATH);
		
		response.addCookie(cookie);
	}
}
