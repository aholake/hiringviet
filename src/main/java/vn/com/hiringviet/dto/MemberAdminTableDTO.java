package vn.com.hiringviet.dto;

import vn.com.hiringviet.common.StatusEnum;

// TODO: Auto-generated Javadoc
/**
 * The Class MemberAdminTableDTO.
 */
public class MemberAdminTableDTO {
	
	/** The id. */
	private Integer id;

	/** The email. */
	private String email;

	/** The first name. */
	private String firstName;

	/** The last name. */
	private String lastName;

	/** The active. */
	private StatusEnum active;

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
	 * Gets the email.
	 *
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * Sets the email.
	 *
	 * @param email the new email
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * Gets the first name.
	 *
	 * @return the first name
	 */
	public String getFirstName() {
		return firstName;
	}

	/**
	 * Sets the first name.
	 *
	 * @param firstName the new first name
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	/**
	 * Gets the last name.
	 *
	 * @return the last name
	 */
	public String getLastName() {
		return lastName;
	}

	/**
	 * Sets the last name.
	 *
	 * @param lastName the new last name
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	/**
	 * Gets the active.
	 *
	 * @return the active
	 */
	public StatusEnum getActive() {
		return active;
	}

	/**
	 * Sets the active.
	 *
	 * @param active the new active
	 */
	public void setActive(StatusEnum active) {
		this.active = active;
	}

}