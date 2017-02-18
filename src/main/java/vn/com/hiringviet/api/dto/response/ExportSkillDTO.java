package vn.com.hiringviet.api.dto.response;

public class ExportSkillDTO {

	private String displayName;

	public ExportSkillDTO(String displayName) {
		super();
		this.displayName = displayName;
	}

	public String getDisplayName() {
		return displayName;
	}

	public void setDisplayName(String displayName) {
		this.displayName = displayName;
	}

}
