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

@Entity
@Table(name = "position")
public class Position implements Serializable {

	private static final long serialVersionUID = -45982404463146068L;

	private Integer positionID;

	private String displayName;

//	private Set<Job> jobSet;

	private ChangeLog changeLog;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Integer getPositionID() {
		return positionID;
	}

	public void setPositionID(Integer positionID) {
		this.positionID = positionID;
	}

	@Column(name = "display_name")
	public String getDisplayName() {
		return displayName;
	}

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

	@JsonIgnore
	@OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(name = "change_log_id")
	@Cascade({ org.hibernate.annotations.CascadeType.SAVE_UPDATE })
	public ChangeLog getChangeLog() {
		return changeLog;
	}

	public void setChangeLog(ChangeLog changeLog) {
		this.changeLog = changeLog;
	}

}
