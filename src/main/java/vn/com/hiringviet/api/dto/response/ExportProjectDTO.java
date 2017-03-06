package vn.com.hiringviet.api.dto.response;

// TODO: Auto-generated Javadoc
/**
 * The Class ExportProjectDTO.
 */
public class ExportProjectDTO {

	/** The name. */
	private String name;

	/** The description. */
	private String description;

	/** The url. */
	private String url;

	/**
	 * Instantiates a new export project dto.
	 *
	 * @param name the name
	 * @param description the description
	 * @param url the url
	 */
	public ExportProjectDTO(String name, String description, String url) {
		this.name = name;
		this.description = description;
		this.url = url;
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

	/**
	 * Gets the url.
	 *
	 * @return the url
	 */
	public String getUrl() {
		return url;
	}

	/**
	 * Sets the url.
	 *
	 * @param url the new url
	 */
	public void setUrl(String url) {
		this.url = url;
	}

}
