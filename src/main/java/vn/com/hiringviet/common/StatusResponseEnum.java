package vn.com.hiringviet.common;

public enum StatusResponseEnum {

	SUCCESS(1), FAIL(0);

	private int value;

	private StatusResponseEnum(int value) {
		this.value = value;
	}

	public int getValue() {
		return this.value;
	}

	public String getStatus() {
		return name().toLowerCase();
	}
}
