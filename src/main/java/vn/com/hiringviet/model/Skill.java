package vn.com.hiringviet.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

// TODO: Auto-generated Javadoc
/**
 * The Class Skill.
 */
@Entity
@Table(name = "skill")
public class Skill implements Serializable {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = -5381027238277880906L;

	/** The id. */
	private Integer id;

	/** The display name. */
	private String displayName;

	/** The adding number. */
	private Integer addingNumber;

	/** The type. */
	private Integer type;

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
	 * @param skillID the new id
	 */
	public void setId(Integer skillID) {
		this.id = skillID;
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

	/**
	 * Gets the adding number.
	 *
	 * @return the adding number
	 */
	@Column(name = "adding_number")
	public Integer getAddingNumber() {
		return addingNumber;
	}

	/**
	 * Sets the adding number.
	 *
	 * @param addingNumber the new adding number
	 */
	public void setAddingNumber(Integer addingNumber) {
		this.addingNumber = addingNumber;
	}

	/**
	 * Gets the type.
	 *
	 * @return the type
	 */
	@Column(name = "type")
	public Integer getType() {
		return type;
	}

	/**
	 * Sets the type.
	 *
	 * @param type the new type
	 */
	public void setType(Integer type) {
		this.type = type;
	}

}
