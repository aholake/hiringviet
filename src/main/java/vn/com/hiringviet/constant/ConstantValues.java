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

	public static final Integer FIRST_RECORD = 0;

	public static final Integer MAX_RECORD_COUNT = 5;

	public static final Integer CURRENT_PAGE = 1;

	public static final String VN_LOCALE = "VN";
	public static final String EN_LOCALE = "EN";
	
	public static final String MODE_COMPANY_HOME = "HOME";
	public static final String MODE_COMPANY_CAREER = "CAREER";
}
