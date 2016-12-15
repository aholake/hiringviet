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
import javax.persistence.Table;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import vn.com.hiringviet.common.AccountRoleEnum;
import vn.com.hiringviet.common.StatusEnum;

import com.fasterxml.jackson.annotation.JsonIgnore;

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

	private String avatarImageKey;

	/** The cover image. */
	private String coverImage;

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

	private StatusEnum status;

	private String activeUrl;

	private Company company;

	private Member member;

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

	@Enumerated(EnumType.ORDINAL)
	public AccountRoleEnum getUserRole() {
		return userRole;
	}

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

	@Column(name = "avatar_image")
	public String getAvatarImage() {
		return avatarImage;
	}

	public void setAvatarImage(String avatarImage) {
		this.avatarImage = avatarImage;
	}

	@Column(name = "cover_image")
	public String getCoverImage() {
		return coverImage;
	}

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

	@JsonIgnore
	@OneToOne(mappedBy = "account", fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
	public Company getCompany() {
		return company;
	}

	public void setCompany(Company company) {
		this.company = company;
	}

	@JsonIgnore
	@OneToOne(mappedBy = "account", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	public Member getMember() {
		return member;
	}

	public void setMember(Member member) {
		this.member = member;
	}

	@Column(name = "status")
	@Enumerated(EnumType.ORDINAL)
	public StatusEnum getStatus() {
		return status;
	}

	public void setStatus(StatusEnum status) {
		this.status = status;
	}

	@Column(name = "active_url")
	public String getActiveUrl() {
		return activeUrl;
	}

	public void setActiveUrl(String activeUrl) {
		this.activeUrl = activeUrl;
	}

	@Column(name = "avatar_image_key")
	public String getAvatarImageKey() {
		return avatarImageKey;
	}

	public void setAvatarImageKey(String avatarImageKey) {
		this.avatarImageKey = avatarImageKey;
	}

	@Column(name = "cover_image_key")
	public String getCoverImageKey() {
		return coverImageKey;
	}

	public void setCoverImageKey(String coverImageKey) {
		this.coverImageKey = coverImageKey;
	}

}
