package vn.com.hiringviet.common;

public enum MemberRoleEnum {

	ADMIN(0), USER(1), COMPANY(2);

	private int value;

	private MemberRoleEnum(int value) {
		this.value = value;
	}

	public int getValue() {
		return this.value;
	}
}
