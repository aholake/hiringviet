package vn.com.hiringviet.service.impl;

import org.springframework.stereotype.Service;

import vn.com.hiringviet.dao.SkillResumeDAO;
import vn.com.hiringviet.model.SkillResume;
import vn.com.hiringviet.service.SkillResumeService;

// TODO: Auto-generated Javadoc
/**
 * The Class SkillResumeServiceImpl.
 */
@Service("skillResumeService")
public class SkillResumeServiceImpl implements SkillResumeService {

	/** The skill resume dao. */
	private SkillResumeDAO skillResumeDAO;
	
	/* (non-Javadoc)
	 * @see vn.com.hiringviet.service.SkillResumeService#getSkillResume(java.lang.Integer)
	 */
	@Override
	public SkillResume getSkillResume(Integer skillResumeId) {

		return skillResumeDAO.findOne(skillResumeId);
	}

}
