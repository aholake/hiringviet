package vn.com.hiringviet.common;

public enum SearchEnum {

	ALL(0),
	SKILL(1),
	MEMBER(2),
	COMPANY(3),
	JOB(4);

	private int value;

	private SearchEnum(int value) {
		this.value = value;
	}

	public int getValue() {
		return this.value;
	}

	public String getStatus() {
		return this.name().toUpperCase();
	}
}
