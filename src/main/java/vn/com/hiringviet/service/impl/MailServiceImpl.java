package vn.com.hiringviet.service.impl;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import vn.com.hiringviet.constant.ConstantValues;
import vn.com.hiringviet.service.MailService;

// TODO: Auto-generated Javadoc
/**
 * The Class MailServiceImpl.
 */
@Service
public class MailServiceImpl implements MailService {
	
	/** The mail sender. */
	@Autowired
	private JavaMailSender mailSender;

	/* (non-Javadoc)
	 * @see vn.com.hiringviet.service.MailService#sendMail(java.lang.String, java.lang.String, java.lang.String)
	 */
	@Override
	public void sendMail(String to, String subject, String msg){
		MimeMessage mimeMessage = mailSender.createMimeMessage();
		MimeMessageHelper helper;
		try {
			helper = new MimeMessageHelper(mimeMessage, false,
					"utf-8");
			mimeMessage.setContent(msg, "text/html");
			helper.setTo(to);
			helper.setSubject(subject);
			helper.setFrom(ConstantValues.CONFIG_PROPS.getProperty("mail.username"));
			mailSender.send(mimeMessage);
		} catch (MessagingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
