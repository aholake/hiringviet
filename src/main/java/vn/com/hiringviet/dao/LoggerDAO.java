package vn.com.hiringviet.dao;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import vn.com.hiringviet.model.Logger;

/**
 * The Interface LoggerDAO.
 */
@Repository
@Transactional
public interface LoggerDAO extends CommonDAO<Logger>   {

}
