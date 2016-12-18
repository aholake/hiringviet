package vn.com.hiringviet.dto;

import java.io.Serializable;

public class AccountDTO implements Serializable {

	private static final long serialVersionUID = 23080133388427240L;

	/** The id. */
	private Integer id;

	/** The avatar image. */
	private String avatarImage;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getAvatarImage() {
		return avatarImage;
	}

	public void setAvatarImage(String avatarImage) {
		this.avatarImage = avatarImage;
	}

}
