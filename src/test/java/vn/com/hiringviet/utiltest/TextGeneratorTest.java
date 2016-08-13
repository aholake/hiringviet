package vn.com.hiringviet.utiltest;

import org.junit.Test;

import vn.com.hiringviet.util.TextGenerator;

public class TextGeneratorTest {
	@Test
	public void should_return_random_test() throws Exception {
		System.out.println(TextGenerator.generateRandomString(10));
	}
}
