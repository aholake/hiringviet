package vn.com.hiringviet.dto;

import java.io.Serializable;
import java.util.Date;

import vn.com.hiringviet.model.Address;

// TODO: Auto-generated Javadoc
/**
 * The Class JobDTO.
 */
public class JobDTO implements Serializable {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 7985207339540987100L;

	/** The integer. */
	private Integer id;

	/** The title. */
	private String title;

	/** The post date. */
	private Date postDate;

	/** The address. */
	private Address address;

	/** The job id. */
	private Integer jobId;

	/** The is publish. */
	private Integer isPublish;

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
	 * Gets the address.
	 *
	 * @return the address
	 */
	public Address getAddress() {
		return address;
	}

	/**
	 * Sets the address.
	 *
	 * @param address the new address
	 */
	public void setAddress(Address address) {
		this.address = address;
	}

	/**
	 * Gets the job id.
	 *
	 * @return the job id
	 */
	public Integer getJobId() {
		return jobId;
	}

	/**
	 * Sets the job id.
	 *
	 * @param jobId the new job id
	 */
	public void setJobId(Integer jobId) {
		this.jobId = jobId;
	}

	/**
	 * Gets the checks if is publish.
	 *
	 * @return the checks if is publish
	 */
	public Integer getIsPublish() {
		return isPublish;
	}

	/**
	 * Sets the checks if is publish.
	 *
	 * @param isPublish the new checks if is publish
	 */
	public void setIsPublish(Integer isPublish) {
		this.isPublish = isPublish;
	}

}
