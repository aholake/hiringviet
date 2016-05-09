package vn.com.hiringviet.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "JOB_CATEGORY", catalog = "hiringviet")
public class JobCategory implements Serializable {

	private static final long serialVersionUID = -7098623801141057102L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "JOB_CATEGORY_ID", nullable = false, length = 11)
	private Integer jobCategoryID;

	@Column(name = "CATEGORY_NAME", nullable = false, length = 11)
	private Integer categoryNAME;

	@Column(name = "STATUS", nullable = false)
	private Integer status;

	@Column(name = "CREATE_AT", nullable = false)
	private Date createdAt;

	@Column(name = "UPDATE_AT", nullable = false)
	private Date updatedAt;

	@Column(name = "DELETE_AT")
	private Date deletedAt;

	public JobCategory() {
		super();
	}

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

}