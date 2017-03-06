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
import javax.persistence.OrderBy;
import javax.persistence.Table;

import org.hibernate.annotations.Cascade;

import com.fasterxml.jackson.annotation.JsonIgnore;

// TODO: Auto-generated Javadoc
/**
 * The Class SkillResume.
 */
@Entity
@Table(name = "skill_resume")
public class SkillResume implements Serializable {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = -4024322171817710314L;

	/** The id. */
	private Integer id;

	/** The resume. */
	private Resume resume;

	/** The skill. */
	private Skill skill;

	/** The endorse set. */
	private Set<Endorse> endorseSet;

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
	 * Gets the resume.
	 *
	 * @return the resume
	 */
	@JsonIgnore
	@OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(name = "resume_id")
	@Cascade(value = { org.hibernate.annotations.CascadeType.SAVE_UPDATE })
	public Resume getResume() {
		return resume;
	}

	/**
	 * Sets the resume.
	 *
	 * @param resume the new resume
	 */
	public void setResume(Resume resume) {
		this.resume = resume;
	}

	/**
	 * Gets the skill.
	 *
	 * @return the skill
	 */
	@OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(name = "skill_id")
	@Cascade(value = { org.hibernate.annotations.CascadeType.SAVE_UPDATE })
	public Skill getSkill() {
		return skill;
	}

	/**
	 * Sets the skill.
	 *
	 * @param skill the new skill
	 */
	public void setSkill(Skill skill) {
		this.skill = skill;
	}

	/**
	 * Gets the endorse set.
	 *
	 * @return the endorse set
	 */
	@OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(name = "skill_resume_id")
	@Cascade(value = { org.hibernate.annotations.CascadeType.SAVE_UPDATE })
	@OrderBy("createdDate DESC")
	public Set<Endorse> getEndorseSet() {
		return endorseSet;
	}

	/**
	 * Sets the endorse set.
	 *
	 * @param endorseSet the new endorse set
	 */
	public void setEndorseSet(Set<Endorse> endorseSet) {
		this.endorseSet = endorseSet;
	}

}
