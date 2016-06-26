package vn.com.hiringviet.service.impl;

import org.springframework.stereotype.Service;

import vn.com.hiringviet.dao.SkillResumeDAO;
import vn.com.hiringviet.model.SkillResume;
import vn.com.hiringviet.service.SkillResumeService;

@Service("skillResumeService")
public class SkillResumeServiceImpl implements SkillResumeService {

	private SkillResumeDAO skillResumeDAO;
	@Override
	public SkillResume getSkillResume(Integer skillResumeId) {

		return skillResumeDAO.findOne(skillResumeId);
	}

}
