package vn.com.hiringviet.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "skill")
public class Skill implements Serializable {

	private static final long serialVersionUID = -5381027238277880906L;

	private Integer id;

	private String displayName;

	private Integer addingNumber;

	private Integer type;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Integer getId() {
		return id;
	}

	public void setId(Integer skillID) {
		this.id = skillID;
	}

	@Column(name = "display_name")
	public String getDisplayName() {
		return displayName;
	}

	public void setDisplayName(String displayName) {
		this.displayName = displayName;
	}

	@Column(name = "adding_number")
	public Integer getAddingNumber() {
		return addingNumber;
	}

	public void setAddingNumber(Integer addingNumber) {
		this.addingNumber = addingNumber;
	}

	@Column(name = "type")
	public Integer getType() {
		return type;
	}

	public void setType(Integer type) {
		this.type = type;
	}

}
