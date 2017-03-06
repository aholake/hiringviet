package vn.com.hiringviet.dto;

import java.io.Serializable;

// TODO: Auto-generated Javadoc
/**
 * The Class ResumeDTO.
 */
public class ResumeDTO implements Serializable {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 4568694958130038912L;

	/** The account id. */
	private Integer accountId;

	/** The resume id. */
	private Integer resumeId;

	/** The skill id. */
	private Integer skillId;

	/** The resume skill id. */
	private Integer resumeSkillId;

	/**
	 * Gets the account id.
	 *
	 * @return the account id
	 */
	public Integer getAccountId() {
		return accountId;
	}

	/**
	 * Sets the account id.
	 *
	 * @param accountId the new account id
	 */
	public void setAccountId(Integer accountId) {
		this.accountId = accountId;
	}

	/**
	 * Gets the resume id.
	 *
	 * @return the resume id
	 */
	public Integer getResumeId() {
		return resumeId;
	}

	/**
	 * Sets the resume id.
	 *
	 * @param resumeId the new resume id
	 */
	public void setResumeId(Integer resumeId) {
		this.resumeId = resumeId;
	}

	/**
	 * Gets the skill id.
	 *
	 * @return the skill id
	 */
	public Integer getSkillId() {
		return skillId;
	}

	/**
	 * Sets the skill id.
	 *
	 * @param skillId the new skill id
	 */
	public void setSkillId(Integer skillId) {
		this.skillId = skillId;
	}

	/**
	 * Gets the resume skill id.
	 *
	 * @return the resume skill id
	 */
	public Integer getResumeSkillId() {
		return resumeSkillId;
	}

	/**
	 * Sets the resume skill id.
	 *
	 * @param resumeSkillId the new resume skill id
	 */
	public void setResumeSkillId(Integer resumeSkillId) {
		this.resumeSkillId = resumeSkillId;
	}

}
