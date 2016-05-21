package vn.com.hiringviet.dto;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

import vn.com.hiringviet.model.EmploymentHistory;
import vn.com.hiringviet.model.Job;

public class PositionDTO implements Serializable {

	private static final long serialVersionUID = -45982404463146068L;

	private Integer positionID;

	private String displayName;

	private Integer status;

	private Date createdAt;

	private Date updatedAt;

	private Set<EmploymentHistory> employmentHistorySet;

	private Set<Job> jobSet;

	public Integer getPositionID() {
		return positionID;
	}

	public void setPositionID(Integer positionID) {
		this.positionID = positionID;
	}

	public String getDisplayName() {
		return displayName;
	}

	public void setDisplayName(String displayName) {
		this.displayName = displayName;
	}

	public Set<Job> getJobSet() {
		return jobSet;
	}

	public void setJobDTOSet(Set<Job> jobSet) {
		this.jobSet = jobSet;
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

	public Set<EmploymentHistory> getEmploymentHistorySet() {
		return employmentHistorySet;
	}

	public void setEmploymentHistorySet(
			Set<EmploymentHistory> employmentHistorySet) {
		this.employmentHistorySet = employmentHistorySet;
	}

}
