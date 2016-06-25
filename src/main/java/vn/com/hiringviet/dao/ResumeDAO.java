package vn.com.hiringviet.dao;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import vn.com.hiringviet.dto.ResumeDTO;

@Repository
@Transactional
public interface ResumeDAO {

	public List<Integer> getListSkillByMemberId(Integer memberId);

	public boolean deleteSkillOfProfile(ResumeDTO resumeDTO);
}
