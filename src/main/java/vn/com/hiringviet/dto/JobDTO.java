package vn.com.hiringviet.dto;

import java.io.Serializable;

public class JobDTO implements Serializable {

	private static final long serialVersionUID = 7985207339540987100L;

	/** The integer. */
	private Integer id;

	/** The display name. */
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
