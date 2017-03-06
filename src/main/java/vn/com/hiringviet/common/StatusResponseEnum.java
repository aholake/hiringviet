package vn.com.hiringviet.common;

// TODO: Auto-generated Javadoc
/**
 * The Enum StatusResponseEnum.
 */
public enum StatusResponseEnum {

	/** The success. */
	SUCCESS(1), /** The fail. */
 FAIL(0);

	/** The value. */
	private int value;

	/**
	 * Instantiates a new status response enum.
	 *
	 * @param value the value
	 */
	private StatusResponseEnum(int value) {
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
		return name().toLowerCase();
	}
}
