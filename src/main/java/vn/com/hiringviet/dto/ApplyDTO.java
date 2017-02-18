package vn.com.hiringviet.dto;

import java.io.Serializable;

public class ApplyDTO implements Serializable {

	private static final long serialVersionUID = 3351635070229440700L;

	private String jobList;

	private String curriculumVitae;

	private String description;

	private String memberName;

	private String jobId;

	private String memberEmail;

	private String memberPhoneNumber;

	public String getJobList() {
		return jobList;
	}

	public void setJobList(String jobList) {
		this.jobList = jobList;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getCurriculumVitae() {
		return curriculumVitae;
	}

	public void setCurriculumVitae(String curriculumVitae) {
		this.curriculumVitae = curriculumVitae;
	}

	public String getMemberName() {
		return memberName;
	}

	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}

	public String getJobId() {
		return jobId;
	}

	public void setJobId(String jobId) {
		this.jobId = jobId;
	}

	public String getMemberEmail() {
		return memberEmail;
	}

	public void setMemberEmail(String memberEmail) {
		this.memberEmail = memberEmail;
	}

	public String getMemberPhoneNumber() {
		return memberPhoneNumber;
	}

	public void setMemberPhoneNumber(String memberPhoneNumber) {
		this.memberPhoneNumber = memberPhoneNumber;
	}

}
