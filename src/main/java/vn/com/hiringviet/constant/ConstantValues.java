package vn.com.hiringviet.constant;

import java.util.Properties;

import vn.com.hiringviet.util.FileUtil;

/**
 * Contain all final value
 * 
 * @author TA
 *
 */
public class ConstantValues {

	public static final Properties CONFIG_PROPS = FileUtil.getProperties();

	public static final int EXPIRY_TIME_COOKIE = 60 * 60 * 24 * 7;

	public static final String COOKIE_PATH = "/";
}
