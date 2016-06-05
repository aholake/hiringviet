package vn.com.hiringviet.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "change_log")
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
public class ChangeLog implements Serializable {

	private static final long serialVersionUID = -393256196794848432L;

	private int id;

	private Date createdDate;

	private Date updatedDate;

	private Date deletedDate;

	private int status;

	private Member member;

	private Company company;

	private EducationHistory educationHistory;

	private EmploymentHistory employmentHistory;

	private Job job;

	private JobCategory jobCategory;

	private Comment comment;

	private ReplyComment replyComment;

	private Resume resume;

	private Position position;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "created_date")
	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "updated_date")
	public Date getUpdatedDate() {
		return updatedDate;
	}

	public void setUpdatedDate(Date updatedDate) {
		this.updatedDate = updatedDate;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "deleted_date")
	public Date getDeletedDate() {
		return deletedDate;
	}

	public void setDeletedDate(Date deletedDate) {
		this.deletedDate = deletedDate;
	}

	@Column(name = "status")
	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	@JsonIgnore
	@OneToOne(cascade = CascadeType.ALL, mappedBy = "changeLog")
	public Member getMember() {
		return member;
	}

	public void setMember(Member member) {
		this.member = member;
	}

	@JsonIgnore
	@OneToOne(cascade = CascadeType.ALL, mappedBy = "changeLog")
	public Company getCompany() {
		return company;
	}

	public void setCompany(Company company) {
		this.company = company;
	}

	@JsonIgnore
	@OneToOne(cascade = CascadeType.ALL, mappedBy = "changeLog")
	public EducationHistory getEducationHistory() {
		return educationHistory;
	}

	public void setEducationHistory(EducationHistory educationHistory) {
		this.educationHistory = educationHistory;
	}

	@JsonIgnore
	@OneToOne(cascade = CascadeType.ALL, mappedBy = "changeLog")
	public EmploymentHistory getEmploymentHistory() {
		return employmentHistory;
	}

	public void setEmploymentHistory(EmploymentHistory employmentHistory) {
		this.employmentHistory = employmentHistory;
	}

	@JsonIgnore
	@OneToOne(cascade = CascadeType.ALL, mappedBy = "changeLog")
	public Job getJob() {
		return job;
	}

	public void setJob(Job job) {
		this.job = job;
	}

	@JsonIgnore
	@OneToOne(cascade = CascadeType.ALL, mappedBy = "changeLog")
	public JobCategory getJobCategory() {
		return jobCategory;
	}

	public void setJobCategory(JobCategory jobCategory) {
		this.jobCategory = jobCategory;
	}

	@JsonIgnore
	@OneToOne(cascade = CascadeType.ALL, mappedBy = "changeLog")
	public Comment getComment() {
		return comment;
	}

	public void setComment(Comment comment) {
		this.comment = comment;
	}

	@JsonIgnore
	@OneToOne(cascade = CascadeType.ALL, mappedBy = "changeLog")
	public ReplyComment getReplyComment() {
		return replyComment;
	}

	public void setReplyComment(ReplyComment replyComment) {
		this.replyComment = replyComment;
	}

	@JsonIgnore
	@OneToOne(cascade = CascadeType.ALL, mappedBy = "changeLog")
	public Resume getResume() {
		return resume;
	}

	public void setResume(Resume resume) {
		this.resume = resume;
	}

	@JsonIgnore
	@OneToOne(cascade = CascadeType.ALL, mappedBy = "changeLog")
	public Position getPosition() {
		return position;
	}

	public void setPosition(Position position) {
		this.position = position;
	}

}
