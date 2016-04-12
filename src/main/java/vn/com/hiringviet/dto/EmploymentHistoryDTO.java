package vn.com.hiringviet.dto;

import java.io.Serializable;
import java.util.Date;

public class EmploymentHistoryDTO implements Serializable {

	private static final long serialVersionUID = 4962308394934505729L;

	private Integer empHistoryID;

	private Integer resumeID;

	private Integer companyID;

	private Integer positionID;

	private Date fromDate;

	private Date toDate;

	private Integer status;

	private Date createdAt;

	private Date updatedAt;

	private Date deletedAt;

	public EmploymentHistoryDTO() {
		super();
	}

	public Integer getEmpHistoryID() {
		return empHistoryID;
	}

	public void setEmpHistoryID(Integer empHistoryID) {
		this.empHistoryID = empHistoryID;
	}

	public Integer getResumeID() {
		return resumeID;
	}

	public void setResumeID(Integer resumeID) {
		this.resumeID = resumeID;
	}

	public Integer getCompanyID() {
		return companyID;
	}

	public void setCompanyID(Integer companyID) {
		this.companyID = companyID;
	}

	public Integer getPositionID() {
		return positionID;
	}

	public void setPositionID(Integer positionID) {
		this.positionID = positionID;
	}

	public Date getFromDate() {
		return fromDate;
	}

	public void setFromDate(Date fromDate) {
		this.fromDate = fromDate;
	}

	public Date getToDate() {
		return toDate;
	}

	public void setToDate(Date toDate) {
		this.toDate = toDate;
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
