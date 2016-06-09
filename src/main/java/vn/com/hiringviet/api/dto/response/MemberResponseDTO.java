package vn.com.hiringviet.api.dto.response;

import java.io.Serializable;

public class MemberResponseDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7514098590448409643L;

	private Integer id;

	private String firstName;

	private String lastName;

	private String avatarImage;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getAvatarImage() {
		return avatarImage;
	}

	public void setAvatarImage(String avatarImage) {
		this.avatarImage = avatarImage;
	}

}
