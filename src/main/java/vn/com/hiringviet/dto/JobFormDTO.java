package vn.com.hiringviet.dto;

import java.util.Date;

import vn.com.hiringviet.model.Address;
import vn.com.hiringviet.model.Company;
import vn.com.hiringviet.model.JobCategory;
import vn.com.hiringviet.model.Position;

// TODO: Auto-generated Javadoc
/**
 * The Class JobFormDTO.
 */
public class JobFormDTO {
	
	/** The job category. */
	private JobCategory jobCategory;

	/** The company. */
	private Company company;

	/** The skill list id. */
	private String skillListId;

	/** The title. */
	private String title;

	/** The description. */
	private String description;

	/** The min salary. */
	private Double minSalary;

	/** The max salary. */
	private Double maxSalary;

	/** The expired date. */
	private Date expiredDate;

	/** The requirement. */
	private String requirement;

	/** The size. */
	private Integer size;

	/** The position. */
	private Position position;

	/** The publish. */
	private boolean publish;

	/** The work address. */
	private Address workAddress;

	/**
	 * Gets the job category.
	 *
	 * @return the job category
	 */
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
	 * Gets the skill list id.
	 *
	 * @return the skill list id
	 */
	public String getSkillListId() {
		return skillListId;
	}

	/**
	 * Sets the skill list id.
	 *
	 * @param skillListId the new skill list id
	 */
	public void setSkillListId(String skillListId) {
		this.skillListId = skillListId;
	}

	/**
	 * Gets the title.
	 *
	 * @return the title
	 */
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
	 * Checks if is publish.
	 *
	 * @return true, if is publish
	 */
	public boolean isPublish() {
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
	 * Gets the description.
	 *
	 * @return the description
	 */
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
	 * Gets the expired date.
	 *
	 * @return the expired date
	 */
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
	 * Gets the size.
	 *
	 * @return the size
	 */
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
	 * Gets the work address.
	 *
	 * @return the work address
	 */
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
	
}
