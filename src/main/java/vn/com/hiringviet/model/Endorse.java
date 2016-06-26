package vn.com.hiringviet.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "endorse")
public class Endorse implements Serializable {

	private static final long serialVersionUID = -5124721730324405041L;

	private Integer id;

	private Account account;

	private Date createdDate;

	private SkillResume skillResume;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "created_date")
	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "member_id")
	public Account getAccount() {
		return account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}

	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name = "skill_resume_id")
	public SkillResume getSkillResume() {
		return skillResume;
	}

	public void setSkillResume(SkillResume skillResume) {
		this.skillResume = skillResume;
	}

}
