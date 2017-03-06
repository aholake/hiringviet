package vn.com.hiringviet.dto;

import java.io.Serializable;

// TODO: Auto-generated Javadoc
/**
 * The Class CompanyDTO.
 */
public class CompanyDTO implements Serializable {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 7620047717612427074L;

	/** The id. */
	private Integer id;

	/** The display name. */
	private String displayName;

	/** The avatar image. */
	private String avatarImage;

	/** The number follower. */
	private Long numberFollower;

	/** The district. */
	private String district;

	/** The province. */
	private String province;

	/** The country. */
	private String country;

	/** The company size. */
	private Integer companySize;

	/** The business field. */
	private String businessField;

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

	/**
	 * Gets the number follower.
	 *
	 * @return the number follower
	 */
	public Long getNumberFollower() {
		return numberFollower;
	}

	/**
	 * Sets the number follower.
	 *
	 * @param numberFollower the new number follower
	 */
	public void setNumberFollower(Long numberFollower) {
		this.numberFollower = numberFollower;
	}

	/**
	 * Gets the district.
	 *
	 * @return the district
	 */
	public String getDistrict() {
		return district;
	}

	/**
	 * Sets the district.
	 *
	 * @param district the new district
	 */
	public void setDistrict(String district) {
		this.district = district;
	}

	/**
	 * Gets the province.
	 *
	 * @return the province
	 */
	public String getProvince() {
		return province;
	}

	/**
	 * Sets the province.
	 *
	 * @param province the new province
	 */
	public void setProvince(String province) {
		this.province = province;
	}

	/**
	 * Gets the country.
	 *
	 * @return the country
	 */
	public String getCountry() {
		return country;
	}

	/**
	 * Sets the country.
	 *
	 * @param country the new country
	 */
	public void setCountry(String country) {
		this.country = country;
	}

	/**
	 * Gets the company size.
	 *
	 * @return the company size
	 */
	public Integer getCompanySize() {
		return companySize;
	}

	/**
	 * Sets the company size.
	 *
	 * @param companySize the new company size
	 */
	public void setCompanySize(Integer companySize) {
		this.companySize = companySize;
	}

	/**
	 * Gets the business field.
	 *
	 * @return the business field
	 */
	public String getBusinessField() {
		return businessField;
	}

	/**
	 * Sets the business field.
	 *
	 * @param businessField the new business field
	 */
	public void setBusinessField(String businessField) {
		this.businessField = businessField;
	}

}
