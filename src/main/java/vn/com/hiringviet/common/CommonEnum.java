package vn.com.hiringviet.common;

public enum CommonEnum {

	FOLLOW(11),
	REPLY_COMMENT(22);

	private int value;

	private CommonEnum(int value) {
		this.value = value;
	}

	public int getValue() {
		return this.value;
	}

	public String getStatus() {
		return this.name().toUpperCase();
	}
}

