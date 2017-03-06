package vn.com.hiringviet.dto;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import vn.com.hiringviet.model.Company;
import vn.com.hiringviet.model.Province;

// TODO: Auto-generated Javadoc
/**
 * The Class JobAdminTableDTO.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class JobAdminTableDTO {
	
	/** The id. */
	private Integer id;

	/** The title. */
	private String title;

	/** The company. */
	private Company company;

	/** The post date. */
	private Date postDate;

	/** The province. */
	private Province province;

	/** The job category. */
	private String jobCategory;

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
	 * Gets the post date.
	 *
	 * @return the post date
	 */
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
	 * Gets the province.
	 *
	 * @return the province
	 */
	public Province getProvince() {
		return province;
	}

	/**
	 * Sets the province.
	 *
	 * @param province the new province
	 */
	public void setProvince(Province province) {
		this.province = province;
	}

	/**
	 * Gets the job category.
	 *
	 * @return the job category
	 */
	public String getJobCategory() {
		return jobCategory;
	}

	/**
	 * Sets the job category.
	 *
	 * @param jobCategory the new job category
	 */
	public void setJobCategory(String jobCategory) {
		this.jobCategory = jobCategory;
	}
}
