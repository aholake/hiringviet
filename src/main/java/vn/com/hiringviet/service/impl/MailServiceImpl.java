package vn.com.hiringviet.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import vn.com.hiringviet.constant.ConstantValues;
import vn.com.hiringviet.service.MailService;

@Service
public class MailServiceImpl implements MailService {
	@Autowired
	private JavaMailSender mailSender;

	@Override
	public void sendMail(String to, String subject, String msg) {
		SimpleMailMessage message = new SimpleMailMessage();

		message.setFrom(ConstantValues.CONFIG_PROPS
				.getProperty("mail.username"));
		message.setTo(to);
		message.setSubject(subject);
		message.setText(msg);
		mailSender.send(message);
	}

}
