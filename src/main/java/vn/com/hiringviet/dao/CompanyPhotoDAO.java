package vn.com.hiringviet.dao;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import vn.com.hiringviet.model.CompanyPhoto;

@Repository
@Transactional
public interface CompanyPhotoDAO extends CommonDAO<CompanyPhoto> {

	public boolean createPhotoBanner(Integer companyId, CompanyPhoto companyPhoto);

	public boolean deletePhotoBanner(Integer id);
}
