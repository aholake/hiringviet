package vn.com.hiringviet.service;

import org.springframework.stereotype.Service;

import vn.com.hiringviet.model.SkillResume;

@Service("skillResumeService")
public interface SkillResumeService {

	public SkillResume getSkillResume(Integer skillResumeId);
}
