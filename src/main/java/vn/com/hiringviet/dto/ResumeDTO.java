package vn.com.hiringviet.dto;

import java.io.Serializable;

public class ResumeDTO implements Serializable {

	private static final long serialVersionUID = 4568694958130038912L;

	private Integer accountId;

	private Integer resumeId;

	private Integer skillId;

	public Integer getAccountId() {
		return accountId;
	}

	public void setAccountId(Integer accountId) {
		this.accountId = accountId;
	}

	public Integer getResumeId() {
		return resumeId;
	}

	public void setResumeId(Integer resumeId) {
		this.resumeId = resumeId;
	}

	public Integer getSkillId() {
		return skillId;
	}

	public void setSkillId(Integer skillId) {
		this.skillId = skillId;
	}

}
