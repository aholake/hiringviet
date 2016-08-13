package vn.com.hiringviet.service.impl;

import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import vn.com.hiringviet.dao.PositionDAO;
import vn.com.hiringviet.dao.ResumeDAO;
import vn.com.hiringviet.dao.SkillResumeDAO;
import vn.com.hiringviet.dto.ResumeDTO;
import vn.com.hiringviet.model.EducationHistory;
import vn.com.hiringviet.model.EmploymentHistory;
import vn.com.hiringviet.model.Position;
import vn.com.hiringviet.model.Resume;
import vn.com.hiringviet.service.ResumeService;
import vn.com.hiringviet.util.DateUtil;

@Service("resumeService")
public class ResumeServiceImpl implements ResumeService {

	@Autowired
	private ResumeDAO resumeDAO;

	@Autowired
	private SkillResumeDAO skillResumeDAO;

	@Autowired
	private PositionDAO positionDAO;

	@Override
	public List<Integer> getListSkillByMemberId(Integer memberId) {

		return resumeDAO.getListSkillByMemberId(memberId);
	}

	@Override
	public boolean deleteSkillOfProfile(ResumeDTO resumeDTO) {

		return skillResumeDAO.deleteById(resumeDTO.getResumeSkillId());
	}

	@Override
	public boolean saveEducation(Resume resume, EducationHistory educationHistory) {

		// remove education if it's exists
		Iterator<EducationHistory> iterator = resume.getEducationHistorySet().iterator();
		if (!resume.getEducationHistorySet().isEmpty()) {
			while(iterator.hasNext()) {
				EducationHistory history = iterator.next();
				if (history.getId() == educationHistory.getId()) {
					resume.getEducationHistorySet().remove(history);
					educationHistory.setChangeLog(history.getChangeLog());
					educationHistory.getChangeLog().setUpdatedDate(DateUtil.now());
					break;
				}
			}
		}

		resume.getEducationHistorySet().add(educationHistory);

		return resumeDAO.update(resume);
	}

	@Override
	public boolean saveEmployee(Resume resume, EmploymentHistory employmentHistory, Integer positionId) {

		Position position = positionDAO.findOne(positionId);

		// remove education if it's exists
		Iterator<EmploymentHistory> iterator = resume.getEmployeeHistorySet().iterator();
		if (!resume.getEmployeeHistorySet().isEmpty()) {
			while (iterator.hasNext()) {
				EmploymentHistory history = iterator.next();
				if (history.getId() == employmentHistory.getId()) {
					employmentHistory.setProjects(history.getProjects());
					employmentHistory.setChangeLog(history.getChangeLog());
					employmentHistory.getChangeLog().setUpdatedDate(DateUtil.now());
					employmentHistory.setPosition(position);
					resume.getEmployeeHistorySet().remove(history);
					break;
				}
			}
		}

		resume.getEmployeeHistorySet().add(employmentHistory);

		return resumeDAO.update(resume);
	}

	@Override
	public boolean update(Resume currentResume, Resume newResume) {

		currentResume.setBirthDate(newResume.getBirthDate());
		currentResume.setPhoneNumber(newResume.getPhoneNumber());
		currentResume.setMaleGender(newResume.isMaleGender());
		currentResume.setNationality(newResume.getNationality());
		currentResume.setSummary(newResume.getSummary());

		return resumeDAO.update(currentResume);
	}

}
