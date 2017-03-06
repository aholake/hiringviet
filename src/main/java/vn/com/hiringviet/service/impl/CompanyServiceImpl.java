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

// TODO: Auto-generated Javadoc
/**
 * The Class CompanyServiceImpl.
 */
@Service("companyService")
@Transactional
public class CompanyServiceImpl implements CompanyService {
	
	/** The Constant LOGGER. */
	private static final Logger LOGGER = Logger
			.getLogger(CompanyServiceImpl.class);

	/** The company dao. */
	@Autowired
	private CompanyDAO companyDAO;

	/** The account service. */
	@Autowired
	private AccountService accountService;

	/** The mail service. */
	@Autowired
	private MailService mailService;

	/** The address service. */
	@Autowired
	private AddressService addressService;

	/** The config properties. */
	private Properties configProperties = FileUtil.getConfigProperties();

	/** The post dao. */
	@Autowired
	private PostDAO postDAO;

	/* (non-Javadoc)
	 * @see vn.com.hiringviet.service.CompanyService#addCompany(vn.com.hiringviet.model.Company)
	 */
	@Override
	public int addCompany(Company company) {
		String encryptPassword = SecurityUtil.encodeStringToBase64(company
				.getAccount().getPassword());
		company.getAccount().setPassword(encryptPassword);
		ChangeLog changeLog = Utils.createDefaultChangeLog();
		company.setChangeLog(changeLog);

		company.getAccount().setUserRole(AccountRoleEnum.COMPANY);
		company.getAccount().setLocale(ConstantValues.VN_LOCALE);
		
		String activeCode = TextGenerator.generateRandomString(TextGenerator.RANDOM_ACTIVE_STRING_LENGTH);
		company.getAccount().setActiveUrl(activeCode);

		company.setAddress(addressService.getFullAddressBaseOnId(company
				.getAddress()));

		company.getAccount().setStatus(StatusEnum.INACTIVE);
		int companyId = companyDAO.create(company);
		if (companyId > 0) {
			final Account account = getCompanyById(companyId).getAccount();
			sendActiveAccountEmail(company.getDisplayName(), account.getEmail(), account.getActiveUrl());
			accountService.trackAccountAfterRegister(account);
		}
		LOGGER.info("insert company successfully");
		return companyId;
	}

	/**
	 * Send active account email.
	 *
	 * @param name the name
	 * @param email the email
	 * @param activeCode the active code
	 */
	private void sendActiveAccountEmail(String name, String email,
			String activeCode) {
		// Send email active account
		String activeUrl = MessageFormat.format(
				configProperties.getProperty("email.activeAccount"), name,
				activeCode);

		LOGGER.info("active code: " + activeUrl);
		mailService.sendMail(email,
				"HiringViet - Active company account registration", activeUrl);
	}

	/* (non-Javadoc)
	 * @see vn.com.hiringviet.service.CompanyService#deleteCompany(int)
	 */
	@Override
	public boolean deleteCompany(int id) {
		Company company = companyDAO.findOne(id);
		if (company != null) {
			return companyDAO.delete(company);
		}
		return false;
	}

	/* (non-Javadoc)
	 * @see vn.com.hiringviet.service.CompanyService#updateCompany(vn.com.hiringviet.model.Company)
	 */
	@Override
	public boolean updateCompany(Company company) {

		return companyDAO.update(company);
	}

	/* (non-Javadoc)
	 * @see vn.com.hiringviet.service.CompanyService#getCompanyList()
	 */
	@Override
	public List<Company> getCompanyList() {

		return companyDAO.findAll();
	}

	/* (non-Javadoc)
	 * @see vn.com.hiringviet.service.CompanyService#getListCompany(java.lang.Integer, java.lang.Integer, boolean)
	 */
	@Override
	public List<Company> getListCompany(Integer first, Integer max,
			boolean isCompanyHot) {

		if (isCompanyHot) {
			return companyDAO.getListCompanyHot(first, max);
		} else {
			return companyDAO.getListCompanySuggest(first, max);
		}
	}

	/* (non-Javadoc)
	 * @see vn.com.hiringviet.service.CompanyService#getListPosts(java.lang.Integer, java.lang.Integer, java.lang.Integer)
	 */
	@Override
	public List<PostDTO> getListPosts(Integer first, Integer max,
			Integer companyId) {

		return companyDAO.getListPosts(first, max, companyId);
	}

	/* (non-Javadoc)
	 * @see vn.com.hiringviet.service.CompanyService#getListJob(java.lang.Integer, java.lang.Integer, java.lang.Integer, boolean)
	 */
	@Override
	public List<Job> getListJob(Integer first, Integer max, Integer companyId, boolean getAll) {
		return companyDAO.getListJob(first, max, companyId, getAll);
	}

	/* (non-Javadoc)
	 * @see vn.com.hiringviet.service.CompanyService#getCompanyByAccount(vn.com.hiringviet.model.Account)
	 */
	@Override
	public Company getCompanyByAccount(Account account) {
		return companyDAO.getCompanyByAccount(account);
	}

	/* (non-Javadoc)
	 * @see vn.com.hiringviet.service.CompanyService#getListCompanySuggest(java.lang.String)
	 */
	@Override
	public List<CompanyDTO> getListCompanySuggest(String keywork) {
		return companyDAO.getListCompanySuggest(keywork);
	}

	/* (non-Javadoc)
	 * @see vn.com.hiringviet.service.CompanyService#getCompanyById(int)
	 */
	@Override
	public Company getCompanyById(int id) {
		return companyDAO.findOne(id);
	}

	/* (non-Javadoc)
	 * @see vn.com.hiringviet.service.CompanyService#addPosts(vn.com.hiringviet.dto.PostDTO, vn.com.hiringviet.model.Company)
	 */
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

	/* (non-Javadoc)
	 * @see vn.com.hiringviet.service.CompanyService#getAllCompaniesForAdminTable()
	 */
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

	/* (non-Javadoc)
	 * @see vn.com.hiringviet.service.CompanyService#getListCompanyFollow(java.lang.Integer)
	 */
	@Override
	public List<CompanyDTO> getListCompanyFollow(Integer accountId) {
		return companyDAO.getListCompanyFollow(accountId);
	}

}
