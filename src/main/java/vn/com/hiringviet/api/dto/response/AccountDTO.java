package vn.com.hiringviet.api.dto.response;

import java.io.Serializable;
import java.util.List;

import vn.com.hiringviet.model.Company;
import vn.com.hiringviet.model.Member;
import vn.com.hiringviet.model.Message;

/**
 * The Class AccountDTO.
 */
public class AccountDTO implements Serializable {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 4072348976258199771L;

	/** The id. */
	private Integer id;

	/** The email. */
	private String email;

	/** The password. */
	private String password;

	/** The role id. */
	private Integer roleID;

	/** The locale. */
	private String locale;

	/** The status. */
	private Integer status;

	/** The member. */
	private Member member;

	/** The company. */
	private Company company;

	/** The inbox messages. */
	private List<Message> inboxMessages;

	/** The sent messages. */
	private List<Message> sentMessages;

	/** The is remembered. */
	private boolean isRemembered;

	/** The avatar image. */
	private String avatarImage;

	/** The avatar image key. */
	private String avatarImageKey;

	/** The cover image key. */
	private String coverImageKey;

	/**
	 * Gets the id.
	 *
	 * @return the id
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * Sets the id.
	 *
	 * @param id the new id
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	/**
	 * Gets the email.
	 *
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * Sets the email.
	 *
	 * @param email the new email
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * Gets the password.
	 *
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * Sets the password.
	 *
	 * @param password the new password
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * Gets the role id.
	 *
	 * @return the role id
	 */
	public Integer getRoleID() {
		return roleID;
	}

	/**
	 * Sets the role id.
	 *
	 * @param roleID the new role id
	 */
	public void setRoleID(Integer roleID) {
		this.roleID = roleID;
	}

	/**
	 * Gets the locale.
	 *
	 * @return the locale
	 */
	public String getLocale() {
		return locale;
	}

	/**
	 * Sets the locale.
	 *
	 * @param locale the new locale
	 */
	public void setLocale(String locale) {
		this.locale = locale;
	}

	/**
	 * Gets the status.
	 *
	 * @return the status
	 */
	public Integer getStatus() {
		return status;
	}

	/**
	 * Sets the status.
	 *
	 * @param status the new status
	 */
	public void setStatus(Integer status) {
		this.status = status;
	}

	/**
	 * Gets the member.
	 *
	 * @return the member
	 */
	public Member getMember() {
		return member;
	}

	/**
	 * Sets the member.
	 *
	 * @param member the new member
	 */
	public void setMember(Member member) {
		this.member = member;
	}

	/**
	 * Gets the company.
	 *
	 * @return the company
	 */
	public Company getCompany() {
		return company;
	}

	/**
	 * Sets the company.
	 *
	 * @param company the new company
	 */
	public void setCompany(Company company) {
		this.company = company;
	}

	/**
	 * Gets the inbox messages.
	 *
	 * @return the inbox messages
	 */
	public List<Message> getInboxMessages() {
		return inboxMessages;
	}

	/**
	 * Sets the inbox messages.
	 *
	 * @param inboxMessages the new inbox messages
	 */
	public void setInboxMessages(List<Message> inboxMessages) {
		this.inboxMessages = inboxMessages;
	}

	/**
	 * Gets the sent messages.
	 *
	 * @return the sent messages
	 */
	public List<Message> getSentMessages() {
		return sentMessages;
	}

	/**
	 * Sets the sent messages.
	 *
	 * @param sentMessages the new sent messages
	 */
	public void setSentMessages(List<Message> sentMessages) {
		this.sentMessages = sentMessages;
	}

	/**
	 * Checks if is remembered.
	 *
	 * @return true, if is remembered
	 */
	public boolean isRemembered() {
		return isRemembered;
	}

	/**
	 * Sets the remembered.
	 *
	 * @param isRemembered the new remembered
	 */
	public void setRemembered(boolean isRemembered) {
		this.isRemembered = isRemembered;
	}

	/**
	 * Gets the avatar image.
	 *
	 * @return the avatar image
	 */
	public String getAvatarImage() {
		return avatarImage;
	}

	/**
	 * Sets the avatar image.
	 *
	 * @param avatarImage the new avatar image
	 */
	public void setAvatarImage(String avatarImage) {
		this.avatarImage = avatarImage;
	}

	/**
	 * Gets the avatar image key.
	 *
	 * @return the avatar image key
	 */
	public String getAvatarImageKey() {
		return avatarImageKey;
	}

	/**
	 * Sets the avatar image key.
	 *
	 * @param avatarImageKey the new avatar image key
	 */
	public void setAvatarImageKey(String avatarImageKey) {
		this.avatarImageKey = avatarImageKey;
	}

	/**
	 * Gets the cover image key.
	 *
	 * @return the cover image key
	 */
	public String getCoverImageKey() {
		return coverImageKey;
	}

	/**
	 * Sets the cover image key.
	 *
	 * @param coverImageKey the new cover image key
	 */
	public void setCoverImageKey(String coverImageKey) {
		this.coverImageKey = coverImageKey;
	}

}
