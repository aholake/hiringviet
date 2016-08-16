package vn.com.hiringviet.common;

public enum AccountRoleEnum {

	ADMIN(0), USER(1), COMPANY(2);

	private int value;

	private AccountRoleEnum(int value) {
		this.value = value;
	}

	public int getValue() {
		return this.value;
	}
}
