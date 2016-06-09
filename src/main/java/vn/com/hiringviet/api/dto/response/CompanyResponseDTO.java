package vn.com.hiringviet.api.dto.response;

import java.io.Serializable;

public class CompanyResponseDTO implements Serializable {

	private static final long serialVersionUID = -2436612958840283439L;

	private Integer id;

	private String displayName;

	private String avatar;

	private Integer companySize;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getDisplayName() {
		return displayName;
	}

	public void setDisplayName(String displayName) {
		this.displayName = displayName;
	}

	public String getAvatar() {
		return avatar;
	}

	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}

	public Integer getCompanySize() {
		return companySize;
	}

	public void setCompanySize(Integer companySize) {
		this.companySize = companySize;
	}

}
