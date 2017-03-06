package vn.com.hiringviet.dto;

import java.io.Serializable;

import vn.com.hiringviet.model.ChangeLog;

// TODO: Auto-generated Javadoc
/**
 * The Class PostDTO.
 */
public class PostDTO implements Serializable {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 8245796804159877529L;

	/** The id. */
	private Integer id;

	/** The title. */
	private String title;

	/** The description. */
	private String description;

	/** The change log. */
	private ChangeLog changeLog;

	/** The number comment. */
	private Long numberComment;

	/**
	 * Gets the id.
	 *
	 * @return the id
	 */
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
	 * Gets the title.
	 *
	 * @return the title
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * Sets the title.
	 *
	 * @param title the new title
	 */
	public void setTitle(String title) {
		this.title = title;
	}

	/**
	 * Gets the description.
	 *
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * Sets the description.
	 *
	 * @param description the new description
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * Gets the change log.
	 *
	 * @return the change log
	 */
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

	/**
	 * Gets the number comment.
	 *
	 * @return the number comment
	 */
	public Long getNumberComment() {
		return numberComment;
	}

	/**
	 * Sets the number comment.
	 *
	 * @param numberComment the new number comment
	 */
	public void setNumberComment(Long numberComment) {
		this.numberComment = numberComment;
	}

}
