package vn.com.hiringviet.dto;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

public class CommentDTO implements Serializable {

	private static final long serialVersionUID = 9219480321037261930L;

	private Integer commentID;

	private JobDTO job;

	private Set<ReplyCommentDTO> replyCommentSet;

	private String comment;

	private Integer status;

	private Date createAt;

	private Date updateAt;

	private Date deleteAt;

	public Integer getCommentID() {
		return commentID;
	}

	public void setCommentID(Integer commentID) {
		this.commentID = commentID;
	}

	public JobDTO getJob() {
		return job;
	}

	public void setJob(JobDTO job) {
		this.job = job;
	}

	public Set<ReplyCommentDTO> getReplyCommentSet() {
		return replyCommentSet;
	}

	public void setReplyCommentSet(Set<ReplyCommentDTO> replyCommentSet) {
		this.replyCommentSet = replyCommentSet;
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
