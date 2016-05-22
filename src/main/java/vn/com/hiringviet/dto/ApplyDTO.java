package vn.com.hiringviet.dto;

import java.io.Serializable;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })	
public class ApplyDTO implements Serializable {

	private static final long serialVersionUID = 8790898850284130257L;

	private Integer applyID;

	private MemberDTO member;

	private JobDTO job;

	private Integer jobID;

	private Integer status;

	private Date createAt;

	private Date updateAt;

	private Date deleteAt;

	public Integer getApplyID() {
		return applyID;
	}

	public void setApplyID(Integer applyID) {
		this.applyID = applyID;
	}

	public MemberDTO getMember() {
		return member;
	}

	public void setMember(MemberDTO member) {
		this.member = member;
	}

	public JobDTO getJob() {
		return job;
	}

	public void setJob(JobDTO job) {
		this.job = job;
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
