package vn.com.hiringviet.dto;

import java.io.Serializable;

// TODO: Auto-generated Javadoc
/**
 * The Class SearchDTO.
 */
public class SearchDTO implements Serializable {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 5195721914396157266L;

	/** The skill id. */
	private Integer skillId;

	/** The skill. */
	private String skill;

	/** The job title. */
	private String jobTitle;

	/** The company name. */
	private String companyName;

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
	 * Gets the skill.
	 *
	 * @return the skill
	 */
	public String getSkill() {
		return skill;
	}

	/**
	 * Sets the skill.
	 *
	 * @param skill the new skill
	 */
	public void setSkill(String skill) {
		this.skill = skill;
	}

	/**
	 * Gets the job title.
	 *
	 * @return the job title
	 */
	public String getJobTitle() {
		return jobTitle;
	}

	/**
	 * Sets the job title.
	 *
	 * @param jobTitle the new job title
	 */
	public void setJobTitle(String jobTitle) {
		this.jobTitle = jobTitle;
	}

	/**
	 * Gets the company name.
	 *
	 * @return the company name
	 */
	public String getCompanyName() {
		return companyName;
	}

	/**
	 * Sets the company name.
	 *
	 * @param companyName the new company name
	 */
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

}
