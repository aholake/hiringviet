package vn.com.hiringviet.dto;

import java.io.Serializable;

// TODO: Auto-generated Javadoc
/**
 * The Class EducationHistoryDTO.
 */
public class EducationHistoryDTO implements Serializable {

	private static final long serialVersionUID = -1060686631139287817L;

	/** The id. */
	private Integer id;

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
	 * Gets the id.
	 *
	 * @return the id
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * Sets the id.
	 *
	 * @param id the new id
	 */
	public void setId(Integer id) {
		this.id = id;
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
