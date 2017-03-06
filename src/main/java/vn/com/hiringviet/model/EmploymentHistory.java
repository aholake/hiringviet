package vn.com.hiringviet.model;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.Cascade;

// TODO: Auto-generated Javadoc
/**
 * The Class EmploymentHistory.
 */
@Entity
@Table(name = "employment_history")
public class EmploymentHistory implements Serializable {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 4962308394934505729L;

	/** The id. */
	private Integer id;

//	private Company company;

	/** The company name. */
private String companyName;

	/** The position. */
	private Position position;

	/** The begin date. */
	private Date beginDate;

	/** The end date. */
	private Date endDate;

	/** The description. */
	private String description;

	/** The projects. */
	private Set<Project> projects;

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

//	@ManyToOne(fetch = FetchType.LAZY)
//	@JoinColumn(name = "company_id")
//	public Company getCompany() {
//		return company;
//	}

//	public void setCompany(Company company) {
//		this.company = company;
//	}

	/**
 * Gets the company name.
 *
 * @return the company name
 */
@Column(name = "company_name")
	public String getCompanyName() {
		return companyName;
	}

	/**
	 * Sets the company name.
	 *
	 * @param companyName the new company name
	 */
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	/**
	 * Gets the position.
	 *
	 * @return the position
	 */
	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@Cascade(value = { org.hibernate.annotations.CascadeType.MERGE })
	@JoinColumn(name = "position_id")
	public Position getPosition() {
		return position;
	}

	/**
	 * Sets the position.
	 *
	 * @param position the new position
	 */
	public void setPosition(Position position) {
		this.position = position;
	}

	/**
	 * Gets the begin date.
	 *
	 * @return the begin date
	 */
	@Temporal(TemporalType.DATE)
	@Column(name = "begin_date")
	public Date getBeginDate() {
		return beginDate;
	}

	/**
	 * Sets the begin date.
	 *
	 * @param beginDate the new begin date
	 */
	public void setBeginDate(Date beginDate) {
		this.beginDate = beginDate;
	}

	/**
	 * Gets the end date.
	 *
	 * @return the end date
	 */
	@Temporal(TemporalType.DATE)
	@Column(name = "end_date")
	public Date getEndDate() {
		return endDate;
	}

	/**
	 * Sets the end date.
	 *
	 * @param endDate the new end date
	 */
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	/**
	 * Gets the description.
	 *
	 * @return the description
	 */
	@Column(name = "description")
	public String getDescription() {
		return description;
	}

	/**
	 * Sets the description.
	 *
	 * @param description the new description
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * Gets the change log.
	 *
	 * @return the change log
	 */
	@OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(name = "change_log_id")
	@Cascade({ org.hibernate.annotations.CascadeType.SAVE_UPDATE })
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
	 * Gets the projects.
	 *
	 * @return the projects
	 */
	@OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@Cascade({ org.hibernate.annotations.CascadeType.SAVE_UPDATE })
	@JoinColumn(name = "employee_history_id")
	public Set<Project> getProjects() {
		return projects;
	}

	/**
	 * Sets the projects.
	 *
	 * @param projects the new projects
	 */
	public void setProjects(Set<Project> projects) {
		this.projects = projects;
	}

}
