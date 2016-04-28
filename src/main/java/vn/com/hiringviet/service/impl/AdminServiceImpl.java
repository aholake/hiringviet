package vn.com.hiringviet.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import vn.com.hiringviet.dao.AdminDAO;
import vn.com.hiringviet.service.AdminService;

@Service("adminService")
public class AdminServiceImpl implements AdminService {

	@Autowired
	private AdminDAO adminDAO;
}
