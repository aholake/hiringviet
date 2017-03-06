package vn.com.hiringviet.common;

// TODO: Auto-generated Javadoc
/**
 * The Enum ModeEnum.
 */
public enum ModeEnum {

	/** The home. */
	HOME("HOME"),
	
	/** The career. */
	CAREER("CAREER");

	/** The value. */
	private String value;

	/**
	 * Instantiates a new mode enum.
	 *
	 * @param value the value
	 */
	private ModeEnum(String value) {
		this.value = value;
	}

	/**
	 * Gets the value.
	 *
	 * @return the value
	 */
	public String getValue() {
		return this.value;
	}
}
