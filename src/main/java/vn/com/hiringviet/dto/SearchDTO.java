package vn.com.hiringviet.dto;

import java.io.Serializable;

public class SearchDTO implements Serializable {

	private static final long serialVersionUID = 5195721914396157266L;

	private Integer skillId;

	private String skill;

	private String jobTitle;

	private String companyName;

	public Integer getSkillId() {
		return skillId;
	}

	public void setSkillId(Integer skillId) {
		this.skillId = skillId;
	}

	public String getSkill() {
		return skill;
	}

	public void setSkill(String skill) {
		this.skill = skill;
	}

	public String getJobTitle() {
		return jobTitle;
	}

	public void setJobTitle(String jobTitle) {
		this.jobTitle = jobTitle;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

}
