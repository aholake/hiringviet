package vn.com.hiringviet.service;

import java.util.List;

import org.springframework.stereotype.Service;

import vn.com.hiringviet.dto.ApplyDTO;
import vn.com.hiringviet.model.Apply;
import vn.com.hiringviet.model.Member;

@Service("applyService")
public interface ApplyService {
	public void addApply(Apply apply);

	public void addApplyByDTO(ApplyDTO applyDTO, Member member);
	
	public List<Apply> findApplies(int jobId);
}
