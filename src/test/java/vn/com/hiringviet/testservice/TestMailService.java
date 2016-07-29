package vn.com.hiringviet.testservice;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import vn.com.hiringviet.service.MailService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:servlet-context.xml",
		"classpath:spring-security.xml", "classpath:spring-mail.xml" })
public class TestMailService {
	@Autowired
	private MailService mailService;
	
	@Test
	public void should_send_mail_successful() throws Exception {
		mailService.sendMail("nluit.tanloc@gmail.com", "This is email for testing", "This is email for testing");
	}
}
