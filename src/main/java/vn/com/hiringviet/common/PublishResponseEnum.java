package vn.com.hiringviet.common;

public enum PublishResponseEnum {

	PUBLISH(true),
	NOT_PUBLISH(false);

	private boolean value;

	private PublishResponseEnum(boolean value) {
		this.value = value;
	}

	public boolean getValue() {
		return this.value;
	}
}
