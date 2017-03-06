package vn.com.hiringviet.api.dto.response;

// TODO: Auto-generated Javadoc
/**
 * The Class ExportApplysDTO.
 */
public class ExportApplysDTO {

	/** The name. */
	private String name;

	/** The phone number. */
	private String phoneNumber;

	/** The email. */
	private String email;

	/** The curriculum vitae. */
	private String curriculumVitae;

	/**
	 * Instantiates a new export applys dto.
	 *
	 * @param name            the name
	 * @param email            the email
	 * @param phoneNumber the phone number
	 * @param curriculumVitae            the curriculum vitae
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

	/**
	 * Gets the phone number.
	 *
	 * @return the phone number
	 */
	public String getPhoneNumber() {
		return phoneNumber;
	}

	/**
	 * Sets the phone number.
	 *
	 * @param phoneNumber the new phone number
	 */
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

}
