package vn.com.hiringviet.service;

import java.util.List;

import org.springframework.stereotype.Service;

import vn.com.hiringviet.model.Apply;

@Service("applyService")
public interface ApplyService {

	public Apply getApplyByID(Integer applyID);

	public void addApply(Apply apply);

	public List<Apply> getAll();
}
