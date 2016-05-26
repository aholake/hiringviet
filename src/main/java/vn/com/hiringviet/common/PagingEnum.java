package vn.com.hiringviet.common;

public enum PagingEnum {

	FIRST(0),
	MAX(10);

	private int value;

	private PagingEnum(int value) {
		this.value = value;
	}

	public int getValue() {
		return this.value;
	}
}

