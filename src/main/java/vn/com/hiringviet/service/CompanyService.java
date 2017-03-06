package vn.com.hiringviet.service;

import java.util.List;

import vn.com.hiringviet.dto.CompanyAdminTableDTO;
import vn.com.hiringviet.dto.CompanyDTO;
import vn.com.hiringviet.dto.PostDTO;
import vn.com.hiringviet.model.Account;
import vn.com.hiringviet.model.Company;
import vn.com.hiringviet.model.Job;

// TODO: Auto-generated Javadoc
/**
 * The Interface CompanyService.
 */
public interface CompanyService {

	/**
	 * Adds the company.
	 *
	 * @param company the company
	 * @return the int
	 */
	int addCompany(Company company);

	/**
	 * Delete company.
	 *
	 * @param id the id
	 * @return true, if successful
	 */
	boolean deleteCompany(int id);

	/**
	 * Update company.
	 *
	 * @param company the company
	 * @return true, if successful
	 */
	boolean updateCompany(Company company);

	/**
	 * Gets the company list.
	 *
	 * @return the company list
	 */
	public List<Company> getCompanyList();

	/**
	 * Gets the list company.
	 *
	 * @param first the first
	 * @param max the max
	 * @param isCompanyHot the is company hot
	 * @return the list company
	 */
	public List<Company> getListCompany(Integer first, Integer max,
			boolean isCompanyHot);

	/**
	 * Gets the company by id.
	 *
	 * @param id the id
	 * @return the company by id
	 */
	public Company getCompanyById(int id);

	/**
	 * Gets the list posts.
	 *
	 * @param first the first
	 * @param max the max
	 * @param companyId the company id
	 * @return the list posts
	 */
	public List<PostDTO> getListPosts(Integer first, Integer max,
			Integer companyId);

	/**
	 * Gets the list job.
	 *
	 * @param first the first
	 * @param max the max
	 * @param companyId the company id
	 * @param getAll the get all
	 * @return the list job
	 */
	public List<Job> getListJob(Integer first, Integer max, Integer companyId, boolean getAll);

	/**
	 * Gets the company by account.
	 *
	 * @param account the account
	 * @return the company by account
	 */
	public Company getCompanyByAccount(Account account);

	/**
	 * Gets the list company suggest.
	 *
	 * @param keywork the keywork
	 * @return the list company suggest
	 */
	public List<CompanyDTO> getListCompanySuggest(String keywork);


	/**
	 * Adds the posts.
	 *
	 * @param postDTO the post dto
	 * @param company the company
	 * @return true, if successful
	 */
	public boolean addPosts(PostDTO postDTO, Company company);

	/**
	 * Gets the all companies for admin table.
	 *
	 * @return the all companies for admin table
	 */
	public List<CompanyAdminTableDTO> getAllCompaniesForAdminTable();

	/**
	 * Gets the list company follow.
	 *
	 * @param accountId the account id
	 * @return the list company follow
	 */
	public List<CompanyDTO> getListCompanyFollow(Integer accountId);

}
