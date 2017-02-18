package vn.com.hiringviet.api.dto.response;

public class ExportEducationHistDTO {

	private String universityName;

	private String majorName;

	private Integer beginYear;

	private Integer endYear;

	private String degree;

	private String socialActivity;

	public ExportEducationHistDTO(String universityName, String majorName,
			Integer beginYear, Integer endYear, String degree,
			String socialActivity) {

		this.universityName = universityName;
		this.majorName = majorName;
		this.beginYear = beginYear;
		this.endYear = endYear;
		this.degree = degree;
		this.socialActivity = socialActivity;
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
