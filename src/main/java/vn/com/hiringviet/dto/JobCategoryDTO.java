package vn.com.hiringviet.dto;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class JobCategoryDTO implements Serializable {

	private static final long serialVersionUID = -7098623801141057102L;

	private Integer jobCategoryID;

	private String categoryNAME;

	private Integer status;

	private Date createdAt;

	private Date updatedAt;

	private Date deletedAt;

	@JsonIgnore
	private Set<JobDTO> jobSet;

	public Integer getJobCategoryID() {
		return jobCategoryID;
	}

	public void setJobCategoryID(Integer jobCategoryID) {
		this.jobCategoryID = jobCategoryID;
	}

	public String getCategoryNAME() {
		return categoryNAME;
	}

	public void setCategoryNAME(String categoryNAME) {
		this.categoryNAME = categoryNAME;
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

	public Set<JobDTO> getJobSet() {
		return jobSet;
	}

	public void setJobSet(Set<JobDTO> jobSet) {
		this.jobSet = jobSet;
	}
}
