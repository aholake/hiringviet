package vn.com.hiringviet.dto;

import java.io.Serializable;
import java.sql.Date;

public class CommentDTO implements Serializable {

	private static final long serialVersionUID = 5114712305837473580L;

	private Integer memberId;

	private Integer commentId;

	private Integer replyCommentId;

	private String firstName;

	private String lastName;

	private String comment;

	private String replyComment;

	private Date commentDate;

	private Date replyCommentDate;

	private String avatar;

	public Integer getMemberId() {
		return memberId;
	}

	public void setMemberId(Integer memberId) {
		this.memberId = memberId;
	}

	public Integer getCommentId() {
		return commentId;
	}

	public void setCommentId(Integer commentId) {
		this.commentId = commentId;
	}

	public Integer getReplyCommentId() {
		return replyCommentId;
	}

	public void setReplyCommentId(Integer replyCommentId) {
		this.replyCommentId = replyCommentId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public String getReplyComment() {
		return replyComment;
	}

	public void setReplyComment(String replyComment) {
		this.replyComment = replyComment;
	}

	public Date getCommentDate() {
		return commentDate;
	}

	public void setCommentDate(Date commentDate) {
		this.commentDate = commentDate;
	}

	public Date getReplyCommentDate() {
		return replyCommentDate;
	}

	public void setReplyCommentDate(Date replyCommentDate) {
		this.replyCommentDate = replyCommentDate;
	}

	public String getAvatar() {
		return avatar;
	}

	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}

}
