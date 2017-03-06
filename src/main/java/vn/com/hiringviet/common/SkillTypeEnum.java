package vn.com.hiringviet.common;

// TODO: Auto-generated Javadoc
/**
 * The Enum SkillTypeEnum.
 */
public enum SkillTypeEnum {

	/** The top. */
	TOP(1),
	
	/** The different. */
	DIFFERENT(0);

	/** The value. */
	private int value;

	/**
	 * Instantiates a new skill type enum.
	 *
	 * @param value the value
	 */
	private SkillTypeEnum(int value) {
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
