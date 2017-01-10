package vn.com.hiringviet.service.impl;

import java.util.List;

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
import vn.com.hiringviet.util.Utils;

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
			apply.setChangeLog(Utils.createDefaultChangeLog());
			applyDao.addApplyByNativeSQL(apply);
		}

	}

	@Override
	public List<Apply> findApplies(int jobId) {
		Job job = jobService.getJobById(jobId);
		return applyDao.getApplies(job);
	}

	@Override
	public Apply get(int id) {
		return applyDao.findOne(id);
	}

	@Override
	public void update(Apply apply) {
		applyDao.update(apply);
	}
}
