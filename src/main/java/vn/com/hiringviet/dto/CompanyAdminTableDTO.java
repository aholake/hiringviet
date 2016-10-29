package vn.com.hiringviet.dto;

import java.io.Serializable;

import vn.com.hiringviet.common.StatusEnum;

public class CompanyAdminTableDTO implements Serializable {
	private static final long serialVersionUID = -440359673702082767L;

	private int id;
	private String email;
	private String displayName;
	private StatusEnum status;
	private String businessField;
	private Integer isVip;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getDisplayName() {
		return displayName;
	}

	public void setDisplayName(String displayName) {
		this.displayName = displayName;
	}

	public StatusEnum getStatus() {
		return status;
	}

	public void setStatus(StatusEnum status) {
		this.status = status;
	}

	public String getBusinessField() {
		return businessField;
	}

	public void setBusinessField(String businessField) {
		this.businessField = businessField;
	}

	public Integer getIsVip() {
		return isVip;
	}

	public void setIsVip(Integer isVip) {
		this.isVip = isVip;
	}

}
