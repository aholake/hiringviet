package vn.com.hiringviet.service;

import java.util.List;

import org.springframework.stereotype.Service;

import vn.com.hiringviet.dto.SkillDTO;
import vn.com.hiringviet.model.Skill;

@Service("skillService")
public interface SkillService {
	public Skill getSkillById(int id);
	
	public List<Skill> getSkillList();
	
	public int addSkill(Skill skill);
	
	public boolean deleteSkillById(int id);
	
	public boolean deleteSkill(Skill skill);
	
	public boolean updateSkill(Skill skill);

	public List<SkillDTO> searchSkillByKeyWord(String keyWord);
}
