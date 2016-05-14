package vn.com.hiringviet.dto;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

import vn.com.hiringviet.model.Apply;
import vn.com.hiringviet.model.Company;
import vn.com.hiringviet.model.Follow;
import vn.com.hiringviet.model.Mailbox;
import vn.com.hiringviet.model.Resume;

public class MemberDTO implements Serializable {

	private static final long serialVersionUID = -4371044009879481708L;

	private Integer id;

	private String email;

	private String password;

	private Integer roleID;

	private Integer status;

	private String locale;

	private Date createdAt;

	private Date updatedAt;

	private Date deletedAt;

	private Resume resume;

	private Company company;

	private Set<Apply> applySet;

	private Set<Follow> followFromSet;

	private Set<Follow> followToSet;

	private Set<Mailbox> mailboxFromSet;

	private Set<Mailbox> mailboxToSet;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
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

	public Resume getResume() {
		return resume;
	}

	public void setResume(Resume resume) {
		this.resume = resume;
	}

	public Company getCompany() {
		return company;
	}

	public void setCompany(Company company) {
		this.company = company;
	}

	public Set<Apply> getApplySet() {
		return applySet;
	}

	public void setApplySet(Set<Apply> applySet) {
		this.applySet = applySet;
	}

	public Set<Follow> getFollowFromSet() {
		return followFromSet;
	}

	public void setFollowFromSet(Set<Follow> followFromSet) {
		this.followFromSet = followFromSet;
	}

	public Set<Follow> getFollowToSet() {
		return followToSet;
	}

	public void setFollowToSet(Set<Follow> followToSet) {
		this.followToSet = followToSet;
	}

	public Set<Mailbox> getMailboxFromSet() {
		return mailboxFromSet;
	}

	public void setMailboxFromSet(Set<Mailbox> mailboxFromSet) {
		this.mailboxFromSet = mailboxFromSet;
	}

	public Set<Mailbox> getMailboxToSet() {
		return mailboxToSet;
	}

	public void setMailboxToSet(Set<Mailbox> mailboxToSet) {
		this.mailboxToSet = mailboxToSet;
	}

}
