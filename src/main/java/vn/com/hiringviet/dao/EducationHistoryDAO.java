package vn.com.hiringviet.dao;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import vn.com.hiringviet.model.EducationHistory;

@Repository
@Transactional
public interface EducationHistoryDAO extends CommonDAO<EducationHistory> {

}
