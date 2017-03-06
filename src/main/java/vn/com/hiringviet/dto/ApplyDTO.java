package vn.com.hiringviet.dto;

import java.io.Serializable;

// TODO: Auto-generated Javadoc
/**
 * The Class ApplyDTO.
 */
public class ApplyDTO implements Serializable {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 3351635070229440700L;

	/** The job list. */
	private String jobList;

	/** The curriculum vitae. */
	private String curriculumVitae;

	/** The description. */
	private String description;

	/** The member name. */
	private String memberName;

	/** The job id. */
	private String jobId;

	/** The member email. */
	private String memberEmail;

	/** The member phone number. */
	private String memberPhoneNumber;

	/**
	 * Gets the job list.
	 *
	 * @return the job list
	 */
	public String getJobList() {
		return jobList;
	}

	/**
	 * Sets the job list.
	 *
	 * @param jobList the new job list
	 */
	public void setJobList(String jobList) {
		this.jobList = jobList;
	}

	/**
	 * Gets the description.
	 *
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * Sets the description.
	 *
	 * @param description the new description
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * Gets the curriculum vitae.
	 *
	 * @return the curriculum vitae
	 */
	public String getCurriculumVitae() {
		return curriculumVitae;
	}

	/**
	 * Sets the curriculum vitae.
	 *
	 * @param curriculumVitae the new curriculum vitae
	 */
	public void setCurriculumVitae(String curriculumVitae) {
		this.curriculumVitae = curriculumVitae;
	}

	/**
	 * Gets the member name.
	 *
	 * @return the member name
	 */
	public String getMemberName() {
		return memberName;
	}

	/**
	 * Sets the member name.
	 *
	 * @param memberName the new member name
	 */
	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}

	/**
	 * Gets the job id.
	 *
	 * @return the job id
	 */
	public String getJobId() {
		return jobId;
	}

	/**
	 * Sets the job id.
	 *
	 * @param jobId the new job id
	 */
	public void setJobId(String jobId) {
		this.jobId = jobId;
	}

	/**
	 * Gets the member email.
	 *
	 * @return the member email
	 */
	public String getMemberEmail() {
		return memberEmail;
	}

	/**
	 * Sets the member email.
	 *
	 * @param memberEmail the new member email
	 */
	public void setMemberEmail(String memberEmail) {
		this.memberEmail = memberEmail;
	}

	/**
	 * Gets the member phone number.
	 *
	 * @return the member phone number
	 */
	public String getMemberPhoneNumber() {
		return memberPhoneNumber;
	}

	/**
	 * Sets the member phone number.
	 *
	 * @param memberPhoneNumber the new member phone number
	 */
	public void setMemberPhoneNumber(String memberPhoneNumber) {
		this.memberPhoneNumber = memberPhoneNumber;
	}

}
