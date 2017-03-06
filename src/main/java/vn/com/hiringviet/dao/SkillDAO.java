package vn.com.hiringviet.dao;

import java.util.List;

import vn.com.hiringviet.dto.SkillDTO;
import vn.com.hiringviet.model.Skill;

// TODO: Auto-generated Javadoc
/**
 * The Interface SkillDAO.
 */
public interface SkillDAO extends CommonDAO<Skill> {

	/**
	 * Search skill by key word.
	 *
	 * @param keyWord the key word
	 * @return the list
	 */
	public List<SkillDTO> searchSkillByKeyWord(String keyWord);

	/**
	 * Sub adding number.
	 *
	 * @param skillId the skill id
	 * @return true, if successful
	 */
	public boolean subAddingNumber(Integer skillId);

	/**
	 * Gets the skill by display name.
	 *
	 * @param displayName the display name
	 * @return the skill by display name
	 */
	public Skill getSkillByDisplayName(String displayName);
}
