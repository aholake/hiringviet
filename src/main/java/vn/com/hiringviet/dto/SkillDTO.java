package vn.com.hiringviet.dto;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

import vn.com.hiringviet.model.Endorse;
import vn.com.hiringviet.model.Job;

public class SkillDTO implements Serializable {

	private static final long serialVersionUID = -5381027238277880906L;

	private Integer skillID;

	private String displayName;

	private Integer status;

	private Date createdAt;

	private Date updatedAt;

	private Date deletedAt;

	private Set<ResumeDTO> resumeSet;

	private Set<Job> jobSet;

	private Set<Endorse> endorseSet;

	public Integer getSkillID() {
		return skillID;
	}

	public void setSkillID(Integer skillID) {
		this.skillID = skillID;
	}

	public String getDisplayName() {
		return displayName;
	}

	public void setDisplayName(String displayName) {
		this.displayName = displayName;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public Date getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}

	public Date getDeletedAt() {
		return deletedAt;
	}

	public void setDeletedAt(Date deletedAt) {
		this.deletedAt = deletedAt;
	}

	public Set<ResumeDTO> getResumeSet() {
		return resumeSet;
	}

	public void setResumeSet(Set<ResumeDTO> resumeSet) {
		this.resumeSet = resumeSet;
	}

	public Set<Job> getJobSet() {
		return jobSet;
	}

	public void setJobSet(Set<Job> jobSet) {
		this.jobSet = jobSet;
	}

	public Set<Endorse> getEndorseSet() {
		return endorseSet;
	}

	public void setEndorseSet(Set<Endorse> endorseSet) {
		this.endorseSet = endorseSet;
	}

}
