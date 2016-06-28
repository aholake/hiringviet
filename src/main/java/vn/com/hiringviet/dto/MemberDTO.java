package vn.com.hiringviet.dto;

import java.io.Serializable;

public class MemberDTO implements Serializable {

	private static final long serialVersionUID = -4063470646119486134L;

	private Integer id;

	private String firstName;

	private String lastName;

	private String avatarImage;

	private Integer status;

	private Long numberFollower;

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

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public Long getNumberFollower() {
		return numberFollower;
	}

	public void setNumberFollower(Long numberFollower) {
		this.numberFollower = numberFollower;
	}

}
