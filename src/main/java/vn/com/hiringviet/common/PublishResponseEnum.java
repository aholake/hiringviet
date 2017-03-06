package vn.com.hiringviet.common;

// TODO: Auto-generated Javadoc
/**
 * The Enum PublishResponseEnum.
 */
public enum PublishResponseEnum {

	/** The publish. */
	PUBLISH(true),
	
	/** The not publish. */
	NOT_PUBLISH(false);

	/** The value. */
	private boolean value;

	/**
	 * Instantiates a new publish response enum.
	 *
	 * @param value the value
	 */
	private PublishResponseEnum(boolean value) {
		this.value = value;
	}

	/**
	 * Gets the value.
	 *
	 * @return the value
	 */
	public boolean getValue() {
		return this.value;
	}
}
