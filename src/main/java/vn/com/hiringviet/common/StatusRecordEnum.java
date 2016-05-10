package vn.com.hiringviet.common;

public enum StatusRecordEnum {

	INACTIVE(0),
	ACTIVE(1),
	DELETE(9);

	private int value;

	private StatusRecordEnum(int value) {
		this.value = value;
	}

	public int getValue() {
		return this.value;
	}
}

