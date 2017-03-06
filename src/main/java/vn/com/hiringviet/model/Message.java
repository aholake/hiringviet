package vn.com.hiringviet.model;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Type;

import com.fasterxml.jackson.annotation.JsonIgnore;

// TODO: Auto-generated Javadoc
/**
 * The Class Message.
 */
@Entity
@Table(name = "message")
public class Message implements Serializable {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = -6319605028828102552L;

	/** The id. */
	private Integer id;

	/** The owner account. */
	private Account ownerAccount;

	/** The sender account. */
	private Account senderAccount;

	/** The type mail. */
	private Integer typeMail;

	/** The title. */
	private String title;

	/** The content. */
	private String content;

	/** The change log. */
	private ChangeLog changeLog;

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
	 * @param id the new id
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	/**
	 * Gets the owner account.
	 *
	 * @return the owner account
	 */
	@JsonIgnore
	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name = "owner_account_id")
	public Account getOwnerAccount() {
		return ownerAccount;
	}

	/**
	 * Sets the owner account.
	 *
	 * @param ownerAccount the new owner account
	 */
	public void setOwnerAccount(Account ownerAccount) {
		this.ownerAccount = ownerAccount;
	}

	/**
	 * Gets the sender account.
	 *
	 * @return the sender account
	 */
	@JsonIgnore
	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name = "sender_account_id")
	public Account getSenderAccount() {
		return senderAccount;
	}

	/**
	 * Sets the sender account.
	 *
	 * @param senderAccount the new sender account
	 */
	public void setSenderAccount(Account senderAccount) {
		this.senderAccount = senderAccount;
	}

	/**
	 * Gets the type mail.
	 *
	 * @return the type mail
	 */
	@Column(name = "type_mail")
	public Integer getTypeMail() {
		return typeMail;
	}

	/**
	 * Sets the type mail.
	 *
	 * @param typeMail the new type mail
	 */
	public void setTypeMail(Integer typeMail) {
		this.typeMail = typeMail;
	}

	/**
	 * Gets the title.
	 *
	 * @return the title
	 */
	@Column(name = "title")
	public String getTitle() {
		return title;
	}

	/**
	 * Sets the title.
	 *
	 * @param title the new title
	 */
	public void setTitle(String title) {
		this.title = title;
	}

	/**
	 * Gets the content.
	 *
	 * @return the content
	 */
	@Column(name = "content")
	@Type(type = "text")
	public String getContent() {
		return content;
	}

	/**
	 * Sets the content.
	 *
	 * @param content the new content
	 */
	public void setContent(String content) {
		this.content = content;
	}

	/**
	 * Gets the change log.
	 *
	 * @return the change log
	 */
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "change_log_id")
	public ChangeLog getChangeLog() {
		return changeLog;
	}

	/**
	 * Sets the change log.
	 *
	 * @param changeLog the new change log
	 */
	public void setChangeLog(ChangeLog changeLog) {
		this.changeLog = changeLog;
	}
}
