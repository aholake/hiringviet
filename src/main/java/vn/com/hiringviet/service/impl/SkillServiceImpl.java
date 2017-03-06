package vn.com.hiringviet.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import vn.com.hiringviet.dao.SkillDAO;
import vn.com.hiringviet.dto.SkillDTO;
import vn.com.hiringviet.model.Skill;
import vn.com.hiringviet.service.SkillService;

// TODO: Auto-generated Javadoc
/**
 * The Class SkillServiceImpl.
 */
@Service("skillService")
public class SkillServiceImpl implements SkillService {

	/** The skill dao. */
	@Autowired
	private SkillDAO skillDAO;

	/* (non-Javadoc)
	 * @see vn.com.hiringviet.service.SkillService#getSkillById(int)
	 */
	@Override
	public Skill getSkillById(int id) {
		// TODO Auto-generated method stub
		return skillDAO.findOne(id);
	}

	/* (non-Javadoc)
	 * @see vn.com.hiringviet.service.SkillService#getSkillList()
	 */
	@Override
	public List<Skill> getSkillList() {
		// TODO Auto-generated method stub
		return skillDAO.findAll();
	}

	/* (non-Javadoc)
	 * @see vn.com.hiringviet.service.SkillService#addSkill(vn.com.hiringviet.model.Skill)
	 */
	@Override
	public int addSkill(Skill skill) {
		// TODO Auto-generated method stub
		return skillDAO.create(skill);
	}

	/* (non-Javadoc)
	 * @see vn.com.hiringviet.service.SkillService#deleteSkillById(int)
	 */
	@Override
	public boolean deleteSkillById(int id) {
		// TODO Auto-generated method stub
		return skillDAO.deleteById(id);
	}

	/* (non-Javadoc)
	 * @see vn.com.hiringviet.service.SkillService#deleteSkill(vn.com.hiringviet.model.Skill)
	 */
	@Override
	public boolean deleteSkill(Skill skill) {
		// TODO Auto-generated method stub
		return skillDAO.delete(skill);
	}

	/* (non-Javadoc)
	 * @see vn.com.hiringviet.service.SkillService#updateSkill(vn.com.hiringviet.model.Skill)
	 */
	@Override
	public boolean updateSkill(Skill skill) {
		// TODO Auto-generated method stub
		return skillDAO.update(skill);
	}

	/* (non-Javadoc)
	 * @see vn.com.hiringviet.service.SkillService#searchSkillByKeyWord(java.lang.String)
	 */
	@Override
	public List<SkillDTO> searchSkillByKeyWord(String keyWord) {
		// TODO Auto-generated method stub
		return skillDAO.searchSkillByKeyWord(keyWord);
	}

}
