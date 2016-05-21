package vn.com.hiringviet.dto;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

import vn.com.hiringviet.model.Province;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class DistrictDTO implements Serializable {

	private static final long serialVersionUID = 4567651847477356613L;

	private Integer districtID;

	private Province province;

	private String displayName;

	private Integer status;

	private Date createdAt;

	private Date updatedAt;

	private Date deletedAt;

	@JsonIgnore
	private Set<ResumeDTO> resumeSet;

	@JsonIgnore
	private Set<CompanyDTO> companySet;

	@JsonIgnore
	private Set<JobDTO> jobSet;

	public Integer getDistrictID() {
		return districtID;
	}

	public void setDistrictID(Integer districtID) {
		this.districtID = districtID;
	}

	public Province getProvince() {
		return province;
	}

	public void setProvince(Province province) {
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

	public Set<ResumeDTO> getResumeSet() {
		return resumeSet;
	}

	public void setResumeSet(Set<ResumeDTO> resumeSet) {
		this.resumeSet = resumeSet;
	}

	public Set<CompanyDTO> getCompanySet() {
		return companySet;
	}

	public void setCompanySet(Set<CompanyDTO> companySet) {
		this.companySet = companySet;
	}

	public Set<JobDTO> getJobSet() {
		return jobSet;
	}

	public void setJobSet(Set<JobDTO> jobSet) {
		this.jobSet = jobSet;
	}

}
