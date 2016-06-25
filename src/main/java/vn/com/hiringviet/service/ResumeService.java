package vn.com.hiringviet.service;

import java.util.List;

import org.springframework.stereotype.Service;

import vn.com.hiringviet.dto.ResumeDTO;

@Service("resumeService")
public interface ResumeService {

	public List<Integer> getListSkillByMemberId(Integer memberId);

	public boolean deleteSkillOfProfile(ResumeDTO resumeDTO);
}
