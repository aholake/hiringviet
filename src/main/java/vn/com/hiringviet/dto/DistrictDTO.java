package vn.com.hiringviet.dto;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
public class DistrictDTO implements Serializable {

	private static final long serialVersionUID = 4567651847477356613L;

	private Integer districtID;

	@JsonIgnore
	private ProvinceDTO province;

	private String displayName;

	private Integer status;

	private Date createdAt;

	private Date updatedAt;

	private Date deletedAt;

	@JsonIgnore
	private List<ResumeDTO> resumeSet;

	@JsonIgnore
	private List<CompanyDTO> companySet;

	@JsonIgnore
	private List<JobDTO> jobSet;

	public Integer getDistrictID() {
		return districtID;
	}

	public void setDistrictID(Integer districtID) {
		this.districtID = districtID;
	}

	public ProvinceDTO getProvince() {
		return province;
	}

	public void setProvince(ProvinceDTO province) {
		this.province = province;
	}

	public String getDisplayName() {
		return displayName;
	}

	public void setDisplayName(String displayName) {
		this.displayName = displayName;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public Date getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}

	public Date getDeletedAt() {
		return deletedAt;
	}

	public void setDeletedAt(Date deletedAt) {
		this.deletedAt = deletedAt;
	}

	public List<ResumeDTO> getResumeSet() {
		return resumeSet;
	}

	public void setResumeSet(List<ResumeDTO> resumeSet) {
		this.resumeSet = resumeSet;
	}

	public List<CompanyDTO> getCompanySet() {
		return companySet;
	}

	public void setCompanySet(List<CompanyDTO> companySet) {
		this.companySet = companySet;
	}

	public List<JobDTO> getJobSet() {
		return jobSet;
	}

	public void setJobSet(List<JobDTO> jobSet) {
		this.jobSet = jobSet;
	}

}
