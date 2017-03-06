package vn.com.hiringviet.dto;

import java.io.Serializable;

import vn.com.hiringviet.common.StatusEnum;

// TODO: Auto-generated Javadoc
/**
 * The Class MemberDTO.
 */
public class MemberDTO implements Serializable {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = -4063470646119486134L;

	/** The id. */
	private Integer id;

	/** The first name. */
	private String firstName;

	/** The last name. */
	private String lastName;

	/** The avatar image. */
	private String avatarImage;

	/** The status. */
	private StatusEnum status;

	/** The number follower. */
	private Long numberFollower;

	/** The school name. */
	private String schoolName;

	/** The province name. */
	private String provinceName;

	/** The district. */
	private String district;

	/** The province. */
	private String province;

	/** The country. */
	private String country;

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
	 * Gets the first name.
	 *
	 * @return the first name
	 */
	public String getFirstName() {
		return firstName;
	}

	/**
	 * Sets the first name.
	 *
	 * @param firstName the new first name
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	/**
	 * Gets the last name.
	 *
	 * @return the last name
	 */
	public String getLastName() {
		return lastName;
	}

	/**
	 * Sets the last name.
	 *
	 * @param lastName the new last name
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
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
	 * Gets the status.
	 *
	 * @return the status
	 */
	public StatusEnum getStatus() {
		return status;
	}

	/**
	 * Sets the status.
	 *
	 * @param status the new status
	 */
	public void setStatus(StatusEnum status) {
		this.status = status;
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
	 * Gets the school name.
	 *
	 * @return the school name
	 */
	public String getSchoolName() {
		return schoolName;
	}

	/**
	 * Sets the school name.
	 *
	 * @param schoolName the new school name
	 */
	public void setSchoolName(String schoolName) {
		this.schoolName = schoolName;
	}

	/**
	 * Gets the province name.
	 *
	 * @return the province name
	 */
	public String getProvinceName() {
		return provinceName;
	}

	/**
	 * Sets the province name.
	 *
	 * @param provinceName the new province name
	 */
	public void setProvinceName(String provinceName) {
		this.provinceName = provinceName;
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
}
