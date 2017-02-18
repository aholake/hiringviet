package vn.com.hiringviet.api.dto.response;

/**
 * The Class ExportApplysDTO.
 */
public class ExportApplysDTO {

	/** The name. */
	private String name;

	private String phoneNumber;

	/** The email. */
	private String email;

	/** The curriculum vitae. */
	private String curriculumVitae;

	/**
	 * Instantiates a new export applys dto.
	 *
	 * @param nameTitle
	 *            the name title
	 * @param emailTitle
	 *            the email title
	 * @param curriculumVitaeTitle
	 *            the curriculum vitae title
	 * @param name
	 *            the name
	 * @param email
	 *            the email
	 * @param curriculumVitae
	 *            the curriculum vitae
	 */
	public ExportApplysDTO(String name, String email, String phoneNumber,
			String curriculumVitae) {
		this.name = name;
		this.email = email;
		this.curriculumVitae = curriculumVitae;
		this.phoneNumber = phoneNumber;
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
	 * @param name
	 *            the new name
	 */
	public void setName(String name) {
		this.name = name;
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
	 * @param email
	 *            the new email
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * Gets the curriculum vitae.
	 *
	 * @return the curriculum vitae
	 */
	public String getCurriculumVitae() {
		return curriculumVitae;
	}

	/**
	 * Sets the curriculum vitae.
	 *
	 * @param curriculumVitae
	 *            the new curriculum vitae
	 */
	public void setCurriculumVitae(String curriculumVitae) {
		this.curriculumVitae = curriculumVitae;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

}
