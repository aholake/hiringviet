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

// TODO: Auto-generated Javadoc
/**
 * The Class EndorseServiceImpl.
 */
@Service("endorseService")
public class EndorseServiceImpl implements EndorseService {

	/** The endorse dao. */
	@Autowired
	private EndorseDAO endorseDAO;

	/** The skill resume dao. */
	@Autowired
	private SkillResumeDAO skillResumeDAO;

	/* (non-Javadoc)
	 * @see vn.com.hiringviet.service.EndorseService#create(vn.com.hiringviet.dto.EndorseDTO)
	 */
	@Override
	public Integer create(EndorseDTO endorseDTO) {

		Endorse endorse = new Endorse();
		endorse.setAccount(endorseDTO.getAccount());
		endorse.setCreatedDate(DateUtil.now());

		SkillResume skillResume = skillResumeDAO.findOne(endorseDTO.getSkillResumeId());
		endorse.setSkillResume(skillResume);

		return endorseDAO.create(endorse);
	}

	/* (non-Javadoc)
	 * @see vn.com.hiringviet.service.EndorseService#deleteByAccountId(java.lang.Integer, java.lang.Integer)
	 */
	@Override
	public boolean deleteByAccountId(Integer accountId, Integer skillResumeId) {

		return endorseDAO.deleteByAccountId(accountId, skillResumeId);
	}

}
