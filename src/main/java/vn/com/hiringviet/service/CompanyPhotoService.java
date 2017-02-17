package vn.com.hiringviet.service;

import org.springframework.stereotype.Service;

import vn.com.hiringviet.model.CompanyPhoto;

@Service("companyPhotoService")
public interface CompanyPhotoService {

	public boolean createPhotoBanner(Integer companyId, CompanyPhoto companyPhoto);

	public boolean deletePhotoBanner(Integer id);
}
