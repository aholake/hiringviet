package vn.com.hiringviet.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import vn.com.hiringviet.dao.EndorseDAO;
import vn.com.hiringviet.dao.SkillResumeDAO;
import vn.com.hiringviet.dto.EndorseDTO;
import vn.com.hiringviet.model.Endorse;
import vn.com.hiringviet.model.SkillResume;
import vn.com.hiringviet.service.EndorseService;
import vn.com.hiringviet.util.DateUtil;

@Service("endorseService")
public class EndorseServiceImpl implements EndorseService {

	@Autowired
	private EndorseDAO endorseDAO;

	@Autowired
	private SkillResumeDAO skillResumeDAO;

	@Override
	public Integer create(EndorseDTO endorseDTO) {

		Endorse endorse = new Endorse();
		endorse.setAccount(endorseDTO.getAccount());
		endorse.setCreatedDate(DateUtil.now());

		SkillResume skillResume = skillResumeDAO.findOne(endorseDTO.getSkillResumeId());
		endorse.setSkillResume(skillResume);

		return endorseDAO.create(endorse);
	}

	@Override
	public boolean deleteByAccountId(Integer accountId, Integer skillResumeId) {

		return endorseDAO.deleteByAccountId(accountId, skillResumeId);
	}

}
