package vn.com.hiringviet.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import vn.com.hiringviet.dao.CompanyPhotoDAO;
import vn.com.hiringviet.model.CompanyPhoto;
import vn.com.hiringviet.service.CompanyPhotoService;

// TODO: Auto-generated Javadoc
/**
 * The Class CompanyPhotoServiceImpl.
 */
@Service("companyPhotoService")
public class CompanyPhotoServiceImpl implements CompanyPhotoService {

	/** The company photo dao. */
	@Autowired
	private CompanyPhotoDAO companyPhotoDAO;

	/* (non-Javadoc)
	 * @see vn.com.hiringviet.service.CompanyPhotoService#createPhotoBanner(java.lang.Integer, vn.com.hiringviet.model.CompanyPhoto)
	 */
	@Override
	public boolean createPhotoBanner(Integer companyId, CompanyPhoto companyPhoto) {

		return companyPhotoDAO.createPhotoBanner(companyId, companyPhoto);
	}

	/* (non-Javadoc)
	 * @see vn.com.hiringviet.service.CompanyPhotoService#deletePhotoBanner(java.lang.Integer)
	 */
	@Override
	public boolean deletePhotoBanner(Integer id) {
		// TODO Auto-generated method stub
		return companyPhotoDAO.deletePhotoBanner(id);
	}

}
