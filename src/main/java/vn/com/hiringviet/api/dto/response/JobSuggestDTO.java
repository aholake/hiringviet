package vn.com.hiringviet.api.dto.response;

import java.io.Serializable;

// TODO: Auto-generated Javadoc
/**
 * The Class JobSuggestDTO.
 */
public class JobSuggestDTO implements Serializable {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = -1485079055870722504L;

	/** The id. */
	private Integer id;

	/** The display name. */
	private String displayName;

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

}
