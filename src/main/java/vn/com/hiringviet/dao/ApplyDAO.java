package vn.com.hiringviet.dao;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import vn.com.hiringviet.model.Apply;

@Repository
@Transactional
public interface ApplyDAO {

	public Apply getApplyByID(Integer applyID);

	public void addApply(Apply apply);

	public List<Apply> getAll();
}
