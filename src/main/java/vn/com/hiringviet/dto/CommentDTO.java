package vn.com.hiringviet.dto;

import java.io.Serializable;

import vn.com.hiringviet.model.ChangeLog;
import vn.com.hiringviet.model.Member;


/**
 * The Class CommentDTO.
 */
public class CommentDTO implements Serializable {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 5114712305837473580L;

	/** The id. */
	private Integer id;

	/** The member id. */
	private Integer memberId;

	/** The comment id. */
	private Integer commentId;

	/** The first name. */
	private String firstName;

	/** The last name. */
	private String lastName;

	/** The comment. */
	private String comment;

	/** The avatar image. */
	private String avatarImage;

	/** The change log. */
	private ChangeLog changeLog;

	/** The member. */
	private Member member;

	/** The post. */
	private Integer postId;

	/** The job. */
	private Integer jobId;

	/** The number reply comment. */
	private Long numberReplyComment;

	/**
	 * Gets the id.
	 *
	 * @return the id
	 */
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
	 * @param memberId
	 *            the new member id
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
	 * @param commentId
	 *            the new comment id
	 */
	public void setCommentId(Integer commentId) {
		this.commentId = commentId;
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
	 * @param firstName
	 *            the new first name
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
	 * @param lastName
	 *            the new last name
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	/**
	 * Gets the comment.
	 *
	 * @return the comment
	 */
	public String getComment() {
		return comment;
	}

	/**
	 * Sets the comment.
	 *
	 * @param comment
	 *            the new comment
	 */
	public void setComment(String comment) {
		this.comment = comment;
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
	 * @param avatarImage
	 *            the new avatar image
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
	 * @param changeLog
	 *            the new change log
	 */
	public void setChangeLog(ChangeLog changeLog) {
		this.changeLog = changeLog;
	}

	/**
	 * Gets the member.
	 *
	 * @return the member
	 */
	public Member getMember() {
		return member;
	}

	/**
	 * Sets the member.
	 *
	 * @param member
	 *            the new member
	 */
	public void setMember(Member member) {
		this.member = member;
	}

	/**
	 * Gets the post id.
	 *
	 * @return the post id
	 */
	public Integer getPostId() {
		return postId;
	}

	/**
	 * Sets the post id.
	 *
	 * @param postId
	 *            the new post id
	 */
	public void setPostId(Integer postId) {
		this.postId = postId;
	}

	/**
	 * Gets the job id.
	 *
	 * @return the job id
	 */
	public Integer getJobId() {
		return jobId;
	}

	/**
	 * Sets the job id.
	 *
	 * @param jobId
	 *            the new job id
	 */
	public void setJobId(Integer jobId) {
		this.jobId = jobId;
	}

	/**
	 * Gets the number reply comment.
	 *
	 * @return the number reply comment
	 */
	public Long getNumberReplyComment() {
		return numberReplyComment;
	}

	/**
	 * Sets the number reply comment.
	 *
	 * @param numberReplyComment the new number reply comment
	 */
	public void setNumberReplyComment(Long numberReplyComment) {
		this.numberReplyComment = numberReplyComment;
	}

}
