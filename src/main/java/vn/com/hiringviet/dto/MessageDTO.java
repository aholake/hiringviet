package vn.com.hiringviet.dto;

import java.io.Serializable;

public class MessageDTO implements Serializable {

	private static final long serialVersionUID = -2453408643751260977L;

	private Integer id;

	private String emailSender;

	private Integer typeMail;

	private String title;

	private String content;

	private String dateTime;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getTypeMail() {
		return typeMail;
	}

	public void setTypeMail(Integer typeMail) {
		this.typeMail = typeMail;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getDateTime() {
		return dateTime;
	}

	public void setDateTime(String dateTime) {
		this.dateTime = dateTime;
	}

	public String getEmailSender() {
		return emailSender;
	}

	public void setEmailSender(String emailSender) {
		this.emailSender = emailSender;
	}

}
