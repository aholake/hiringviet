package vn.com.hiringviet.api.dto.response;

// TODO: Auto-generated Javadoc
/**
 * The Class ExportMemberDTO.
 */
public class ExportMemberDTO {

	/** The name. */
	private String name;

	/** The sex. */
	private String sex;

	/** The birth day. */
	private String birthDay;

	/** The address. */
	private String address;

	/** The email. */
	private String email;

	/** The phone. */
	private String phone;

	/** The summary. */
	private String summary;

	/**
	 * Instantiates a new export member dto.
	 *
	 * @param name the name
	 * @param sex the sex
	 * @param birthDay the birth day
	 * @param address the address
	 * @param email the email
	 * @param phone the phone
	 * @param summary the summary
	 */
	public ExportMemberDTO(String name, String sex, String birthDay,
			String address, String email, String phone, String summary) {
		this.name = name;
		this.sex = sex;
		this.birthDay = birthDay;
		this.address = address;
		this.email = email;
		this.phone = phone;
		this.summary = summary;
	}

	/**
	 * Gets the name.
	 *
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * Sets the name.
	 *
	 * @param name the new name
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Gets the sex.
	 *
	 * @return the sex
	 */
	public String getSex() {
		return sex;
	}

	/**
	 * Sets the sex.
	 *
	 * @param sex the new sex
	 */
	public void setSex(String sex) {
		this.sex = sex;
	}

	/**
	 * Gets the birth day.
	 *
	 * @return the birth day
	 */
	public String getBirthDay() {
		return birthDay;
	}

	/**
	 * Sets the birth day.
	 *
	 * @param birthDay the new birth day
	 */
	public void setBirthDay(String birthDay) {
		this.birthDay = birthDay;
	}

	/**
	 * Gets the address.
	 *
	 * @return the address
	 */
	public String getAddress() {
		return address;
	}

	/**
	 * Sets the address.
	 *
	 * @param address the new address
	 */
	public void setAddress(String address) {
		this.address = address;
	}

	/**
	 * Gets the email.
	 *
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * Sets the email.
	 *
	 * @param email the new email
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * Gets the phone.
	 *
	 * @return the phone
	 */
	public String getPhone() {
		return phone;
	}

	/**
	 * Sets the phone.
	 *
	 * @param phone the new phone
	 */
	public void setPhone(String phone) {
		this.phone = phone;
	}

	/**
	 * Gets the summary.
	 *
	 * @return the summary
	 */
	public String getSummary() {
		return summary;
	}

	/**
	 * Sets the summary.
	 *
	 * @param summary the new summary
	 */
	public void setSummary(String summary) {
		this.summary = summary;
	}

}
