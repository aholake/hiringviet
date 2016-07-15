package vn.com.hiringviet.dao.impl;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import vn.com.hiringviet.dao.EducationHistoryDAO;
import vn.com.hiringviet.model.EducationHistory;

@Repository
@Transactional
public class EducationHistoryDAOImpl extends CommonDAOImpl<EducationHistory> implements EducationHistoryDAO {

}
