package vn.com.hiringviet.dao;

import java.util.List;

import vn.com.hiringviet.dto.CompanyDTO;
import vn.com.hiringviet.dto.PostDTO;
import vn.com.hiringviet.model.Account;
import vn.com.hiringviet.model.Company;
import vn.com.hiringviet.model.Job;

// TODO: Auto-generated Javadoc
/**
 * The Interface CompanyDAO.
 */
public interface CompanyDAO extends CommonDAO<Company> {

	/**
	 * Gets the list company hot.
	 *
	 * @param first the first
	 * @param max the max
	 * @return the list company hot
	 */
	public List<Company> getListCompanyHot(Integer first, Integer max);

	/**
	 * Gets the list company suggest.
	 *
	 * @param first the first
	 * @param max the max
	 * @return the list company suggest
	 */
	public List<Company> getListCompanySuggest(Integer first, Integer max);

	/**
	 * Gets the list posts.
	 *
	 * @param first the first
	 * @param max the max
	 * @param companyId the company id
	 * @return the list posts
	 */
	public List<PostDTO> getListPosts(Integer first, Integer max, Integer companyId);

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
	 * Gets the list company follow.
	 *
	 * @param accountId the account id
	 * @return the list company follow
	 */
	public List<CompanyDTO> getListCompanyFollow(Integer accountId);
}
