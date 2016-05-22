package vn.com.hiringviet.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Type;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "EDUCATION_HISTORY", catalog = "hiringviet")
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })

public class EducationHistory implements Serializable {

	private static final long serialVersionUID = -247002098097375475L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "EDU_HISTORY_ID", nullable = false, length = 11)
	private Integer eduHistoryID;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "RESUME_ID", nullable = false)
	private Resume resume;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "DEGREE_ID", nullable = false)
	private Degree degree;

	@Column(name = "UNIVERSITY_NAME", nullable = false, length = 200)
	private String universityName;

	@Column(name = "MAJOR_NAME", nullable = false, length = 200)
	private String majorName;

	@Column(name = "BEGIN_YEAR", nullable = false, length = 4)
	private Integer beginYear;

	@Column(name = "END_YEAR", nullable = false, length = 4)
	private Integer endYear;

	@Column(name = "ACTIVITY_AND_SOCUETIES")
	@Type(type = "text")
	private String activityAndSocueties;

	@Column(name = "STATUS", nullable = false)
	private Integer status;

	@Column(name = "CREATED_AT", nullable = false)
	private Date createdAt;

	@Column(name = "UPDATED_AT", nullable = false)
	private Date updatedAt;

	@Column(name = "DELETED_AT")
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
