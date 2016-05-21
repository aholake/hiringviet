package vn.com.hiringviet.dto;

import java.io.Serializable;
import java.util.Date;

public class EmploymentHistoryDTO implements Serializable {

	private static final long serialVersionUID = 4962308394934505729L;

	private Integer empHistoryID;

	private ResumeDTO resume;

	private String companyNAME;

	private PositionDTO position;

	private Date fromDate;

	private Date toDate;

	private String description;

	private Integer status;

	private Date createdAt;

	private Date updatedAt;

	private Date deletedAt;

	public Integer getEmpHistoryID() {
		return empHistoryID;
	}

	public void setEmpHistoryID(Integer empHistoryID) {
		this.empHistoryID = empHistoryID;
	}

	public ResumeDTO getResume() {
		return resume;
	}

	public void setResume(ResumeDTO resume) {
		this.resume = resume;
	}

	public String getCompanyNAME() {
		return companyNAME;
	}

	public void setCompanyNAME(String companyNAME) {
		this.companyNAME = companyNAME;
	}

	public PositionDTO getPosition() {
		return position;
	}

	public void setPosition(PositionDTO position) {
		this.position = position;
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

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
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
