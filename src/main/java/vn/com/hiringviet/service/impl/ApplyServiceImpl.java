package vn.com.hiringviet.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import vn.com.hiringviet.dao.ApplyDAO;
import vn.com.hiringviet.dto.ApplyDTO;
import vn.com.hiringviet.model.Apply;
import vn.com.hiringviet.model.Job;
import vn.com.hiringviet.model.Member;
import vn.com.hiringviet.service.ApplyService;
import vn.com.hiringviet.service.JobService;

@Service("applyService")
@Transactional
public class ApplyServiceImpl implements ApplyService {
	@Autowired
	private ApplyDAO applyDao;
	
	@Autowired
	private JobService jobService;

	@Override
	public void addApply(Apply apply) {
		applyDao.create(apply);
	}
	@Override
	public void addApplyByDTO(ApplyDTO applyDTO, Member member) {
		String[] jobIds = applyDTO.getJobList().split("\\+");
		String description = applyDTO.getDescription();
		for (String id : jobIds) {
			Job job = jobService.getJobById(Integer.parseInt(id));
			Apply apply = new Apply();
			apply.setJob(job);
			apply.setMember(member);
			apply.setDisscription(description);
			apply.setCurriculumVitae(applyDTO.getCurriculumVitae());
			applyDao.create(apply);
		}
		
	}
}
