package vn.com.hiringviet.service;

import java.util.List;

import org.springframework.stereotype.Service;

import vn.com.hiringviet.dto.ApplyDTO;

@Service("applyService")
public interface ApplyService {

	public ApplyDTO getApplyByID(Integer applyID);

	public void addApply(ApplyDTO applyDTO);

	public List<ApplyDTO> getAll();
}
