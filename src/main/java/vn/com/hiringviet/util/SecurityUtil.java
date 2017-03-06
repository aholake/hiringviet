package vn.com.hiringviet.util;

import com.google.appengine.repackaged.com.google.api.client.util.Base64;

// TODO: Auto-generated Javadoc
/**
 * The Class SecurityUtil.
 */
public class SecurityUtil {
	
	/**
	 * Encode string to base64.
	 *
	 * @param orgininalText the orgininal text
	 * @return the string
	 */
	public static String encodeStringToBase64(String orgininalText) {
		return Base64.encodeBase64String(orgininalText.getBytes());
	}
	
	/**
	 * The main method.
	 *
	 * @param args the arguments
	 */
	public static void main(String[] args) {
		System.out.println(encodeStringToBase64("11221122"));
	}
}
