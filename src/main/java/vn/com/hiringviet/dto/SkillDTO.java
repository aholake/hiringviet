package vn.com.hiringviet.dto;

import java.io.Serializable;
import java.util.Date;

public class SkillDTO implements Serializable {

	private static final long serialVersionUID = -5381027238277880906L;

	private Integer skillID;

	private String skillName;

	private Integer status;

	private Date createdAt;

	private Date updatedAt;

	private Date deletedAt;

	public SkillDTO() {
		super();
	}

	public Integer getSkillID() {
		return skillID;
	}

	public void setSkillID(Integer skillID) {
		this.skillID = skillID;
	}

	public String getSkillName() {
		return skillName;
	}

	public void setSkillName(String skillName) {
		this.skillName = skillName;
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
