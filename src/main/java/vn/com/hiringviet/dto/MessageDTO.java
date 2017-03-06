package vn.com.hiringviet.dto;

import java.io.Serializable;

// TODO: Auto-generated Javadoc
/**
 * The Class MessageDTO.
 */
public class MessageDTO implements Serializable {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = -2453408643751260977L;

	/** The id. */
	private Integer id;

	/** The email sender. */
	private String emailSender;
	
	/** The email receiver. */
	private String emailReceiver;

	/** The type mail. */
	private Integer typeMail;

	/** The title. */
	private String title;
	
	/** The content. */
	private String content;

	/** The date time. */
	private String dateTime;
	
	/** The job id. */
	private int jobId;
	
	/** The apply id. */
	private int applyId;
	
	/** The company id. */
	private int companyId;

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
	 * Gets the type mail.
	 *
	 * @return the type mail
	 */
	public Integer getTypeMail() {
		return typeMail;
	}

	/**
	 * Sets the type mail.
	 *
	 * @param typeMail the new type mail
	 */
	public void setTypeMail(Integer typeMail) {
		this.typeMail = typeMail;
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
	 * Gets the content.
	 *
	 * @return the content
	 */
	public String getContent() {
		return content;
	}

	/**
	 * Sets the content.
	 *
	 * @param content the new content
	 */
	public void setContent(String content) {
		this.content = content;
	}

	/**
	 * Gets the date time.
	 *
	 * @return the date time
	 */
	public String getDateTime() {
		return dateTime;
	}

	/**
	 * Sets the date time.
	 *
	 * @param dateTime the new date time
	 */
	public void setDateTime(String dateTime) {
		this.dateTime = dateTime;
	}

	/**
	 * Gets the email sender.
	 *
	 * @return the email sender
	 */
	public String getEmailSender() {
		return emailSender;
	}

	/**
	 * Sets the email sender.
	 *
	 * @param emailSender the new email sender
	 */
	public void setEmailSender(String emailSender) {
		this.emailSender = emailSender;
	}

	/**
	 * Gets the email receiver.
	 *
	 * @return the email receiver
	 */
	public String getEmailReceiver() {
		return emailReceiver;
	}

	/**
	 * Sets the email receiver.
	 *
	 * @param emailReceiver the new email receiver
	 */
	public void setEmailReceiver(String emailReceiver) {
		this.emailReceiver = emailReceiver;
	}

	/**
	 * Gets the apply id.
	 *
	 * @return the apply id
	 */
	public int getApplyId() {
		return applyId;
	}

	/**
	 * Sets the apply id.
	 *
	 * @param applyId the new apply id
	 */
	public void setApplyId(int applyId) {
		this.applyId = applyId;
	}

	/**
	 * Gets the job id.
	 *
	 * @return the job id
	 */
	public int getJobId() {
		return jobId;
	}

	/**
	 * Sets the job id.
	 *
	 * @param jobId the new job id
	 */
	public void setJobId(int jobId) {
		this.jobId = jobId;
	}

	/**
	 * Gets the company id.
	 *
	 * @return the company id
	 */
	public int getCompanyId() {
		return companyId;
	}

	/**
	 * Sets the company id.
	 *
	 * @param companyId the new company id
	 */
	public void setCompanyId(int companyId) {
		this.companyId = companyId;
	}
}
