package vn.com.hiringviet.dto;

import java.io.Serializable;

import vn.com.hiringviet.model.ChangeLog;

public class PostDTO implements Serializable {

	private static final long serialVersionUID = 8245796804159877529L;

	private Integer id;

	private String title;

	private String description;

	private ChangeLog changeLog;

	private Long numberComment;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public ChangeLog getChangeLog() {
		return changeLog;
	}

	public void setChangeLog(ChangeLog changeLog) {
		this.changeLog = changeLog;
	}

	public Long getNumberComment() {
		return numberComment;
	}

	public void setNumberComment(Long numberComment) {
		this.numberComment = numberComment;
	}

}
