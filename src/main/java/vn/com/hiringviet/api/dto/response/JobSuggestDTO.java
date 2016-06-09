package vn.com.hiringviet.api.dto.response;

import java.io.Serializable;

public class JobSuggestDTO implements Serializable {

	private static final long serialVersionUID = -1485079055870722504L;

	private Integer id;

	private String displayName;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getDisplayName() {
		return displayName;
	}

	public void setDisplayName(String displayName) {
		this.displayName = displayName;
	}

}
