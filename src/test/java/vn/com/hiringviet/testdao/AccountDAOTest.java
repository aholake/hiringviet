package vn.com.hiringviet.testdao;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import vn.com.hiringviet.dao.AccountDAO;
import vn.com.hiringviet.model.Account;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:servlet-context.xml","classpath:spring-security.xml", "classpath:spring-mail.xml"})
public class AccountDAOTest {
	@Autowired
	private AccountDAO accountDAO;
	
	@Test
	public void should_return_null_by_invalid_email() throws Exception {
		assertEquals(null, accountDAO.getAccountByEmail("nluit.tanloc@gmail.com"));
	}
	
	@Test
	public void should_return_email_by_valid_email() throws Exception {
		String email = "loc.vo@axonactive.com";
		assertEquals(email, accountDAO.getAccountByEmail("loc.vo@axonactive.com").getEmail());
	}
}
