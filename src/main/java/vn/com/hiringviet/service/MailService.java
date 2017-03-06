package vn.com.hiringviet.service;

// TODO: Auto-generated Javadoc
/**
 * The Interface MailService.
 */
public interface MailService {
	
	/**
	 * Send mail.
	 *
	 * @param to the to
	 * @param subject the subject
	 * @param msg the msg
	 */
	public void sendMail(String to, String subject, String msg);
}
