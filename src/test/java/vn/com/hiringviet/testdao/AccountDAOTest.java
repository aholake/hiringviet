package vn.com.hiringviet.testdao;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.util.Date;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import vn.com.hiringviet.dao.AccountDAO;
import vn.com.hiringviet.model.Account;
import vn.com.hiringviet.model.Company;
import vn.com.hiringviet.model.Member;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:servlet-context.xml" })
@Transactional
public class AccountDAOTest {
	@Autowired
	private AccountDAO accountDAO;

	private Account account;

	private Account account2;

	@Before
	public void setUp() {
		Member member = new Member();
		member.setLastName("fdsafasF");
		member.setBirthDate(new Date());
		member.setFirstName("fsafsafs");
		account = new Account();
		account.setMember(member);
		account.setEmail("tinhtinh@gmail.com");
		member.setAccount(account);

		Company company = new Company();
		company.setDisplayName("Hahaha");

		account2 = new Account();
		account2.setCompany(company);

	}

	@Test
	@Rollback
	public void should_save_a_account_success() throws Exception {
		int id = accountDAO.create(account);
		assertTrue(id > 0);
	}

	@Test
	@Rollback
	public void should_return_null_by_invalid_email() throws Exception {
		assertNull(accountDAO.getAccountByEmail("nluit.tanloc@gmail.comAbc"));
	}

	@Test
	@Rollback
	public void should_return_email_by_valid_email() throws Exception {
		String email = "loc.vo@axonactive.com";
		assertEquals(email,
				accountDAO.getAccountByEmail("loc.vo@axonactive.com")
						.getEmail());
	}

	@Test
	@Rollback
	public void should_delete_a_account_success() throws Exception {
		int id = accountDAO.create(account);
		Account account = accountDAO.findOne(id);
		accountDAO.delete(account);
	}

	@Test
	@Rollback(false)
	public void should_delete_a_account_of_company_success() throws Exception {
		Account account = accountDAO.findOne(2);
		System.out.println(account.getEmail());
		accountDAO.delete(account);
	}

}
