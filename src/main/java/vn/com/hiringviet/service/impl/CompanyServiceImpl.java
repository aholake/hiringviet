package vn.com.hiringviet.service.impl;

import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import vn.com.hiringviet.common.AccountRoleEnum;
import vn.com.hiringviet.common.StatusEnum;
import vn.com.hiringviet.constant.ConstantValues;
import vn.com.hiringviet.converter.CompanyConverter;
import vn.com.hiringviet.dao.CompanyDAO;
import vn.com.hiringviet.dao.PostDAO;
import vn.com.hiringviet.dto.CompanyAdminTableDTO;
import vn.com.hiringviet.dto.CompanyDTO;
import vn.com.hiringviet.dto.PostDTO;
import vn.com.hiringviet.model.Account;
import vn.com.hiringviet.model.ChangeLog;
import vn.com.hiringviet.model.Company;
import vn.com.hiringviet.model.Job;
import vn.com.hiringviet.model.Post;
import vn.com.hiringviet.service.AccountService;
import vn.com.hiringviet.service.AddressService;
import vn.com.hiringviet.service.CompanyService;
import vn.com.hiringviet.service.MailService;
import vn.com.hiringviet.util.FileUtil;
import vn.com.hiringviet.util.SecurityUtil;
import vn.com.hiringviet.util.TextGenerator;
import vn.com.hiringviet.util.Utils;

@Service("companyService")
@Transactional
public class CompanyServiceImpl implements CompanyService {
	private static final Logger LOGGER = Logger
			.getLogger(CompanyServiceImpl.class);

	@Autowired
	private CompanyDAO companyDAO;

	@Autowired
	private AccountService accountService;

	@Autowired
	private MailService mailService;

	@Autowired
	private AddressService addressService;

	private Properties configProperties = FileUtil.getConfigProperties();

	@Autowired
	private PostDAO postDAO;

	@Override
	public int addCompany(Company company) {
		String encryptPassword = SecurityUtil.encodeStringToBase64(company
				.getAccount().getPassword());
		company.getAccount().setPassword(encryptPassword);
		ChangeLog changeLog = Utils.createDefaultChangeLog();
		company.setChangeLog(changeLog);

		company.getAccount().setUserRole(AccountRoleEnum.COMPANY);
		company.getAccount().setLocale(ConstantValues.VN_LOCALE);
		company.getAccount().setActiveUrl(
				TextGenerator.generateRandomString(11));

		company.setAddress(addressService.getFullAddressBaseOnId(company
				.getAddress()));

		company.getAccount().setStatus(StatusEnum.INACTIVE);
		int companyId = companyDAO.create(company);
		if (companyId > 0) {
			final Account account = getCompanyById(companyId).getAccount();
			sendActiveAccountEmail(account);
			accountService.trackAccountAfterRegister(account);
		}
		LOGGER.info("insert company successfully");
		return companyId;
	}

	private void sendActiveAccountEmail(Account account) {
		String randomString = account.getId()
				+ TextGenerator
						.generateRandomString(TextGenerator.RANDOM_ACTIVE_STRING_LENGTH);

		// Send email active account
		String activeUrl = MessageFormat
				.format(configProperties.getProperty("url.activeAccount"),
						randomString);

		LOGGER.info("active code: " + activeUrl);
		 mailService.sendMail(account.getEmail(), "active account",
		 activeUrl);
	}

	@Override
	public boolean deleteCompany(int id) {
		Company company = companyDAO.findOne(id);
		if (company != null) {
			return companyDAO.delete(company);
		}
		return false;
	}

	@Override
	public boolean updateCompany(Company company) {

		return companyDAO.update(company);
	}

	@Override
	public List<Company> getCompanyList() {

		return companyDAO.findAll();
	}

	@Override
	public List<Company> getListCompany(Integer first, Integer max,
			boolean isCompanyHot) {

		if (isCompanyHot) {
			return companyDAO.getListCompanyHot(first, max);
		} else {
			return companyDAO.getListCompanySuggest(first, max);
		}
	}

	@Override
	public List<PostDTO> getListPosts(Integer first, Integer max,
			Integer companyId) {

		return companyDAO.getListPosts(first, max, companyId);
	}

	@Override
	public List<Job> getListJob(Integer first, Integer max, Integer companyId, boolean getAll) {
		return companyDAO.getListJob(first, max, companyId, getAll);
	}

	@Override
	public Company getCompanyByAccount(Account account) {
		return companyDAO.getCompanyByAccount(account);
	}

	@Override
	public List<CompanyDTO> getListCompanySuggest(String keywork) {
		return companyDAO.getListCompanySuggest(keywork);
	}

	@Override
	public Company getCompanyById(int id) {
		return companyDAO.findOne(id);
	}

	@Override
	public boolean addPosts(PostDTO postDTO, Company company) {
		
		Post post = new Post();
		post.setTitle(postDTO.getTitle());
		post.setDescription(postDTO.getDescription());
		post.setCompany(company);
		post.setChangeLog(Utils.generatorChangeLog());

		if (postDAO.create(post) > 0) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	public List<CompanyAdminTableDTO> getAllCompaniesForAdminTable() {
		List<Company> companies = companyDAO.findAll();
		List<CompanyAdminTableDTO> companyAdminTableDTOs = new ArrayList<CompanyAdminTableDTO>();

		for (Company company : companies) {
			companyAdminTableDTOs.add(CompanyConverter
					.convertToCompanyAdminTableDTO(company));
		}

		return companyAdminTableDTOs;

	}

	@Override
	public List<CompanyDTO> getListCompanyFollow(Integer accountId) {
		return companyDAO.getListCompanyFollow(accountId);
	}

}
