package vn.com.hiringviet.common;

// TODO: Auto-generated Javadoc
/**
 * The Enum SearchEnum.
 */
public enum SearchEnum {

	/** The all. */
	ALL(0),
	
	/** The skill. */
	SKILL(1),
	
	/** The member. */
	MEMBER(2),
	
	/** The company. */
	COMPANY(3),
	
	/** The job. */
	JOB(4);

	/** The value. */
	private int value;

	/**
	 * Instantiates a new search enum.
	 *
	 * @param value the value
	 */
	private SearchEnum(int value) {
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
