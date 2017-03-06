package vn.com.hiringviet.constant;

import java.util.Properties;

import vn.com.hiringviet.util.FileUtil;

// TODO: Auto-generated Javadoc
/**
 * Contain all final value.
 *
 * @author TA
 */
public class ConstantValues {

	/** The Constant CONFIG_PROPS. */
	public static final Properties CONFIG_PROPS = FileUtil.getConfigProperties();
	
	/** The Constant MESSAGE_PROPS. */
	public static final Properties MESSAGE_PROPS = FileUtil.getMessageProperties();

	/** The Constant EXPIRY_TIME_COOKIE. */
	public static final int EXPIRY_TIME_COOKIE = 60 * 60 * 24 * 7;

	/** The Constant COOKIE_PATH. */
	public static final String COOKIE_PATH = "/";

	/** The Constant FIRST_RECORD. */
	public static final Integer FIRST_RECORD = 0;

	/** The Constant MAX_RECORD_COUNT. */
	public static final Integer MAX_RECORD_COUNT = 5;

	/** The Constant CURRENT_PAGE. */
	public static final Integer CURRENT_PAGE = 1;

	/** The Constant VN_LOCALE. */
	public static final String VN_LOCALE = "VN";
	
	/** The Constant EN_LOCALE. */
	public static final String EN_LOCALE = "EN";
	
	/** The Constant MODE_COMPANY_HOME. */
	public static final String MODE_COMPANY_HOME = "HOME";
	
	/** The Constant MODE_COMPANY_CAREER. */
	public static final String MODE_COMPANY_CAREER = "CAREER";
}
