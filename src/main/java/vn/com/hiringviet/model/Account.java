package vn.com.hiringviet.model;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.OrderBy;
import javax.persistence.Table;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import vn.com.hiringviet.common.AccountRoleEnum;
import vn.com.hiringviet.common.StatusEnum;

import com.fasterxml.jackson.annotation.JsonIgnore;

// TODO: Auto-generated Javadoc
/**
 * The Class Account.
 */
@Entity
@Table(name = "account")
public class Account implements Serializable {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = -4371044009879481708L;

	/** The id. */
	private Integer id;

	/** The email. */
	private String email;

	/** The password. */
	private String password;

	/** The avatar image. */
	private String avatarImage;

	/** The avatar image key. */
	private String avatarImageKey;

	/** The cover image. */
	private String coverImage;

	/** The cover image key. */
	private String coverImageKey;
	
	/** The role id. */
	private AccountRoleEnum userRole;

	/** The locale. */
	private String locale;

	/** The inbox messages. */
	private Set<Message> inboxMessages;

	/** The sent messages. */
	private Set<Message> sentMessages;

	/** The from follows. */
	private Set<Follow> fromFollows;

	/** The to follows. */
	private Set<Follow> toFollows;

	/** The status. */
	private StatusEnum status;

	/** The active url. */
	private String activeUrl;

	/** The company. */
	private Company company;

	/** The member. */
	private Member member;

	/** The loggers. */
	private Set<Logger> loggers;

	/**
	 * Gets the id.
	 *
	 * @return the id
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Integer getId() {
		return id;
	}

	/**
	 * Sets the id.
	 *
	 * @param accountID
	 *            the new id
	 */
	public void setId(Integer accountID) {
		this.id = accountID;
	}

	/**
	 * Gets the email.
	 *
	 * @return the email
	 */
	@Column(name = "email", unique = true)
	public String getEmail() {
		return email;
	}

	/**
	 * Sets the email.
	 *
	 * @param email
	 *            the new email
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * Gets the password.
	 *
	 * @return the password
	 */
	@Column(name = "password")
	public String getPassword() {
		return password;
	}

	/**
	 * Sets the password.
	 *
	 * @param password
	 *            the new password
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * Gets the role id.
	 *
	 * @return the role id
	 */

	/**
	 * Gets the locale.
	 *
	 * @return the locale
	 */
	@Column(name = "locale")
	public String getLocale() {
		return locale;
	}

	/**
	 * Gets the user role.
	 *
	 * @return the user role
	 */
	@Enumerated(EnumType.ORDINAL)
	public AccountRoleEnum getUserRole() {
		return userRole;
	}

	/**
	 * Sets the user role.
	 *
	 * @param userRole the new user role
	 */
	public void setUserRole(AccountRoleEnum userRole) {
		this.userRole = userRole;
	}

	/**
	 * Sets the locale.
	 *
	 * @param locale
	 *            the new locale
	 */
	public void setLocale(String locale) {
		this.locale = locale;
	}

	/**
	 * Gets the avatar image.
	 *
	 * @return the avatar image
	 */
	@Column(name = "avatar_image")
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
	 * Gets the cover image.
	 *
	 * @return the cover image
	 */
	@Column(name = "cover_image")
	public String getCoverImage() {
		return coverImage;
	}

	/**
	 * Sets the cover image.
	 *
	 * @param coverImage the new cover image
	 */
	public void setCoverImage(String coverImage) {
		this.coverImage = coverImage;
	}

	/**
	 * Gets the inbox messages.
	 *
	 * @return the inbox messages
	 */
	@JsonIgnore
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "ownerAccount")
	public Set<Message> getInboxMessages() {
		return inboxMessages;
	}

	/**
	 * Sets the inbox messages.
	 *
	 * @param inboxMessages
	 *            the new inbox messages
	 */
	public void setInboxMessages(Set<Message> inboxMessages) {
		this.inboxMessages = inboxMessages;
	}

	/**
	 * Gets the sent messages.
	 *
	 * @return the sent messages
	 */
	@JsonIgnore
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "senderAccount")
	public Set<Message> getSentMessages() {
		return sentMessages;
	}

	/**
	 * Sets the sent messages.
	 *
	 * @param sentMessages
	 *            the new sent messages
	 */
	public void setSentMessages(Set<Message> sentMessages) {
		this.sentMessages = sentMessages;
	}

	/**
	 * Gets the from follows.
	 *
	 * @return the from follows
	 */
	@Fetch(FetchMode.SUBSELECT)
	@OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL, mappedBy = "fromAccount")
	public Set<Follow> getFromFollows() {
		return fromFollows;
	}

	/**
	 * Sets the from follows.
	 *
	 * @param fromFollows
	 *            the new from follows
	 */
	public void setFromFollows(Set<Follow> fromFollows) {
		this.fromFollows = fromFollows;
	}

	/**
	 * Gets the to follows.
	 *
	 * @return the to follows
	 */
	@Fetch(FetchMode.SUBSELECT)
	@OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL, mappedBy = "toAccount")
	public Set<Follow> getToFollows() {
		return toFollows;
	}

	/**
	 * Sets the to follows.
	 *
	 * @param toFollows
	 *            the new to follows
	 */
	public void setToFollows(Set<Follow> toFollows) {
		this.toFollows = toFollows;
	}

	/**
	 * Gets the company.
	 *
	 * @return the company
	 */
	@JsonIgnore
	@OneToOne(mappedBy = "account", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
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
	 * Gets the member.
	 *
	 * @return the member
	 */
	@JsonIgnore
	@OneToOne(mappedBy = "account", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
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
	 * Gets the status.
	 *
	 * @return the status
	 */
	@Column(name = "status")
	@Enumerated(EnumType.ORDINAL)
	public StatusEnum getStatus() {
		return status;
	}

	/**
	 * Sets the status.
	 *
	 * @param status the new status
	 */
	public void setStatus(StatusEnum status) {
		this.status = status;
	}

	/**
	 * Gets the active url.
	 *
	 * @return the active url
	 */
	@Column(name = "active_url")
	public String getActiveUrl() {
		return activeUrl;
	}

	/**
	 * Sets the active url.
	 *
	 * @param activeUrl the new active url
	 */
	public void setActiveUrl(String activeUrl) {
		this.activeUrl = activeUrl;
	}

	/**
	 * Gets the avatar image key.
	 *
	 * @return the avatar image key
	 */
	@Column(name = "avatar_image_key")
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
	@Column(name = "cover_image_key")
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

	/**
	 * Gets the loggers.
	 *
	 * @return the loggers
	 */
	@Fetch(FetchMode.SUBSELECT)
	@OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL, mappedBy = "account")
	@OrderBy("dateTime DESC")
	public Set<Logger> getLoggers() {
		return loggers;
	}

	/**
	 * Sets the loggers.
	 *
	 * @param loggers the new loggers
	 */
	public void setLoggers(Set<Logger> loggers) {
		this.loggers = loggers;
	}
}
