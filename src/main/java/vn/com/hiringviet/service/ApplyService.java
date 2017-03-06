package vn.com.hiringviet.service;

import java.util.List;

import org.springframework.stereotype.Service;

import vn.com.hiringviet.dto.ApplyDTO;
import vn.com.hiringviet.model.Apply;
import vn.com.hiringviet.model.Member;
import vn.com.hiringviet.model.Message;

// TODO: Auto-generated Javadoc
/**
 * The Interface ApplyService.
 */
@Service("applyService")
public interface ApplyService{
	
	/**
	 * Gets the.
	 *
	 * @param id the id
	 * @return the apply
	 */
	public Apply get(int id);
	
	/**
	 * Adds the apply.
	 *
	 * @param apply the apply
	 */
	public void addApply(Apply apply);

	/**
	 * Adds the apply by dto.
	 *
	 * @param applyDTO the apply dto
	 * @param member the member
	 */
	public void addApplyByDTO(ApplyDTO applyDTO, Member member);
	
	/**
	 * Find applies.
	 *
	 * @param jobId the job id
	 * @return the list
	 */
	public List<Apply> findApplies(int jobId);
	
	/**
	 * Update.
	 *
	 * @param apply the apply
	 */
	void update(Apply apply);

	/**
	 * Gets the all apply by job id.
	 *
	 * @param jobId the job id
	 * @return the all apply by job id
	 */
	public List<ApplyDTO> getAllApplyByJobId(Integer jobId);
	
	/**
	 * Send approved apply message.
	 *
	 * @param applyId the apply id
	 * @param message the message
	 */
	void sendApprovedApplyMessage(int applyId, Message message);
	
	/**
	 * Send denied apply message.
	 *
	 * @param applyId the apply id
	 */
	void sendDeniedApplyMessage(int applyId);
}
