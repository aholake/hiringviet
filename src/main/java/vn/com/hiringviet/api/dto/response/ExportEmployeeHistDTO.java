package vn.com.hiringviet.api.dto.response;


public class ExportEmployeeHistDTO {

	private String companyName;

	private String position;

	private String beginDate;

	private String endDate;

	private String description;

	public ExportEmployeeHistDTO(String companyName, String position,
			String beginDate, String endDate, String description) {
		this.companyName = companyName;
		this.position = position;
		this.beginDate = beginDate;
		this.endDate = endDate;
		this.description = description;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	public String getBeginDate() {
		return beginDate;
	}

	public void setBeginDate(String beginDate) {
		this.beginDate = beginDate;
	}

	public String getEndDate() {
		return endDate;
	}

	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

}
