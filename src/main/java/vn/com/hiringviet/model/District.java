package vn.com.hiringviet.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "DISTRICT", catalog = "hiringviet")
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
public class District implements Serializable {

	private static final long serialVersionUID = 4567651847477356613L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "DISTRICT_ID", nullable = false, length = 11)
	private Integer districtID;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "PROVINCE_ID", nullable = false)
	private Province province;

	@Column(name = "DISPLAY_NAME", nullable = false)
	private String displayName;

	@Column(name = "STATUS", nullable = false)
	private Integer status;

	@Column(name = "CREATED_AT", nullable = false)
	private Date createdAt;

	@Column(name = "UPDATED_AT", nullable = false)
	private Date updatedAt;

	@Column(name = "DELETED_AT")
	private Date deletedAt;

	@JsonIgnore
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "district")
	private List<Resume> resumeSet;

	@JsonIgnore
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "district")
	private List<Company> companySet;

	@JsonIgnore
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "district")
	private List<Job> jobSet;

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

	public List<Resume> getResumeSet() {
		return resumeSet;
	}

	public void setResumeSet(List<Resume> resumeSet) {
		this.resumeSet = resumeSet;
	}

	public List<Company> getCompanySet() {
		return companySet;
	}

	public void setCompanySet(List<Company> companySet) {
		this.companySet = companySet;
	}

	public List<Job> getJobSet() {
		return jobSet;
	}

	public void setJobSet(List<Job> jobSet) {
		this.jobSet = jobSet;
	}

}
