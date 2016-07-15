package vn.com.hiringviet.common;

public enum DegreeEnum {

	D1("After university"),
	D2("University"),
	D3("Higher"),
	D4("Intermediate"),
	D5("Lower intermediate");
	
	private String value;

	private DegreeEnum(String value) {
		this.value = value;
	}

	public String getValue() {
		return this.value;
	}

	public String getStatus() {
		return name();
	}
}
