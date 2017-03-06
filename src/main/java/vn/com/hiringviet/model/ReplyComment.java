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

// TODO: Auto-generated Javadoc
/**
 * The Class ReplyComment.
 */
@Entity
@Table(name = "reply_comment")
public class ReplyComment implements Serializable {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = -7323150243345284504L;

	/** The id. */
	private Integer id;

	/** The reply comment. */
	private String replyComment;

	/** The comment. */
	private Comment comment;

	/** The change log. */
	private ChangeLog changeLog;

	/** The account. */
	private Account account;

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
	 * Gets the reply comment.
	 *
	 * @return the reply comment
	 */
	@Column(name = "reply_comment")
	public String getReplyComment() {
		return replyComment;
	}

	/**
	 * Sets the reply comment.
	 *
	 * @param replyComment the new reply comment
	 */
	public void setReplyComment(String replyComment) {
		this.replyComment = replyComment;
	}

	/**
	 * Gets the comment.
	 *
	 * @return the comment
	 */
	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.MERGE)
	@JoinColumn(name = "comment_id")
	@Cascade({ org.hibernate.annotations.CascadeType.SAVE_UPDATE })
	public Comment getComment() {
		return comment;
	}

	/**
	 * Sets the comment.
	 *
	 * @param comment the new comment
	 */
	public void setComment(Comment comment) {
		this.comment = comment;
	}

	/**
	 * Gets the change log.
	 *
	 * @return the change log
	 */
	@OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(name = "change_log_id")
	@Cascade({ org.hibernate.annotations.CascadeType.ALL })
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

	/**
	 * Gets the account.
	 *
	 * @return the account
	 */
	@OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.MERGE)
	@JoinColumn(name = "account_id")
	@Cascade({ org.hibernate.annotations.CascadeType.SAVE_UPDATE })
	public Account getAccount() {
		return account;
	}

	/**
	 * Sets the account.
	 *
	 * @param account the new account
	 */
	public void setAccount(Account account) {
		this.account = account;
	}

}
