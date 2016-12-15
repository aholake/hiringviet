package vn.com.hiringviet.dto;

import java.io.Serializable;

public class EducationHistoryDTO implements Serializable {

	private Integer id;

	private String universityName;

	private String majorName;

	private Integer beginYear;

	private Integer endYear;

	private String degree;

	private String socialActivity;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
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

	public String getDegree() {
		return degree;
	}

	public void setDegree(String degree) {
		this.degree = degree;
	}

	public String getSocialActivity() {
		return socialActivity;
	}

	public void setSocialActivity(String socialActivity) {
		this.socialActivity = socialActivity;
	}

}
