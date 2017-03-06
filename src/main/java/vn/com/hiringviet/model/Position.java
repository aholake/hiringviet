package vn.com.hiringviet.model;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Cascade;

import com.fasterxml.jackson.annotation.JsonIgnore;

// TODO: Auto-generated Javadoc
/**
 * The Class Position.
 */
@Entity
@Table(name = "position")
public class Position implements Serializable {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = -45982404463146068L;

	/** The position id. */
	private Integer positionID;

	/** The display name. */
	private String displayName;

//	private Set<Job> jobSet;

	/** The change log. */
private ChangeLog changeLog;

	/**
	 * Gets the position id.
	 *
	 * @return the position id
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Integer getPositionID() {
		return positionID;
	}

	/**
	 * Sets the position id.
	 *
	 * @param positionID the new position id
	 */
	public void setPositionID(Integer positionID) {
		this.positionID = positionID;
	}

	/**
	 * Gets the display name.
	 *
	 * @return the display name
	 */
	@Column(name = "display_name")
	public String getDisplayName() {
		return displayName;
	}

	/**
	 * Sets the display name.
	 *
	 * @param displayName the new display name
	 */
	public void setDisplayName(String displayName) {
		this.displayName = displayName;
	}

//	@JsonIgnore
//	@OneToMany(cascade = CascadeType.ALL, mappedBy = "position")
//	public Set<Job> getJobSet() {
//		return jobSet;
//	}

//	public void setJobSet(Set<Job> jobSet) {
//		this.jobSet = jobSet;
//	}

	/**
 * Gets the change log.
 *
 * @return the change log
 */
@JsonIgnore
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

}
