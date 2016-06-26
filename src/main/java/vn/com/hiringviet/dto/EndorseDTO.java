package vn.com.hiringviet.dto;

import java.io.Serializable;

import vn.com.hiringviet.model.Account;

public class EndorseDTO implements Serializable {

	private static final long serialVersionUID = 2600941758948346498L;

	private Integer skillResumeId;

	private Account account;

	public Integer getSkillResumeId() {
		return skillResumeId;
	}

	public void setSkillResumeId(Integer skillResumeId) {
		this.skillResumeId = skillResumeId;
	}

	public Account getAccount() {
		return account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}

}
