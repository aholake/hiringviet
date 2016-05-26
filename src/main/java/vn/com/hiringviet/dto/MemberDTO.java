package vn.com.hiringviet.dto;

import java.io.Serializable;
import java.util.Date;

public class MemberDTO implements Serializable {

	private static final long serialVersionUID = -4371044009879481708L;

	private Integer memberID;

	private String email;

	private String password;

	private Integer roleID;

	private Integer status;

	private String locale;

	private Date createdAt;

	private Date updatedAt;

	private Date deletedAt;

	private ResumeDTO resume;

	private CompanyDTO company;

	private boolean remembered;

	public Integer getMemberID() {
		return memberID;
	}

	public void setMemberID(Integer memberID) {
		this.memberID = memberID;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Integer getRoleID() {
		return roleID;
	}

	public void setRoleID(Integer roleID) {
		this.roleID = roleID;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public String getLocale() {
		return locale;
	}

	public void setLocale(String locale) {
		this.locale = locale;
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

	public ResumeDTO getResume() {
		return resume;
	}

	public void setResume(ResumeDTO resume) {
		this.resume = resume;
	}

	public CompanyDTO getCompany() {
		return company;
	}

	public void setCompany(CompanyDTO company) {
		this.company = company;
	}

	public boolean isRemembered() {
		return remembered;
	}

	public void setRemembered(boolean remembered) {
		this.remembered = remembered;
	}

}
