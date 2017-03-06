package vn.com.hiringviet.common;

// TODO: Auto-generated Javadoc
/**
 * The Enum CommonEnum.
 */
public enum CommonEnum {

	/** The follow. */
	FOLLOW(11),
	
	/** The reply comment. */
	REPLY_COMMENT(22);

	/** The value. */
	private int value;

	/**
	 * Instantiates a new common enum.
	 *
	 * @param value the value
	 */
	private CommonEnum(int value) {
		this.value = value;
	}

	/**
	 * Gets the value.
	 *
	 * @return the value
	 */
	public int getValue() {
		return this.value;
	}

	/**
	 * Gets the status.
	 *
	 * @return the status
	 */
	public String getStatus() {
		return this.name().toUpperCase();
	}
}

