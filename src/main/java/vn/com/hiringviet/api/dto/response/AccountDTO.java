package vn.com.hiringviet.api.dto.response;

import java.io.Serializable;
import java.util.List;

import vn.com.hiringviet.model.Company;
import vn.com.hiringviet.model.Member;
import vn.com.hiringviet.model.Message;

public class AccountDTO implements Serializable {

	private static final long serialVersionUID = 4072348976258199771L;

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

	private boolean isRemembered;

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

	public Member getMember() {
		return member;
	}

	public void setMember(Member member) {
		this.member = member;
	}

	public Company getCompany() {
		return company;
	}

	public void setCompany(Company company) {
		this.company = company;
	}

	public List<Message> getInboxMessages() {
		return inboxMessages;
	}

	public void setInboxMessages(List<Message> inboxMessages) {
		this.inboxMessages = inboxMessages;
	}

	public List<Message> getSentMessages() {
		return sentMessages;
	}

	public void setSentMessages(List<Message> sentMessages) {
		this.sentMessages = sentMessages;
	}

	public boolean isRemembered() {
		return isRemembered;
	}

	public void setRemembered(boolean isRemembered) {
		this.isRemembered = isRemembered;
	}

}
