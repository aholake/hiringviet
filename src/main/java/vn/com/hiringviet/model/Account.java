package vn.com.hiringviet.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "account")
public class Account implements Serializable {

	private static final long serialVersionUID = -4371044009879481708L;

	private Integer id;

	private String email;

	private String password;

	private Integer roleID;

	private String locale;

	private Integer status;

	private Member member;

	private Company company;

	private List<Message> inboxMessages;

	private List<Message> sentMessages;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Integer getId() {
		return id;
	}

	public void setId(Integer accountID) {
		this.id = accountID;
	}

	@Column(name = "email")
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Column(name = "password")
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Column(name = "role_id")
	public Integer getRoleID() {
		return roleID;
	}

	public void setRoleID(Integer roleID) {
		this.roleID = roleID;
	}

	@Column(name = "locale")
	public String getLocale() {
		return locale;
	}

	public void setLocale(String locale) {
		this.locale = locale;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	@JsonIgnore
	@OneToOne(fetch = FetchType.LAZY, mappedBy = "account")
	public Member getMember() {
		return member;
	}

	public void setMember(Member member) {
		this.member = member;
	}

	@JsonIgnore
	@OneToOne(fetch = FetchType.LAZY, mappedBy = "account")
	public Company getCompany() {
		return company;
	}

	public void setCompany(Company company) {
		this.company = company;
	}

	@JsonIgnore
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "ownerAccount")
	public List<Message> getInboxMessages() {
		return inboxMessages;
	}

	public void setInboxMessages(List<Message> inboxMessages) {
		this.inboxMessages = inboxMessages;
	}

	@JsonIgnore
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "senderAccount")
	public List<Message> getSentMessages() {
		return sentMessages;
	}

	public void setSentMessages(List<Message> sentMessages) {
		this.sentMessages = sentMessages;
	}
}
