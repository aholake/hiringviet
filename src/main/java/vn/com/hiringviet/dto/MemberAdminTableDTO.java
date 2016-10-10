package vn.com.hiringviet.dto;

import vn.com.hiringviet.common.StatusEnum;

public class MemberAdminTableDTO {
	private Integer id;

	private String email;

	private String firstName;

	private String lastName;

	private StatusEnum active;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
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

	public StatusEnum getActive() {
		return active;
	}

	public void setActive(StatusEnum active) {
		this.active = active;
	}

}