package vn.com.hiringviet.service;

import org.springframework.stereotype.Service;

import vn.com.hiringviet.model.SkillResume;

// TODO: Auto-generated Javadoc
/**
 * The Interface SkillResumeService.
 */
@Service("skillResumeService")
public interface SkillResumeService {

	/**
	 * Gets the skill resume.
	 *
	 * @param skillResumeId the skill resume id
	 * @return the skill resume
	 */
	public SkillResume getSkillResume(Integer skillResumeId);
}
