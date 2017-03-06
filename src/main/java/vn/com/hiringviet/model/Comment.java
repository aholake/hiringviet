package vn.com.hiringviet.model;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.OrderBy;
import javax.persistence.Table;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.Type;

import com.fasterxml.jackson.annotation.JsonIgnore;

// TODO: Auto-generated Javadoc
/**
 * The Class Comment.
 */
@Entity
@Table(name = "comment")
public class Comment implements Serializable {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 9219480321037261930L;

	/** The id. */
	private Integer id;

	/** The member. */
	private Member member;

	/** The comment. */
	private String comment;

	/** The change log. */
	private ChangeLog changeLog;

	/** The post. */
	private Post post;

	/** The job. */
	private Job job;

	/** The reply comment set. */
	private Set<ReplyComment> replyCommentSet;

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
	 * Gets the member.
	 *
	 * @return the member
	 */
	@JsonIgnore
	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.MERGE)
	//@Cascade({ org.hibernate.annotations.CascadeType.ALL })
	@JoinColumn(name = "member_id")
	public Member getMember() {
		return member;
	}

	/**
	 * Sets the member.
	 *
	 * @param member the new member
	 */
	public void setMember(Member member) {
		this.member = member;
	}

	/**
	 * Gets the comment.
	 *
	 * @return the comment
	 */
	@Column(name = "comment")
	@Type(type = "text")
	public String getComment() {
		return comment;
	}

	/**
	 * Sets the comment.
	 *
	 * @param comment the new comment
	 */
	public void setComment(String comment) {
		this.comment = comment;
	}

	/**
	 * Gets the change log.
	 *
	 * @return the change log
	 */
	@OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(name = "change_log_id")
	@Cascade({ org.hibernate.annotations.CascadeType.SAVE_UPDATE })
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
	 * Gets the post.
	 *
	 * @return the post
	 */
	@JsonIgnore
	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.MERGE)
	@JoinColumn(name = "post_id")
	public Post getPost() {
		return post;
	}

	/**
	 * Sets the post.
	 *
	 * @param post the new post
	 */
	public void setPost(Post post) {
		this.post = post;
	}

	/**
	 * Gets the job.
	 *
	 * @return the job
	 */
	@JsonIgnore
	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.MERGE)
	@JoinColumn(name = "job_id")
	public Job getJob() {
		return job;
	}

	/**
	 * Sets the job.
	 *
	 * @param job the new job
	 */
	public void setJob(Job job) {
		this.job = job;
	}

	/**
	 * Gets the reply comment set.
	 *
	 * @return the reply comment set
	 */
	@Cascade(value = { org.hibernate.annotations.CascadeType.SAVE_UPDATE })
	@OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(name = "comment_id")
	@OrderBy("id DESC")
	public Set<ReplyComment> getReplyCommentSet() {
		return replyCommentSet;
	}

	/**
	 * Sets the reply comment set.
	 *
	 * @param replyCommentSet the new reply comment set
	 */
	public void setReplyCommentSet(Set<ReplyComment> replyCommentSet) {
		this.replyCommentSet = replyCommentSet;
	}

}
