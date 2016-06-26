package vn.com.hiringviet.model;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Cascade;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "skill_resume")
public class SkillResume implements Serializable {

	private static final long serialVersionUID = -4024322171817710314L;

	private Integer id;

	private Resume resume;

	private Skill skill;

	private Set<Endorse> endorseSet;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@JsonIgnore
	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "resume_id")
	@Cascade(value = { org.hibernate.annotations.CascadeType.SAVE_UPDATE })
	public Resume getResume() {
		return resume;
	}

	public void setResume(Resume resume) {
		this.resume = resume;
	}

	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "skill_id")
	@Cascade(value = { org.hibernate.annotations.CascadeType.SAVE_UPDATE })
	public Skill getSkill() {
		return skill;
	}

	public void setSkill(Skill skill) {
		this.skill = skill;
	}

	@OneToMany(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
	@JoinColumn(name = "skill_resume_id")
	@Cascade({ org.hibernate.annotations.CascadeType.SAVE_UPDATE })
	public Set<Endorse> getEndorseSet() {
		return endorseSet;
	}

	public void setEndorseSet(Set<Endorse> endorseSet) {
		this.endorseSet = endorseSet;
	}

}
