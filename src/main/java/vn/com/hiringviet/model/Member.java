package vn.com.hiringviet.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "MEMBER", catalog = "hiringviet")
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
public class Member implements Serializable {

	private static final long serialVersionUID = -4371044009879481708L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "MEMBER_ID", unique = true, nullable = false, length = 11)
	private Integer memberID;

	@Column(name = "EMAIL", unique = true, nullable = false, length = 100)
	private String email;

	@Column(name = "PASSWORD", nullable = false, length = 100)
	private String password;

	@Column(name = "ROLE_ID", nullable = false)
	private Integer roleID;

	@Column(name = "STATUS", nullable = false)
	private Integer status;

	@Column(name = "LOCALE", nullable = false)
	private String locale;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "CREATED_AT", nullable = false)
	private Date createdAt;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "UPDATED_AT", nullable = false)
	private Date updatedAt;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "DELETED_AT")
	private Date deletedAt;

	@JsonIgnore
	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "member")
	private List<Resume> resumeSet;

	@JsonIgnore
	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "member")
	private List<Company> companySet;

	@JsonIgnore
	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "member")
	private List<Apply> applySet;

	@JsonIgnore
	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "fromMemberID")
	private List<Follow> followFromSet;

	@JsonIgnore
	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "toMemberID")
	private List<Follow> followToSet;

	@JsonIgnore
	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "fromMemberID")
	private List<Mailbox> mailboxFromSet;

	@JsonIgnore
	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "toMemberID")
	private List<Mailbox> mailboxToSet;

	@JsonIgnore
	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "fromMemberID")
	private List<RequestEndorse> requestEndorseFromSet;

	@JsonIgnore
	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "toMemberID")
	private List<RequestEndorse> requestEndorseToSet;

	@JsonIgnore
	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "fromMemberID")
	private List<Endorse> endorseFromSet;

	@JsonIgnore
	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "toMemberID")
	private List<Endorse> endorseToSet;

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

	public List<Apply> getApplySet() {
		return applySet;
	}

	public void setApplySet(List<Apply> applySet) {
		this.applySet = applySet;
	}

	public List<Follow> getFollowFromSet() {
		return followFromSet;
	}

	public void setFollowFromSet(List<Follow> followFromSet) {
		this.followFromSet = followFromSet;
	}

	public List<Follow> getFollowToSet() {
		return followToSet;
	}

	public void setFollowToSet(List<Follow> followToSet) {
		this.followToSet = followToSet;
	}

	public List<Mailbox> getMailboxFromSet() {
		return mailboxFromSet;
	}

	public void setMailboxFromSet(List<Mailbox> mailboxFromSet) {
		this.mailboxFromSet = mailboxFromSet;
	}

	public List<Mailbox> getMailboxToSet() {
		return mailboxToSet;
	}

	public void setMailboxToSet(List<Mailbox> mailboxToSet) {
		this.mailboxToSet = mailboxToSet;
	}

	public List<RequestEndorse> getRequestEndorseFromSet() {
		return requestEndorseFromSet;
	}

	public void setRequestEndorseFromSet(List<RequestEndorse> requestEndorseFromSet) {
		this.requestEndorseFromSet = requestEndorseFromSet;
	}

	public List<RequestEndorse> getRequestEndorseToSet() {
		return requestEndorseToSet;
	}

	public void setRequestEndorseToSet(List<RequestEndorse> requestEndorseToSet) {
		this.requestEndorseToSet = requestEndorseToSet;
	}

	public List<Endorse> getEndorseFromSet() {
		return endorseFromSet;
	}

	public void setEndorseFromSet(List<Endorse> endorseFromSet) {
		this.endorseFromSet = endorseFromSet;
	}

	public List<Endorse> getEndorseToSet() {
		return endorseToSet;
	}

	public void setEndorseToSet(List<Endorse> endorseToSet) {
		this.endorseToSet = endorseToSet;
	}

}
