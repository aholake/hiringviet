package vn.com.hiringviet.common;

// TODO: Auto-generated Javadoc
/**
 * The Enum PagingEnum.
 */
public enum PagingEnum {

	/** The first. */
	FIRST(0),
	
	/** The max. */
	MAX(10);

	/** The value. */
	private int value;

	/**
	 * Instantiates a new paging enum.
	 *
	 * @param value the value
	 */
	private PagingEnum(int value) {
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

