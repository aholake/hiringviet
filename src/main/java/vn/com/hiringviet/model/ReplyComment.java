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

import org.hibernate.annotations.Cascade;

@Entity
@Table(name = "reply_comment")
public class ReplyComment implements Serializable {

	private static final long serialVersionUID = -7323150243345284504L;

	private Integer id;

	private String replyComment;

	private Comment comment;

	private ChangeLog changeLog;

	private Account account;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@Column(name = "reply_comment")
	public String getReplyComment() {
		return replyComment;
	}

	public void setReplyComment(String replyComment) {
		this.replyComment = replyComment;
	}

	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.MERGE)
	@JoinColumn(name = "comment_id")
	@Cascade({ org.hibernate.annotations.CascadeType.SAVE_UPDATE })
	public Comment getComment() {
		return comment;
	}

	public void setComment(Comment comment) {
		this.comment = comment;
	}

	@OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(name = "change_log_id")
	@Cascade({ org.hibernate.annotations.CascadeType.ALL })
	public ChangeLog getChangeLog() {
		return changeLog;
	}

	public void setChangeLog(ChangeLog changeLog) {
		this.changeLog = changeLog;
	}

	@OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.MERGE)
	@JoinColumn(name = "account_id")
	@Cascade({ org.hibernate.annotations.CascadeType.SAVE_UPDATE })
	public Account getAccount() {
		return account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}

}
