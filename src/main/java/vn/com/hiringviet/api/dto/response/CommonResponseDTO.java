package vn.com.hiringviet.api.dto.response;

import java.io.Serializable;

// TODO: Auto-generated Javadoc
/**
 * The Class CommonResponseDTO.
 */
public class CommonResponseDTO implements Serializable {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 7769465489512461622L;

	/** The result. */
	private String result;

	/** The message. */
	private String message;

	/**
	 * Gets the result.
	 *
	 * @return the result
	 */
	public String getResult() {
		return result;
	}

	/**
	 * Sets the result.
	 *
	 * @param result the new result
	 */
	public void setResult(String result) {
		this.result = result;
	}

	/**
	 * Gets the message.
	 *
	 * @return the message
	 */
	public String getMessage() {
		return message;
	}

	/**
	 * Sets the message.
	 *
	 * @param message the new message
	 */
	public void setMessage(String message) {
		this.message = message;
	}

}
