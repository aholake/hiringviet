package vn.com.hiringviet.common;

// TODO: Auto-generated Javadoc
/**
 * The Enum StatusEnum.
 */
public enum StatusEnum {

	/** The inactive. */
	INACTIVE(0),
	
	/** The active. */
	ACTIVE(1),
	
	/** The delete. */
	DELETE(9);

	/** The value. */
	private int value;

	/**
	 * Instantiates a new status enum.
	 *
	 * @param value the value
	 */
	private StatusEnum(int value) {
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
}

