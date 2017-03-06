package vn.com.hiringviet.api.dto.response;


// TODO: Auto-generated Javadoc
/**
 * The Class ExportEmployeeHistDTO.
 */
public class ExportEmployeeHistDTO {

	/** The company name. */
	private String companyName;

	/** The position. */
	private String position;

	/** The begin date. */
	private String beginDate;

	/** The end date. */
	private String endDate;

	/** The description. */
	private String description;

	/**
	 * Instantiates a new export employee hist dto.
	 *
	 * @param companyName the company name
	 * @param position the position
	 * @param beginDate the begin date
	 * @param endDate the end date
	 * @param description the description
	 */
	public ExportEmployeeHistDTO(String companyName, String position,
			String beginDate, String endDate, String description) {
		this.companyName = companyName;
		this.position = position;
		this.beginDate = beginDate;
		this.endDate = endDate;
		this.description = description;
	}

	/**
	 * Gets the company name.
	 *
	 * @return the company name
	 */
	public String getCompanyName() {
		return companyName;
	}

	/**
	 * Sets the company name.
	 *
	 * @param companyName the new company name
	 */
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	/**
	 * Gets the position.
	 *
	 * @return the position
	 */
	public String getPosition() {
		return position;
	}

	/**
	 * Sets the position.
	 *
	 * @param position the new position
	 */
	public void setPosition(String position) {
		this.position = position;
	}

	/**
	 * Gets the begin date.
	 *
	 * @return the begin date
	 */
	public String getBeginDate() {
		return beginDate;
	}

	/**
	 * Sets the begin date.
	 *
	 * @param beginDate the new begin date
	 */
	public void setBeginDate(String beginDate) {
		this.beginDate = beginDate;
	}

	/**
	 * Gets the end date.
	 *
	 * @return the end date
	 */
	public String getEndDate() {
		return endDate;
	}

	/**
	 * Sets the end date.
	 *
	 * @param endDate the new end date
	 */
	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}

	/**
	 * Gets the description.
	 *
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * Sets the description.
	 *
	 * @param description the new description
	 */
	public void setDescription(String description) {
		this.description = description;
	}

}
