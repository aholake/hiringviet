package vn.com.hiringviet.dao.impl;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import vn.com.hiringviet.dao.LoggerDAO;
import vn.com.hiringviet.model.Logger;

@Repository
@Transactional
public class LoggerDAOImpl extends CommonDAOImpl<Logger> implements LoggerDAO {

}
