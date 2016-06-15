package vn.com.hiringviet.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import vn.com.hiringviet.dao.ResumeDAO;
import vn.com.hiringviet.service.ResumeService;

@Service("resumeService")
public class ResumeServiceImpl implements ResumeService {

	@Autowired
	private ResumeDAO resumeDAO;

	@Override
	public List<Integer> getListSkillByMemberId(Integer memberId) {

		return resumeDAO.getListSkillByMemberId(memberId);
	}

}
