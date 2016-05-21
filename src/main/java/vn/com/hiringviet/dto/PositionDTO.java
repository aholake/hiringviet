package vn.com.hiringviet.dto;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class PositionDTO implements Serializable {

	private static final long serialVersionUID = -45982404463146068L;

	private Integer positionID;

	private String displayName;

	private Integer status;

	private Date createdAt;

	private Date updatedAt;

	@JsonIgnore
	private Set<EmploymentHistoryDTO> employmentHistorySet;

	@JsonIgnore
	private Set<JobDTO> jobSet;

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

	public Set<EmploymentHistoryDTO> getEmploymentHistorySet() {
		return employmentHistorySet;
	}

	public void setEmploymentHistorySet(
			Set<EmploymentHistoryDTO> employmentHistorySet) {
		this.employmentHistorySet = employmentHistorySet;
	}

	public Set<JobDTO> getJobSet() {
		return jobSet;
	}

	public void setJobSet(Set<JobDTO> jobSet) {
		this.jobSet = jobSet;
	}

}
