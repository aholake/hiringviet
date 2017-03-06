package vn.com.hiringviet.api.dto.response;

import java.io.Serializable;

// TODO: Auto-generated Javadoc
/**
 * The Class CompanyResponseDTO.
 */
public class CompanyResponseDTO implements Serializable {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = -2436612958840283439L;

	/** The id. */
	private Integer id;

	/** The display name. */
	private String displayName;

	/** The avatar. */
	private String avatar;

	/** The company size. */
	private Integer companySize;

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
	 * Gets the avatar.
	 *
	 * @return the avatar
	 */
	public String getAvatar() {
		return avatar;
	}

	/**
	 * Sets the avatar.
	 *
	 * @param avatar the new avatar
	 */
	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}

	/**
	 * Gets the company size.
	 *
	 * @return the company size
	 */
	public Integer getCompanySize() {
		return companySize;
	}

	/**
	 * Sets the company size.
	 *
	 * @param companySize the new company size
	 */
	public void setCompanySize(Integer companySize) {
		this.companySize = companySize;
	}

}
