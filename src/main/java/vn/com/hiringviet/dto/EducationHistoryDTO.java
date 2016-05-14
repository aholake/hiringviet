package vn.com.hiringviet.dto;

import java.io.Serializable;
import java.util.Date;

import vn.com.hiringviet.model.Degree;
import vn.com.hiringviet.model.Resume;

public class EducationHistoryDTO implements Serializable {

	private static final long serialVersionUID = -247002098097375475L;

	private Integer eduHistoryID;

	private Resume resume;

	private Degree degree;

	private String universityName;

	private String majorName;

	private Integer beginYear;

	private Integer endYear;

	private String activityAndSocueties;

	private Integer status;

	private Date createdAt;

	private Date updatedAt;

	private Date deletedAt;

	public Integer getEduHistoryID() {
		return eduHistoryID;
	}

	public void setEduHistoryID(Integer eduHistoryID) {
		this.eduHistoryID = eduHistoryID;
	}

	public Resume getResume() {
		return resume;
	}

	public void setResume(Resume resume) {
		this.resume = resume;
	}

	public Degree getDegree() {
		return degree;
	}

	public void setDegree(Degree degree) {
		this.degree = degree;
	}

	public String getUniversityName() {
		return universityName;
	}

	public void setUniversityName(String universityName) {
		this.universityName = universityName;
	}

	public String getMajorName() {
		return majorName;
	}

	public void setMajorName(String majorName) {
		this.majorName = majorName;
	}

	public Integer getBeginYear() {
		return beginYear;
	}

	public void setBeginYear(Integer beginYear) {
		this.beginYear = beginYear;
	}

	public Integer getEndYear() {
		return endYear;
	}

	public void setEndYear(Integer endYear) {
		this.endYear = endYear;
	}

	public String getActivityAndSocueties() {
		return activityAndSocueties;
	}

	public void setActivityAndSocueties(String activityAndSocueties) {
		this.activityAndSocueties = activityAndSocueties;
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
