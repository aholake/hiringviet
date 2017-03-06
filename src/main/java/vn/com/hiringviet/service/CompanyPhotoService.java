package vn.com.hiringviet.service;

import org.springframework.stereotype.Service;

import vn.com.hiringviet.model.CompanyPhoto;

// TODO: Auto-generated Javadoc
/**
 * The Interface CompanyPhotoService.
 */
@Service("companyPhotoService")
public interface CompanyPhotoService {

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
