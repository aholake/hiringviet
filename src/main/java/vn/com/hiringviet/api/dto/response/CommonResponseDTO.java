package vn.com.hiringviet.api.dto.response;

import java.io.Serializable;

public class CommonResponseDTO implements Serializable {

	private static final long serialVersionUID = 7769465489512461622L;

	private String result;

	private String message;

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}
