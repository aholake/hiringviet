package vn.com.hiringviet.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "PROVINCE", catalog = "hiringviet")
public class District implements Serializable {

	private static final long serialVersionUID = 4567651847477356613L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "district_ID", nullable = false)
	private Integer districtID;

	@Column(name = "DISTRICT_CODE", nullable = false)
	private String districtCode;

	@Column(name = "DISPLAY_NAME", nullable = false)
	private String displayName;

	@Column(name = "PROVINCE_ID", nullable = false)
	private Integer provinceID;

	@Column(name = "STATUS", nullable = false)
	private Integer status;

	@Column(name = "CREATE_AT", nullable = false)
	private Date createdAt;

	@Column(name = "UPDATE_AT", nullable = false)
	private Date updatedAt;

	@Column(name = "DELETE_AT")
	private Date deletedAt;

	public District() {
		super();
	}

	public Integer getDistrictID() {
		return districtID;
	}

	public void setDistrictID(Integer districtID) {
		this.districtID = districtID;
	}

	public String getDistrictCode() {
		return districtCode;
	}

	public void setDistrictCode(String districtCode) {
		this.districtCode = districtCode;
	}

	public String getDisplayName() {
		return displayName;
	}

	public void setDisplayName(String displayName) {
		this.displayName = displayName;
	}

	public Integer getProvinceID() {
		return provinceID;
	}

	public void setProvinceID(Integer provinceID) {
		this.provinceID = provinceID;
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

}
