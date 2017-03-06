package vn.com.hiringviet.common;

// TODO: Auto-generated Javadoc
/**
 * The Enum LoggerEnum.
 */
public enum LoggerEnum {

	/** The activity. */
	ACTIVITY(1),
	
	/** The notification. */
	NOTIFICATION(0);

	/** The value. */
	private int value;

	/**
	 * Instantiates a new logger enum.
	 *
	 * @param value the value
	 */
	private LoggerEnum(int value) {
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
