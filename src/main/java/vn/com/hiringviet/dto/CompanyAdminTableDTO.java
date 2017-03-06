package vn.com.hiringviet.dto;

import java.io.Serializable;

import vn.com.hiringviet.common.StatusEnum;

// TODO: Auto-generated Javadoc
/**
 * The Class CompanyAdminTableDTO.
 */
public class CompanyAdminTableDTO implements Serializable {
	
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = -440359673702082767L;

	/** The id. */
	private int id;
	
	/** The email. */
	private String email;
	
	/** The display name. */
	private String displayName;
	
	/** The status. */
	private StatusEnum status;
	
	/** The business field. */
	private String businessField;
	
	/** The is vip. */
	private Integer isVip;

	/**
	 * Gets the id.
	 *
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * Sets the id.
	 *
	 * @param id the new id
	 */
	public void setId(int id) {
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
	 * Gets the display name.
	 *
	 * @return the display name
	 */
	public String getDisplayName() {
		return displayName;
	}

	/**
	 * Sets the display name.
	 *
	 * @param displayName the new display name
	 */
	public void setDisplayName(String displayName) {
		this.displayName = displayName;
	}

	/**
	 * Gets the status.
	 *
	 * @return the status
	 */
	public StatusEnum getStatus() {
		return status;
	}

	/**
	 * Sets the status.
	 *
	 * @param status the new status
	 */
	public void setStatus(StatusEnum status) {
		this.status = status;
	}

	/**
	 * Gets the business field.
	 *
	 * @return the business field
	 */
	public String getBusinessField() {
		return businessField;
	}

	/**
	 * Sets the business field.
	 *
	 * @param businessField the new business field
	 */
	public void setBusinessField(String businessField) {
		this.businessField = businessField;
	}

	/**
	 * Gets the checks if is vip.
	 *
	 * @return the checks if is vip
	 */
	public Integer getIsVip() {
		return isVip;
	}

	/**
	 * Sets the checks if is vip.
	 *
	 * @param isVip the new checks if is vip
	 */
	public void setIsVip(Integer isVip) {
		this.isVip = isVip;
	}

}
