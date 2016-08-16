package vn.com.hiringviet.util;

import com.google.appengine.repackaged.com.google.api.client.util.Base64;

public class SecurityUtil {
	public static String encodeStringToBase64(String orgininalText) {
		return Base64.encodeBase64String(orgininalText.getBytes());
	}
	public static void main(String[] args) {
		System.out.println(encodeStringToBase64("11221122"));
	}
}
