package vn.com.hiringviet.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "MAILBOX", catalog = "hiringviet")
public class Mailbox implements Serializable {

	private static final long serialVersionUID = -6319605028828102552L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "MAILBOX_ID", unique = true, nullable = false, length = 11)
	private Integer mailboxID;

	@Column(name = "FROM_MEMBER_ID", nullable = false, length = 11)
	private Integer fromMemberID;

	@Column(name = "TO_MEMBER_ID", nullable = false, length = 11)
	private Integer toMemberID;

	@Column(name = "TYPE_MAIL", nullable = false)
	private Integer typeMail;

	@Column(name = "TITLE", nullable = false, length = 300)
	private String title;

	@Column(name = "CONTENT", nullable = false, length = 300)
	private String content;

	@Column(name = "STATUS", nullable = false, length = 1)
	private Integer status;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "CREATED_AT", nullable = false)
	private Date createAt;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "DELETED_AT", nullable = true)
	private Date deleteAt;

	public Integer getMailboxID() {
		return mailboxID;
	}

	public void setMailboxID(Integer mailboxID) {
		this.mailboxID = mailboxID;
	}

	public Integer getFromMemberID() {
		return fromMemberID;
	}

	public void setFromMemberID(Integer fromMemberID) {
		this.fromMemberID = fromMemberID;
	}

	public Integer getToMemberID() {
		return toMemberID;
	}

	public void setToMemberID(Integer toMemberID) {
		this.toMemberID = toMemberID;
	}

	public Integer getTypeMail() {
		return typeMail;
	}

	public void setTypeMail(Integer typeMail) {
		this.typeMail = typeMail;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public Date getCreateAt() {
		return createAt;
	}

	public void setCreateAt(Date createAt) {
		this.createAt = createAt;
	}

	public Date getDeleteAt() {
		return deleteAt;
	}

	public void setDeleteAt(Date deleteAt) {
		this.deleteAt = deleteAt;
	}

}
