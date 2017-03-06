package vn.com.hiringviet.dto;

import java.io.Serializable;

import vn.com.hiringviet.model.Account;

// TODO: Auto-generated Javadoc
/**
 * The Class EndorseDTO.
 */
public class EndorseDTO implements Serializable {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 2600941758948346498L;

	/** The skill resume id. */
	private Integer skillResumeId;

	/** The account. */
	private Account account;

	/**
	 * Gets the skill resume id.
	 *
	 * @return the skill resume id
	 */
	public Integer getSkillResumeId() {
		return skillResumeId;
	}

	/**
	 * Sets the skill resume id.
	 *
	 * @param skillResumeId the new skill resume id
	 */
	public void setSkillResumeId(Integer skillResumeId) {
		this.skillResumeId = skillResumeId;
	}

	/**
	 * Gets the account.
	 *
	 * @return the account
	 */
	public Account getAccount() {
		return account;
	}

	/**
	 * Sets the account.
	 *
	 * @param account the new account
	 */
	public void setAccount(Account account) {
		this.account = account;
	}

}
