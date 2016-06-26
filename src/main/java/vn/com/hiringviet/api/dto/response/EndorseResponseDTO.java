package vn.com.hiringviet.api.dto.response;

import java.io.Serializable;

import vn.com.hiringviet.model.Account;

public class EndorseResponseDTO extends CommonResponseDTO implements Serializable {

	private static final long serialVersionUID = 4666420050809812144L;

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
