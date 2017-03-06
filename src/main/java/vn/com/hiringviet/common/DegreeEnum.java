package vn.com.hiringviet.common;

// TODO: Auto-generated Javadoc
/**
 * The Enum DegreeEnum.
 */
public enum DegreeEnum {

	/** The D1. */
	D1("After university"),
	
	/** The D2. */
	D2("University"),
	
	/** The D3. */
	D3("Higher"),
	
	/** The D4. */
	D4("Intermediate"),
	
	/** The D5. */
	D5("Lower intermediate");
	
	/** The value. */
	private String value;

	/**
	 * Instantiates a new degree enum.
	 *
	 * @param value the value
	 */
	private DegreeEnum(String value) {
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

	/**
	 * Gets the status.
	 *
	 * @return the status
	 */
	public String getStatus() {
		return name();
	}
}
