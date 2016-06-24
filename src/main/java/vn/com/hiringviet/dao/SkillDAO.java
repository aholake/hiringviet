package vn.com.hiringviet.dao;

import java.util.List;

import vn.com.hiringviet.dto.SkillDTO;
import vn.com.hiringviet.model.Skill;

public interface SkillDAO extends CommonDAO<Skill> {

	public List<SkillDTO> searchSkillByKeyWord(String keyWord);
}
