package vn.com.hiringviet.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "FOLLOW", catalog = "hiringviet")
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
public class Follow implements Serializable {

	private static final long serialVersionUID = -4464300694714420831L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "FOLLOW_ID", unique = true, nullable = false, length = 11)
	private Integer followID;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "FROM_MEMBER_ID", nullable = false)
	private Member fromMemberID;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "TO_MEMBER_ID", nullable = false)
	private Member toMemberID;

	@Column(name = "STATUS", nullable = false, length = 1)
	private Integer status;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "CREATED_AT", nullable = false)
	private Date createAt;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "UPDATED_AT", nullable = false)
	private Date updateAt;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "DELETED_AT")
	private Date deleteAt;

	public Integer getFollowID() {
		return followID;
	}

	public void setFollowID(Integer followID) {
		this.followID = followID;
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
