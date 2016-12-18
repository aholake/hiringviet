package vn.com.hiringviet.dao.impl;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import vn.com.hiringviet.dao.ApplyDAO;
import vn.com.hiringviet.model.Apply;

@Repository
@Transactional
public class ApplyDAOImpl extends CommonDAOImpl<Apply> implements ApplyDAO {
}
