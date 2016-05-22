package vn.com.hiringviet.dto;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
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

	@JsonIgnore
	private List<ApplyDTO> applySet;

	@JsonIgnore
	private List<FollowDTO> followFromSet;

	@JsonIgnore
	private List<FollowDTO> followToSet;

	@JsonIgnore
	private List<MailboxDTO> mailboxFromSet;

	@JsonIgnore
	private List<MailboxDTO> mailboxToSet;

	@JsonIgnore
	private List<RequestEndorseDTO> requestEndorseFromSet;

	@JsonIgnore
	private List<RequestEndorseDTO> requestEndorseToSet;

	@JsonIgnore
	private List<EndorseDTO> endorseFromSet;

	@JsonIgnore
	private List<EndorseDTO> endorseToSet;

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

	public List<ApplyDTO> getApplySet() {
		return applySet;
	}

	public void setApplySet(List<ApplyDTO> applySet) {
		this.applySet = applySet;
	}

	public List<FollowDTO> getFollowFromSet() {
		return followFromSet;
	}

	public void setFollowFromSet(List<FollowDTO> followFromSet) {
		this.followFromSet = followFromSet;
	}

	public List<FollowDTO> getFollowToSet() {
		return followToSet;
	}

	public void setFollowToSet(List<FollowDTO> followToSet) {
		this.followToSet = followToSet;
	}

	public List<MailboxDTO> getMailboxFromSet() {
		return mailboxFromSet;
	}

	public void setMailboxFromSet(List<MailboxDTO> mailboxFromSet) {
		this.mailboxFromSet = mailboxFromSet;
	}

	public List<MailboxDTO> getMailboxToSet() {
		return mailboxToSet;
	}

	public void setMailboxToSet(List<MailboxDTO> mailboxToSet) {
		this.mailboxToSet = mailboxToSet;
	}

	public List<RequestEndorseDTO> getRequestEndorseFromSet() {
		return requestEndorseFromSet;
	}

	public void setRequestEndorseFromSet(
			List<RequestEndorseDTO> requestEndorseFromSet) {
		this.requestEndorseFromSet = requestEndorseFromSet;
	}

	public List<RequestEndorseDTO> getRequestEndorseToSet() {
		return requestEndorseToSet;
	}

	public void setRequestEndorseToSet(List<RequestEndorseDTO> requestEndorseToSet) {
		this.requestEndorseToSet = requestEndorseToSet;
	}

	public List<EndorseDTO> getEndorseFromSet() {
		return endorseFromSet;
	}

	public void setEndorseFromSet(List<EndorseDTO> endorseFromSet) {
		this.endorseFromSet = endorseFromSet;
	}

	public List<EndorseDTO> getEndorseToSet() {
		return endorseToSet;
	}

	public void setEndorseToSet(List<EndorseDTO> endorseToSet) {
		this.endorseToSet = endorseToSet;
	}

	public boolean isRemembered() {
		return remembered;
	}

	public void setRemembered(boolean remembered) {
		this.remembered = remembered;
	}

}
