package vn.com.hiringviet.dto;

import java.io.Serializable;
import java.util.Date;

public class EmploymentHistoryDTO implements Serializable {

	private static final long serialVersionUID = 2173922122328868308L;

	private Integer id;

	private String companyName;

	private Date beginDate;

	private Date endDate;

	private String description;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public Date getBeginDate() {
		return beginDate;
	}

	public void setBeginDate(Date beginDate) {
		this.beginDate = beginDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

}
