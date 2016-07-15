package vn.com.hiringviet.dto;

import java.io.Serializable;

/**
 * The Class SkillDTO.
 */
public class SkillDTO implements Serializable {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1701637117763726391L;

	/** The integer. */
	private Integer id;

	/** The display name. */
	private String displayName;

	private Integer addingNumber;

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
	 * @param id
	 *            the new id
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
	 * @param displayName
	 *            the new display name
	 */
	public void setDisplayName(String displayName) {
		this.displayName = displayName;
	}

	public Integer getAddingNumber() {
		return addingNumber;
	}

	public void setAddingNumber(Integer addingNumber) {
		this.addingNumber = addingNumber;
	}

}
