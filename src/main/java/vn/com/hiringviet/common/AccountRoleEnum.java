package vn.com.hiringviet.common;

// TODO: Auto-generated Javadoc
/**
 * The Enum AccountRoleEnum.
 */
public enum AccountRoleEnum {

	/** The admin. */
	ADMIN(0), /** The user. */
 USER(1), /** The company. */
 COMPANY(2);

	/** The value. */
	private int value;

	/**
	 * Instantiates a new account role enum.
	 *
	 * @param value the value
	 */
	private AccountRoleEnum(int value) {
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
