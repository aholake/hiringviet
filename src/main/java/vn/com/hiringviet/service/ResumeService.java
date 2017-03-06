package vn.com.hiringviet.service;

import java.util.List;

import org.springframework.stereotype.Service;

import vn.com.hiringviet.dto.ResumeDTO;
import vn.com.hiringviet.model.EducationHistory;
import vn.com.hiringviet.model.EmploymentHistory;
import vn.com.hiringviet.model.Resume;

// TODO: Auto-generated Javadoc
/**
 * The Interface ResumeService.
 */
@Service("resumeService")
public interface ResumeService {

	/**
	 * Gets the list skill by member id.
	 *
	 * @param memberId the member id
	 * @return the list skill by member id
	 */
	public List<Integer> getListSkillByMemberId(Integer memberId);

	/**
	 * Delete skill of profile.
	 *
	 * @param resumeDTO the resume dto
	 * @return true, if successful
	 */
	public boolean deleteSkillOfProfile(ResumeDTO resumeDTO);

	/**
	 * Save education.
	 *
	 * @param resume the resume
	 * @param educationHistory the education history
	 * @return true, if successful
	 */
	public boolean saveEducation(Resume resume, EducationHistory educationHistory);

	/**
	 * Save employee.
	 *
	 * @param resume the resume
	 * @param employmentHistory the employment history
	 * @param positionId the position id
	 * @return true, if successful
	 */
	public boolean saveEmployee(Resume resume, EmploymentHistory employmentHistory, Integer positionId);

	/**
	 * Update.
	 *
	 * @param currentResume the current resume
	 * @param newResume the new resume
	 * @return true, if successful
	 */
	public boolean update(Resume currentResume, Resume newResume);

	/**
	 * Update phone number.
	 *
	 * @param resumeId the resume id
	 * @param phoneNumber the phone number
	 * @return true, if successful
	 */
	public boolean updatePhoneNumber(Integer resumeId, String phoneNumber);
}
