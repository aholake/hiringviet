package vn.com.hiringviet.dto;

import java.io.Serializable;
import java.util.Date;

import vn.com.hiringviet.model.Member;

public class MailboxDTO implements Serializable {

	private static final long serialVersionUID = -6319605028828102552L;

	private Integer mailboxID;

	private Member fromMemberID;

	private Member toMemberID;

	private Integer typeMail;

	private String title;

	private String content;

	private Integer status;

	private Date createAt;

	private Date deleteAt;

	public Integer getMailboxID() {
		return mailboxID;
	}

	public void setMailboxID(Integer mailboxID) {
		this.mailboxID = mailboxID;
	}

	public Member getFromMemberID() {
		return fromMemberID;
	}

	public void setFromMemberID(Member fromMemberID) {
		this.fromMemberID = fromMemberID;
	}

	public Member getToMemberID() {
		return toMemberID;
	}

	public void setToMemberID(Member toMemberID) {
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
