package vn.com.hiringviet.service;

import org.springframework.stereotype.Service;

import vn.com.hiringviet.dto.EndorseDTO;

// TODO: Auto-generated Javadoc
/**
 * The Interface EndorseService.
 */
@Service("endorseService")
public interface EndorseService {

	/**
	 * Creates the.
	 *
	 * @param endorseDTO the endorse dto
	 * @return the integer
	 */
	public Integer create(EndorseDTO endorseDTO);

	/**
	 * Delete by account id.
	 *
	 * @param accountId the account id
	 * @param skillResumeId the skill resume id
	 * @return true, if successful
	 */
	public boolean deleteByAccountId(Integer accountId, Integer skillResumeId);
}
