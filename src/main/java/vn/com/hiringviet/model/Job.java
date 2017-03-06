package vn.com.hiringviet.model;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.hibernate.annotations.Type;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

// TODO: Auto-generated Javadoc
/**
 * The Class Job.
 */
@Entity
@Table(name = "job")
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
public class Job implements Serializable {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = -3278815174799070361L;

	/** The id. */
	private Integer id;

	/** The job category. */
	private JobCategory jobCategory;

	/** The company. */
	private Company company;

	/** The skill set. */
	private Set<Skill> skillSet;

	/** The title. */
	private String title;

	/** The description. */
	private String description;

	/** The min salary. */
	private Double minSalary;

	/** The max salary. */
	private Double maxSalary;

	/** The post date. */
	private Date postDate;

	/** The expired date. */
	private Date expiredDate;

	/** The requirement. */
	private String requirement;

	/** The number visited. */
	private Integer numberVisited;

	/** The size. */
	private Integer size;

	/** The position. */
	private Position position;

	/** The change log. */
	private ChangeLog changeLog;

	/** The publish. */
	private boolean publish;

	/** The work address. */
	private Address workAddress;

	/** The comment set. */
	private Set<Comment> commentSet;

	/** The culture description. */
	private String cultureDescription;

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
	 * Gets the job category.
	 *
	 * @return the job category
	 */
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "job_category_id")
	public JobCategory getJobCategory() {
		return jobCategory;
	}

	/**
	 * Sets the job category.
	 *
	 * @param jobCategory the new job category
	 */
	public void setJobCategory(JobCategory jobCategory) {
		this.jobCategory = jobCategory;
	}

	/**
	 * Gets the company.
	 *
	 * @return the company
	 */
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "company_id")
	public Company getCompany() {
		return company;
	}

	/**
	 * Sets the company.
	 *
	 * @param company the new company
	 */
	public void setCompany(Company company) {
		this.company = company;
	}

	/**
	 * Gets the skill set.
	 *
	 * @return the skill set
	 */
	@Fetch(FetchMode.SUBSELECT)
	@ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@Cascade({ org.hibernate.annotations.CascadeType.SAVE_UPDATE })
	@JoinTable(name = "job_skill", joinColumns = { @JoinColumn(name = "job_id") }, inverseJoinColumns = { @JoinColumn(name = "skill_id") })
	public Set<Skill> getSkillSet() {
		return skillSet;
	}

	/**
	 * Sets the skill set.
	 *
	 * @param skillSet the new skill set
	 */
	public void setSkillSet(Set<Skill> skillSet) {
		this.skillSet = skillSet;
	}

	/**
	 * Gets the title.
	 *
	 * @return the title
	 */
	@Column(name = "title")
	public String getTitle() {
		return title;
	}

	/**
	 * Sets the title.
	 *
	 * @param title the new title
	 */
	public void setTitle(String title) {
		this.title = title;
	}

	/**
	 * Gets the description.
	 *
	 * @return the description
	 */
	@Column(name = "description")
	@Type(type = "text")
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
	 * Gets the min salary.
	 *
	 * @return the min salary
	 */
	@Column(name = "min_salary")
	public Double getMinSalary() {
		return minSalary;
	}

	/**
	 * Sets the min salary.
	 *
	 * @param minSalary the new min salary
	 */
	public void setMinSalary(Double minSalary) {
		this.minSalary = minSalary;
	}

	/**
	 * Gets the max salary.
	 *
	 * @return the max salary
	 */
	@Column(name = "max_salary")
	public Double getMaxSalary() {
		return maxSalary;
	}

	/**
	 * Sets the max salary.
	 *
	 * @param maxSalary the new max salary
	 */
	public void setMaxSalary(Double maxSalary) {
		this.maxSalary = maxSalary;
	}

	/**
	 * Gets the post date.
	 *
	 * @return the post date
	 */
	@Temporal(TemporalType.DATE)
	@Column(name = "posted_date")
	public Date getPostDate() {
		return postDate;
	}

	/**
	 * Sets the post date.
	 *
	 * @param postDate the new post date
	 */
	public void setPostDate(Date postDate) {
		this.postDate = postDate;
	}

	/**
	 * Gets the expired date.
	 *
	 * @return the expired date
	 */
	@Temporal(TemporalType.DATE)
	@Column(name = "expired_date")
	public Date getExpiredDate() {
		return expiredDate;
	}

	/**
	 * Sets the expired date.
	 *
	 * @param expiredDate the new expired date
	 */
	public void setExpiredDate(Date expiredDate) {
		this.expiredDate = expiredDate;
	}

	/**
	 * Gets the requirement.
	 *
	 * @return the requirement
	 */
	@Column(name = "requirement")
	@Type(type = "text")
	public String getRequirement() {
		return requirement;
	}

	/**
	 * Sets the requirement.
	 *
	 * @param requirement the new requirement
	 */
	public void setRequirement(String requirement) {
		this.requirement = requirement;
	}

	/**
	 * Gets the number visited.
	 *
	 * @return the number visited
	 */
	@Column(name = "number_visited")
	public Integer getNumberVisited() {
		return numberVisited;
	}

	/**
	 * Sets the number visited.
	 *
	 * @param numberVisited the new number visited
	 */
	public void setNumberVisited(Integer numberVisited) {
		this.numberVisited = numberVisited;
	}

	/**
	 * Gets the size.
	 *
	 * @return the size
	 */
	@Column(name = "size")
	public Integer getSize() {
		return size;
	}

	/**
	 * Sets the size.
	 *
	 * @param size the new size
	 */
	public void setSize(Integer size) {
		this.size = size;
	}

	/**
	 * Gets the position.
	 *
	 * @return the position
	 */
	@ManyToOne(cascade = CascadeType.ALL)
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
	 * Gets the change log.
	 *
	 * @return the change log
	 */
	@OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
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
	 * Gets the publish.
	 *
	 * @return the publish
	 */
	@Column(name = "is_publish")
	public boolean getPublish() {
		return publish;
	}

	/**
	 * Sets the publish.
	 *
	 * @param publish the new publish
	 */
	public void setPublish(boolean publish) {
		this.publish = publish;
	}

	/**
	 * Gets the work address.
	 *
	 * @return the work address
	 */
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "work_address_id")
	@Cascade({ org.hibernate.annotations.CascadeType.SAVE_UPDATE })
	public Address getWorkAddress() {
		return workAddress;
	}

	/**
	 * Sets the work address.
	 *
	 * @param workAddress the new work address
	 */
	public void setWorkAddress(Address workAddress) {
		this.workAddress = workAddress;
	}

	/**
	 * Gets the comment set.
	 *
	 * @return the comment set
	 */
	@JsonIgnore
	@Fetch(FetchMode.SUBSELECT)
	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name = "job_id")
	public Set<Comment> getCommentSet() {
		return commentSet;
	}

	/**
	 * Sets the comment set.
	 *
	 * @param commentSet the new comment set
	 */
	public void setCommentSet(Set<Comment> commentSet) {
		this.commentSet = commentSet;
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	/**
	 * Gets the culture description.
	 *
	 * @return the culture description
	 */
	@Column(name = "culture_description")
	public String getCultureDescription() {
		return cultureDescription;
	}

	/**
	 * Sets the culture description.
	 *
	 * @param cultureDescription the new culture description
	 */
	public void setCultureDescription(String cultureDescription) {
		this.cultureDescription = cultureDescription;
	}

}
