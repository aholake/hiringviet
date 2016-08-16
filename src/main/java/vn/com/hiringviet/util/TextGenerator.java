package vn.com.hiringviet.util;

import java.util.Random;

public class TextGenerator {
	public static final int RANDOM_ACTIVE_STRING_LENGTH = 10;

	public static String generateRandomString(int length) {
		Random rng = new Random();
		String characters = "AaBbCcDdEeFfGgHhIiKkLlMmNnOoPpTtVvUuXxYyZzWw";
		char[] text = new char[length];
		for (int i = 0; i < length; i++) {
			text[i] = characters.charAt(rng.nextInt(characters.length()));
		}
		return new String(text);
	}
}
