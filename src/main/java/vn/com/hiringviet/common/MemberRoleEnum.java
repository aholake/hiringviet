package vn.com.hiringviet.common;

public enum MemberRoleEnum {

	ADMIN(2), USER(0), COMPANY(1);

	private int value;

	private MemberRoleEnum(int value) {
		this.value = value;
	}

	public int getValue() {
		return this.value;
	}
}
