package vn.com.hiringviet.dto;

import java.io.Serializable;

import vn.com.hiringviet.model.Account;
import vn.com.hiringviet.model.ChangeLog;

/**
 * The Class ReplyCommentDTO.
 */
public class ReplyCommentDTO implements Serializable {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 9200934457043340407L;

	/** The reply comment id. */
	private Integer replyCommentId;

	/** The member id. */
	private Integer memberId;

	/** The reply comment. */
	private String replyComment;

	/** The avatar image. */
	private String avatarImage;

	/** The first name. */
	private String firstName;

	/** The last name. */
	private String lastName;

	/** The change log. */
	private ChangeLog changeLog;

	/** The account. */
	private Account account;

	/** The comment id. */
	private Integer commentId;

	/** The display name. */
	private String displayName;

	private Integer accountId;

	/**
	 * Gets the reply comment id.
	 *
	 * @return the reply comment id
	 */
	public Integer getReplyCommentId() {
		return replyCommentId;
	}

	/**
	 * Sets the reply comment id.
	 *
	 * @param replyCommentId the new reply comment id
	 */
	public void setReplyCommentId(Integer replyCommentId) {
		this.replyCommentId = replyCommentId;
	}

	/**
	 * Gets the reply comment.
	 *
	 * @return the reply comment
	 */
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
	 * Gets the change log.
	 *
	 * @return the change log
	 */
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

	/**
	 * Gets the first name.
	 *
	 * @return the first name
	 */
	public String getFirstName() {
		return firstName;
	}

	/**
	 * Sets the first name.
	 *
	 * @param firstName the new first name
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	/**
	 * Gets the last name.
	 *
	 * @return the last name
	 */
	public String getLastName() {
		return lastName;
	}

	/**
	 * Sets the last name.
	 *
	 * @param lastName the new last name
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	/**
	 * Gets the member id.
	 *
	 * @return the member id
	 */
	public Integer getMemberId() {
		return memberId;
	}

	/**
	 * Sets the member id.
	 *
	 * @param memberId the new member id
	 */
	public void setMemberId(Integer memberId) {
		this.memberId = memberId;
	}

	/**
	 * Gets the comment id.
	 *
	 * @return the comment id
	 */
	public Integer getCommentId() {
		return commentId;
	}

	/**
	 * Sets the comment id.
	 *
	 * @param commentId the new comment id
	 */
	public void setCommentId(Integer commentId) {
		this.commentId = commentId;
	}

	/**
	 * Gets the display name.
	 *
	 * @return the display name
	 */
	public String getDisplayName() {
		return displayName;
	}

	/**
	 * Sets the display name.
	 *
	 * @param displayName the new display name
	 */
	public void setDisplayName(String displayName) {
		this.displayName = displayName;
	}

	public Integer getAccountId() {
		return accountId;
	}

	public void setAccountId(Integer accountId) {
		this.accountId = accountId;
	}

}
