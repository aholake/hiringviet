package vn.com.hiringviet.service.impl;

import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import vn.com.hiringviet.dao.ResumeDAO;
import vn.com.hiringviet.dao.SkillResumeDAO;
import vn.com.hiringviet.dto.ResumeDTO;
import vn.com.hiringviet.model.EducationHistory;
import vn.com.hiringviet.model.Resume;
import vn.com.hiringviet.service.ResumeService;
import vn.com.hiringviet.util.Utils;

@Service("resumeService")
public class ResumeServiceImpl implements ResumeService {

	@Autowired
	private ResumeDAO resumeDAO;

	@Autowired
	private SkillResumeDAO skillResumeDAO;

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

		educationHistory.setChangeLog(Utils.generatorChangeLog());

		// remove education if it's exists
		Iterator<EducationHistory> iterator = resume.getEducationHistorySet().iterator();
		if (!resume.getEducationHistorySet().isEmpty()) {
			while(iterator.hasNext()) {
				EducationHistory history = iterator.next();
				if (history.getId() == educationHistory.getId()) {
					resume.getEducationHistorySet().remove(history);
					break;
				}
			}
		}

		resume.getEducationHistorySet().add(educationHistory);

		return resumeDAO.update(resume);
	}

}
