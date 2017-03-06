package vn.com.hiringviet.api.dto.response;

// TODO: Auto-generated Javadoc
/**
 * The Class ExportEducationHistDTO.
 */
public class ExportEducationHistDTO {

	/** The university name. */
	private String universityName;

	/** The major name. */
	private String majorName;

	/** The begin year. */
	private Integer beginYear;

	/** The end year. */
	private Integer endYear;

	/** The degree. */
	private String degree;

	/** The social activity. */
	private String socialActivity;

	/**
	 * Instantiates a new export education hist dto.
	 *
	 * @param universityName the university name
	 * @param majorName the major name
	 * @param beginYear the begin year
	 * @param endYear the end year
	 * @param degree the degree
	 * @param socialActivity the social activity
	 */
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

	/**
	 * Gets the university name.
	 *
	 * @return the university name
	 */
	public String getUniversityName() {
		return universityName;
	}

	/**
	 * Sets the university name.
	 *
	 * @param universityName the new university name
	 */
	public void setUniversityName(String universityName) {
		this.universityName = universityName;
	}

	/**
	 * Gets the major name.
	 *
	 * @return the major name
	 */
	public String getMajorName() {
		return majorName;
	}

	/**
	 * Sets the major name.
	 *
	 * @param majorName the new major name
	 */
	public void setMajorName(String majorName) {
		this.majorName = majorName;
	}

	/**
	 * Gets the begin year.
	 *
	 * @return the begin year
	 */
	public Integer getBeginYear() {
		return beginYear;
	}

	/**
	 * Sets the begin year.
	 *
	 * @param beginYear the new begin year
	 */
	public void setBeginYear(Integer beginYear) {
		this.beginYear = beginYear;
	}

	/**
	 * Gets the end year.
	 *
	 * @return the end year
	 */
	public Integer getEndYear() {
		return endYear;
	}

	/**
	 * Sets the end year.
	 *
	 * @param endYear the new end year
	 */
	public void setEndYear(Integer endYear) {
		this.endYear = endYear;
	}

	/**
	 * Gets the degree.
	 *
	 * @return the degree
	 */
	public String getDegree() {
		return degree;
	}

	/**
	 * Sets the degree.
	 *
	 * @param degree the new degree
	 */
	public void setDegree(String degree) {
		this.degree = degree;
	}

	/**
	 * Gets the social activity.
	 *
	 * @return the social activity
	 */
	public String getSocialActivity() {
		return socialActivity;
	}

	/**
	 * Sets the social activity.
	 *
	 * @param socialActivity the new social activity
	 */
	public void setSocialActivity(String socialActivity) {
		this.socialActivity = socialActivity;
	}

}
