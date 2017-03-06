package vn.com.hiringviet.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.Type;

// TODO: Auto-generated Javadoc
/**
 * The Class EducationHistory.
 */
@Entity
@Table(name = "education_history")
public class EducationHistory implements Serializable {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = -247002098097375475L;

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

	/** The document. */
	private String document;

	/** The social activity. */
	private String socialActivity;

	/** The change log. */
	private ChangeLog changeLog;

	/**
	 * Gets the id.
	 *
	 * @return the id
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
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
	@Column(name = "university_name")
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
	@Column(name = "major_name")
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
	@Column(name = "begin_year")
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
	@Column(name = "end_year")
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
	@Column(name = "degree")
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
	@Column(name = "social_activity")
	@Type(type = "text")
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

	/**
	 * Gets the change log.
	 *
	 * @return the change log
	 */
	@OneToOne(fetch = FetchType.EAGER)
	@Cascade({ org.hibernate.annotations.CascadeType.SAVE_UPDATE })
	@JoinColumn(name = "change_log_id")
	public ChangeLog getChangeLog() {
		return changeLog;
	}

	/**
	 * Sets the change log.
	 *
	 * @param changeLog the new change log
	 */
	public void setChangeLog(ChangeLog changeLog) {
		this.changeLog = changeLog;
	}

	/**
	 * Gets the document.
	 *
	 * @return the document
	 */
	@Column(name = "document")
	@Type(type = "text")
	public String getDocument() {
		return document;
	}

	/**
	 * Sets the document.
	 *
	 * @param document the new document
	 */
	public void setDocument(String document) {
		this.document = document;
	}

}
