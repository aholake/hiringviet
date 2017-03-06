package vn.com.hiringviet.dao;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import vn.com.hiringviet.model.Resume;

// TODO: Auto-generated Javadoc
/**
 * The Interface ResumeDAO.
 */
@Repository
@Transactional
public interface ResumeDAO extends CommonDAO<Resume> {

	/**
	 * Gets the list skill by member id.
	 *
	 * @param memberId the member id
	 * @return the list skill by member id
	 */
	public List<Integer> getListSkillByMemberId(Integer memberId);

//	public boolean deleteSkillOfProfile(ResumeDTO resumeDTO);

	/**
 * Update phone number.
 *
 * @param resumeId the resume id
 * @param phoneNumber the phone number
 * @return true, if successful
 */
public boolean updatePhoneNumber(Integer resumeId, String phoneNumber);
}
