package vn.com.hiringviet.common;

public enum StatusEnum {

	INACTIVE(0),
	ACTIVE(1),
	DELETE(9);

	private int value;

	private StatusEnum(int value) {
		this.value = value;
	}

	public int getValue() {
		return this.value;
	}
}

