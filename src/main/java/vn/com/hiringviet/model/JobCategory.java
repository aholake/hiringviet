package vn.com.hiringviet.model;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

// TODO: Auto-generated Javadoc
/**
 * The Class JobCategory.
 */
@Entity
@Table(name = "job_category")
public class JobCategory implements Serializable {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = -7098623801141057102L;

	/** The id. */
	private Integer id;

	/** The category name. */
	private String categoryName;

	/** The job set. */
	private Set<Job> jobSet;

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
	 * Gets the category name.
	 *
	 * @return the category name
	 */
	@Column(name = "category_name")
	public String getCategoryName() {
		return categoryName;
	}

	/**
	 * Sets the category name.
	 *
	 * @param categoryName the new category name
	 */
	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	/**
	 * Gets the job set.
	 *
	 * @return the job set
	 */
	@JsonIgnore
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "jobCategory")
	public Set<Job> getJobSet() {
		return jobSet;
	}

	/**
	 * Sets the job set.
	 *
	 * @param jobSet the new job set
	 */
	public void setJobSet(Set<Job> jobSet) {
		this.jobSet = jobSet;
	}

	/**
	 * Gets the change log.
	 *
	 * @return the change log
	 */
	@JsonIgnore
	@OneToOne(fetch = FetchType.LAZY)
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

}
