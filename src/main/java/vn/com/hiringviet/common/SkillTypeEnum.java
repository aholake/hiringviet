package vn.com.hiringviet.common;

public enum SkillTypeEnum {

	TOP(1),
	DIFFERENT(0);

	private int value;

	private SkillTypeEnum(int value) {
		this.value = value;
	}

	public int getValue() {
		return this.value;
	}
}
