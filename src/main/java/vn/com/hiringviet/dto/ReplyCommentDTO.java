package vn.com.hiringviet.dto;

import java.io.Serializable;
import java.util.Date;

public class ReplyCommentDTO implements Serializable {

	private static final long serialVersionUID = -7323150243345284504L;

	private Integer replyCommentID;

	private CommentDTO comment;

	private String replyComment;

	private Integer status;

	private Date createdAt;

	private Date updatedAt;

	private Date deletedAt;

	public Integer getReplyCommentID() {
		return replyCommentID;
	}

	public void setReplyCommentID(Integer replyCommentID) {
		this.replyCommentID = replyCommentID;
	}

	public CommentDTO getComment() {
		return comment;
	}

	public void setComment(CommentDTO comment) {
		this.comment = comment;
	}

	public String getReplyComment() {
		return replyComment;
	}

	public void setReplyComment(String replyComment) {
		this.replyComment = replyComment;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public Date getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}

	public Date getDeletedAt() {
		return deletedAt;
	}

	public void setDeletedAt(Date deletedAt) {
		this.deletedAt = deletedAt;
	}

}
