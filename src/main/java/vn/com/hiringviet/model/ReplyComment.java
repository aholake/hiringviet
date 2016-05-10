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
@Table(name = "REPLY_COMMENT", catalog = "hiringviet")
public class ReplyComment implements Serializable {

	private static final long serialVersionUID = -7323150243345284504L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "REPLY_COMMENT_ID", unique = true, nullable = false, length = 11)
	private Integer replyCommentID;

	@Column(name = "COMMENT_ID", unique = true, nullable = false, length = 11)
	private Integer commentID;

	@Column(name = "COMMENT", nullable = false, length = 300)
	private String comment;

	@Column(name = "STATUS", nullable = false, length = 1)
	private Integer status;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "CREATED_AT", nullable = false)
	private Date createAt;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "UPDATED_AT", nullable = false)
	private Date updateAt;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "DELETED_AT", nullable = true)
	private Date deleteAt;

	public Integer getReplyCommentID() {
		return replyCommentID;
	}

	public void setReplyCommentID(Integer replyCommentID) {
		this.replyCommentID = replyCommentID;
	}

	public Integer getCommentID() {
		return commentID;
	}

	public void setCommentID(Integer commentID) {
		this.commentID = commentID;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
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

	public Date getUpdateAt() {
		return updateAt;
	}

	public void setUpdateAt(Date updateAt) {
		this.updateAt = updateAt;
	}

	public Date getDeleteAt() {
		return deleteAt;
	}

	public void setDeleteAt(Date deleteAt) {
		this.deleteAt = deleteAt;
	}

}
