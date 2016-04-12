package vn.com.hiringviet.dto;

import java.io.Serializable;
import java.util.Date;

public class EducationHistoryDTO implements Serializable {

	private static final long serialVersionUID = -247002098097375475L;

	private Integer eduHistoryID;

	private Integer resumeID;

	private String universityName;

	private int beginYear;

	private int endYear;

	private String major;

	private Integer status;

	private Date createdAt;

	private Date updatedAt;

	private Date deletedAt;

	public EducationHistoryDTO() {
		super();
	}

	public Integer getEduHistoryID() {
		return eduHistoryID;
	}

	public void setEduHistoryID(Integer eduHistoryID) {
		this.eduHistoryID = eduHistoryID;
	}

	public Integer getResumeID() {
		return resumeID;
	}

	public void setResumeID(Integer resumeID) {
		this.resumeID = resumeID;
	}

	public String getUniversityName() {
		return universityName;
	}

	public void setUniversityName(String universityName) {
		this.universityName = universityName;
	}

	public int getBeginYear() {
		return beginYear;
	}

	public void setBeginYear(int beginYear) {
		this.beginYear = beginYear;
	}

	public int getEndYear() {
		return endYear;
	}

	public void setEndYear(int endYear) {
		this.endYear = endYear;
	}

	public String getMajor() {
		return major;
	}

	public void setMajor(String major) {
		this.major = major;
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
