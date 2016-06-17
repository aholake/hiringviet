package vn.com.hiringviet.common;

public enum PublishResponseEnum {

	PUBLISH(1),
	NOT_PUBLISH(0);

	private int value;

	private PublishResponseEnum(int value) {
		this.value = value;
	}

	public int getValue() {
		return this.value;
	}
}
