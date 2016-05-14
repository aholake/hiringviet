package vn.com.hiringviet.dto;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

import vn.com.hiringviet.model.Job;

public class JobCategoryDTO implements Serializable {

	private static final long serialVersionUID = -7098623801141057102L;

	private Integer jobCategoryID;

	private Integer categoryNAME;

	private Integer status;

	private Date createdAt;

	private Date updatedAt;

	private Date deletedAt;

	private Set<Job> jobSet;

	public Integer getJobCategoryID() {
		return jobCategoryID;
	}

	public void setJobCategoryID(Integer jobCategoryID) {
		this.jobCategoryID = jobCategoryID;
	}

	public Integer getCategoryNAME() {
		return categoryNAME;
	}

	public void setCategoryNAME(Integer categoryNAME) {
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

	public Set<Job> getJobSet() {
		return jobSet;
	}

	public void setJobSet(Set<Job> jobSet) {
		this.jobSet = jobSet;
	}

}
