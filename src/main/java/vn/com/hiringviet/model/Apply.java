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
@Table(name = "APPLY", catalog = "hiringviet")
public class Apply implements Serializable {

	private static final long serialVersionUID = 8790898850284130257L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "APPLY_ID", unique = true, nullable = false, length = 11)
	private Integer applyID;

	@Column(name = "MEMBER_ID", unique = true, nullable = false, length = 11)
	private Integer memberID;

	@Column(name = "JOB_ID", unique = true, nullable = false, length = 11)
	private Integer jobID;

	@Column(name = "STATUS", nullable = false, length = 1)
	private Integer status;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "CREATE_AT", nullable = false)
	private Date createAt;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "UPDATE_AT", nullable = false)
	private Date updateAt;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "DELETE_AT", nullable = true)
	private Date deleteAt;

	public Apply() {
		super();
	}

	public Integer getApplyID() {
		return applyID;
	}

	public void setApplyID(Integer applyID) {
		this.applyID = applyID;
	}

	public Integer getMemberID() {
		return memberID;
	}

	public void setMemberID(Integer memberID) {
		this.memberID = memberID;
	}

	public Integer getJobID() {
		return jobID;
	}

	public void setJobID(Integer jobID) {
		this.jobID = jobID;
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
