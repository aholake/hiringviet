package vn.com.hiringviet.dao;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import vn.com.hiringviet.dto.ResumeDTO;
import vn.com.hiringviet.model.Resume;

@Repository
@Transactional
public interface ResumeDAO extends CommonDAO<Resume> {

	public List<Integer> getListSkillByMemberId(Integer memberId);

//	public boolean deleteSkillOfProfile(ResumeDTO resumeDTO);
}
