package vn.com.hiringviet.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import vn.com.hiringviet.dao.SkillDAO;
import vn.com.hiringviet.dto.SkillDTO;
import vn.com.hiringviet.model.Skill;
import vn.com.hiringviet.service.SkillService;

@Service("skillService")
public class SkillServiceImpl implements SkillService {

	@Autowired
	private SkillDAO skillDAO;

	@Override
	public Skill getSkillById(int id) {
		// TODO Auto-generated method stub
		return skillDAO.findOne(id);
	}

	@Override
	public List<Skill> getSkillList() {
		// TODO Auto-generated method stub
		return skillDAO.findAll();
	}

	@Override
	public int addSkill(Skill skill) {
		// TODO Auto-generated method stub
		return skillDAO.create(skill);
	}

	@Override
	public boolean deleteSkillById(int id) {
		// TODO Auto-generated method stub
		return skillDAO.deleteById(id);
	}

	@Override
	public boolean deleteSkill(Skill skill) {
		// TODO Auto-generated method stub
		return skillDAO.delete(skill);
	}

	@Override
	public boolean updateSkill(Skill skill) {
		// TODO Auto-generated method stub
		return skillDAO.update(skill);
	}

	@Override
	public List<SkillDTO> searchSkillByKeyWord(String keyWord) {
		// TODO Auto-generated method stub
		return skillDAO.searchSkillByKeyWord(keyWord);
	}

}
