package vn.com.hiringviet.dto;

import java.io.Serializable;

// TODO: Auto-generated Javadoc
/**
 * The Class AccountDTO.
 */
public class AccountDTO implements Serializable {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 23080133388427240L;

	/** The id. */
	private Integer id;

	/** The avatar image. */
	private String avatarImage;

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
	 * Gets the avatar image.
	 *
	 * @return the avatar image
	 */
	public String getAvatarImage() {
		return avatarImage;
	}

	/**
	 * Sets the avatar image.
	 *
	 * @param avatarImage the new avatar image
	 */
	public void setAvatarImage(String avatarImage) {
		this.avatarImage = avatarImage;
	}

}
