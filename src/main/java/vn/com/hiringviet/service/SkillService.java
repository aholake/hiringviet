package vn.com.hiringviet.service;

import java.util.List;

import org.springframework.stereotype.Service;

import vn.com.hiringviet.dto.SkillDTO;
import vn.com.hiringviet.model.Skill;

// TODO: Auto-generated Javadoc
/**
 * The Interface SkillService.
 */
@Service("skillService")
public interface SkillService {
	
	/**
	 * Gets the skill by id.
	 *
	 * @param id the id
	 * @return the skill by id
	 */
	public Skill getSkillById(int id);
	
	/**
	 * Gets the skill list.
	 *
	 * @return the skill list
	 */
	public List<Skill> getSkillList();
	
	/**
	 * Adds the skill.
	 *
	 * @param skill the skill
	 * @return the int
	 */
	public int addSkill(Skill skill);
	
	/**
	 * Delete skill by id.
	 *
	 * @param id the id
	 * @return true, if successful
	 */
	public boolean deleteSkillById(int id);
	
	/**
	 * Delete skill.
	 *
	 * @param skill the skill
	 * @return true, if successful
	 */
	public boolean deleteSkill(Skill skill);
	
	/**
	 * Update skill.
	 *
	 * @param skill the skill
	 * @return true, if successful
	 */
	public boolean updateSkill(Skill skill);

	/**
	 * Search skill by key word.
	 *
	 * @param keyWord the key word
	 * @return the list
	 */
	public List<SkillDTO> searchSkillByKeyWord(String keyWord);
}
