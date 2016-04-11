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
@Table(name = "EDUCATION_HISTORY", catalog = "hiringviet")
public class EducationHistory implements Serializable {

	private static final long serialVersionUID = -247002098097375475L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "EDU_HISTORY_ID", nullable = false, length = 11)
	private Integer eduHistoryID;

	@Column(name = "RESUME_ID", nullable = false, length = 11)
	private Integer resumeID;

	@Column(name = "UNIVERSITY_NAME", nullable = false, length = 200)
	private String universityName;

	@Column(name = "BEGIN_YEAR", nullable = false, length = 4)
	private int beginYear;

	@Column(name = "END_YEAR", nullable = false, length = 4)
	private int endYear;

	@Column(name = "MAJOR", nullable = false, length = 200)
	private String major;

	@Column(name = "STATUS", nullable = false)
	private Integer status;

	@Column(name = "CREATE_AT", nullable = false)
	private Date createdAt;

	@Column(name = "UPDATE_AT", nullable = false)
	private Date updatedAt;

	@Column(name = "DELETE_AT")
	private Date deletedAt;

	public EducationHistory() {
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
