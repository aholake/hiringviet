package vn.com.hiringviet.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "DEGREE", catalog = "hiringviet")
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
public class Degree implements Serializable {

	private static final long serialVersionUID = 3205589962671010114L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "DEGREE_ID", nullable = false, length = 11)
	private Integer degreeID;

	@Column(name = "DISPLAY_NAME", nullable = false)
	private String displayName;

	@Column(name = "STATUS", nullable = false)
	private Integer status;

	@Column(name = "CREATED_AT", nullable = false)
	private Date createdAt;

	@Column(name = "UPDATED_AT", nullable = false)
	private Date updatedAt;

	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "degree")
	private List<EducationHistory> educationHistorySet;

	public Integer getDegreeID() {
		return degreeID;
	}

	public void setDegreeID(Integer degreeID) {
		this.degreeID = degreeID;
	}

	public String getDisplayName() {
		return displayName;
	}

	public void setDisplayName(String displayName) {
		this.displayName = displayName;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public Date getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}

	public List<EducationHistory> getEducationHistorySet() {
		return educationHistorySet;
	}

	public void setEducationHistorySet(List<EducationHistory> educationHistorySet) {
		this.educationHistorySet = educationHistorySet;
	}

}
