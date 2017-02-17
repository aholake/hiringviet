package vn.com.hiringviet.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import vn.com.hiringviet.dao.CompanyPhotoDAO;
import vn.com.hiringviet.model.CompanyPhoto;
import vn.com.hiringviet.service.CompanyPhotoService;

@Service("companyPhotoService")
public class CompanyPhotoServiceImpl implements CompanyPhotoService {

	@Autowired
	private CompanyPhotoDAO companyPhotoDAO;

	@Override
	public boolean createPhotoBanner(Integer companyId, CompanyPhoto companyPhoto) {

		return companyPhotoDAO.createPhotoBanner(companyId, companyPhoto);
	}

	@Override
	public boolean deletePhotoBanner(Integer id) {
		// TODO Auto-generated method stub
		return companyPhotoDAO.deletePhotoBanner(id);
	}

}
