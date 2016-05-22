package vn.com.hiringviet.dto;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
public class PositionDTO implements Serializable {

	private static final long serialVersionUID = -45982404463146068L;

	private Integer positionID;

	private String displayName;

	private Integer status;

	private Date createdAt;

	private Date updatedAt;

	@JsonIgnore
	private List<EmploymentHistoryDTO> employmentHistorySet;

	@JsonIgnore
	private List<JobDTO> jobSet;

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

	public List<EmploymentHistoryDTO> getEmploymentHistorySet() {
		return employmentHistorySet;
	}

	public void setEmploymentHistorySet(
			List<EmploymentHistoryDTO> employmentHistorySet) {
		this.employmentHistorySet = employmentHistorySet;
	}

	public List<JobDTO> getJobSet() {
		return jobSet;
	}

	public void setJobSet(List<JobDTO> jobSet) {
		this.jobSet = jobSet;
	}

}
