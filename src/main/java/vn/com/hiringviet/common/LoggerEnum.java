package vn.com.hiringviet.common;

public enum LoggerEnum {

	ACTIVITY(1),
	NOTIFICATION(0);

	private int value;

	private LoggerEnum(int value) {
		this.value = value;
	}

	public int getValue() {
		return this.value;
	}

	public String getStatus() {
		return this.name().toUpperCase();
	}
}
