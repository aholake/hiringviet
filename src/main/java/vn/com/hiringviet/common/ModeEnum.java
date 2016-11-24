package vn.com.hiringviet.common;

public enum ModeEnum {

	HOME("HOME"),
	CAREER("CAREER");

	private String value;

	private ModeEnum(String value) {
		this.value = value;
	}

	public String getValue() {
		return this.value;
	}
}
