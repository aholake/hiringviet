package vn.com.hiringviet.dao;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import vn.com.hiringviet.model.CompanyPhoto;

// TODO: Auto-generated Javadoc
/**
 * The Interface CompanyPhotoDAO.
 */
@Repository
@Transactional
public interface CompanyPhotoDAO extends CommonDAO<CompanyPhoto> {

	/**
	 * Creates the photo banner.
	 *
	 * @param companyId the company id
	 * @param companyPhoto the company photo
	 * @return true, if successful
	 */
	public boolean createPhotoBanner(Integer companyId, CompanyPhoto companyPhoto);

	/**
	 * Delete photo banner.
	 *
	 * @param id the id
	 * @return true, if successful
	 */
	public boolean deletePhotoBanner(Integer id);
}
