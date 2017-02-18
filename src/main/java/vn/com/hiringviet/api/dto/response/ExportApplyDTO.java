package vn.com.hiringviet.api.dto.response;

/**
 * The Class ExportApplyDTO.
 */
public class ExportApplyDTO {

	/** The file title. */
	private String fileTitle;

	/** The header title. */
	private String headerTitle;

	/** The footer title. */
	private String footerTitle;

	/** The name title. */
	private String nameTitle;

	/** The email title. */
	private String emailTitle;

	/** The curriculum vitae title. */
	private String curriculumVitaeTitle;

	/**
	 * Instantiates a new export apply dto.
	 *
	 * @param fileTitle
	 *            the file title
	 * @param headerTitle
	 *            the header title
	 * @param footerTitle
	 *            the footer title
	 * @param nameTitle
	 *            the name title
	 * @param emailTitle
	 *            the email title
	 * @param curriculumVitaeTitle
	 *            the curriculum vitae title
	 */
	public ExportApplyDTO(String fileTitle, String headerTitle,
			String footerTitle, String nameTitle, String emailTitle,
			String curriculumVitaeTitle) {
		super();
		this.fileTitle = fileTitle;
		this.headerTitle = headerTitle;
		this.footerTitle = footerTitle;
		this.nameTitle = nameTitle;
		this.emailTitle = emailTitle;
		this.curriculumVitaeTitle = curriculumVitaeTitle;
	}

	/**
	 * Gets the file title.
	 *
	 * @return the file title
	 */
	public String getFileTitle() {
		return fileTitle;
	}

	/**
	 * Sets the file title.
	 *
	 * @param fileTitle
	 *            the new file title
	 */
	public void setFileTitle(String fileTitle) {
		this.fileTitle = fileTitle;
	}

	/**
	 * Gets the header title.
	 *
	 * @return the header title
	 */
	public String getHeaderTitle() {
		return headerTitle;
	}

	/**
	 * Sets the header title.
	 *
	 * @param headerTitle
	 *            the new header title
	 */
	public void setHeaderTitle(String headerTitle) {
		this.headerTitle = headerTitle;
	}

	/**
	 * Gets the footer title.
	 *
	 * @return the footer title
	 */
	public String getFooterTitle() {
		return footerTitle;
	}

	/**
	 * Sets the footer title.
	 *
	 * @param footerTitle
	 *            the new footer title
	 */
	public void setFooterTitle(String footerTitle) {
		this.footerTitle = footerTitle;
	}

	/**
	 * Gets the name title.
	 *
	 * @return the name title
	 */
	public String getNameTitle() {
		return nameTitle;
	}

	/**
	 * Sets the name title.
	 *
	 * @param nameTitle
	 *            the new name title
	 */
	public void setNameTitle(String nameTitle) {
		this.nameTitle = nameTitle;
	}

	/**
	 * Gets the email title.
	 *
	 * @return the email title
	 */
	public String getEmailTitle() {
		return emailTitle;
	}

	/**
	 * Sets the email title.
	 *
	 * @param emailTitle
	 *            the new email title
	 */
	public void setEmailTitle(String emailTitle) {
		this.emailTitle = emailTitle;
	}

	/**
	 * Gets the curriculum vitae title.
	 *
	 * @return the curriculum vitae title
	 */
	public String getCurriculumVitaeTitle() {
		return curriculumVitaeTitle;
	}

	/**
	 * Sets the curriculum vitae title.
	 *
	 * @param curriculumVitaeTitle
	 *            the new curriculum vitae title
	 */
	public void setCurriculumVitaeTitle(String curriculumVitaeTitle) {
		this.curriculumVitaeTitle = curriculumVitaeTitle;
	}

}
