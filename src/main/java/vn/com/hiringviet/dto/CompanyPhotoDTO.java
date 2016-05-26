package vn.com.hiringviet.dto;

import java.io.Serializable;
import java.util.Date;

public class CompanyPhotoDTO implements Serializable {

	private static final long serialVersionUID = -6886420826151394119L;

	private Integer companyPhotoID;

	private Integer companyID;

	private byte[] photo;

	private String title;

	private String description;

	private Integer status;

	private Date createdAt;

	private Date updatedAt;

	private Date deletedAt;

	public Integer getCompanyPhotoID() {
		return companyPhotoID;
	}

	public void setCompanyPhotoID(Integer companyPhotoID) {
		this.companyPhotoID = companyPhotoID;
	}

	public Integer getCompanyID() {
		return companyID;
	}

	public void setCompanyID(Integer companyID) {
		this.companyID = companyID;
	}

	public byte[] getPhoto() {
		return photo;
	}

	public void setPhoto(byte[] photo) {
		this.photo = photo;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
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
