package vn.com.hiringviet.dto;

import java.io.Serializable;

public class CompanyDTO implements Serializable {

	private static final long serialVersionUID = 7620047717612427074L;

	private Integer id;

	private String displayName;

	private String avatarImage;

	private Long numberFollower;

	private String district;

	private String province;

	private String country;

	private Integer companySize;

	private String businessField;

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

	public String getAvatarImage() {
		return avatarImage;
	}

	public void setAvatarImage(String avatarImage) {
		this.avatarImage = avatarImage;
	}

	public Long getNumberFollower() {
		return numberFollower;
	}

	public void setNumberFollower(Long numberFollower) {
		this.numberFollower = numberFollower;
	}

	public String getDistrict() {
		return district;
	}

	public void setDistrict(String district) {
		this.district = district;
	}

	public String getProvince() {
		return province;
	}

	public void setProvince(String province) {
		this.province = province;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public Integer getCompanySize() {
		return companySize;
	}

	public void setCompanySize(Integer companySize) {
		this.companySize = companySize;
	}

	public String getBusinessField() {
		return businessField;
	}

	public void setBusinessField(String businessField) {
		this.businessField = businessField;
	}

}
