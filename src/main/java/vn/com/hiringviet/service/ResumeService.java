package vn.com.hiringviet.service;

import java.util.List;

import org.springframework.stereotype.Service;

@Service("resumeService")
public interface ResumeService {

	public List<Integer> getListSkillByMemberId(Integer memberId);
}
