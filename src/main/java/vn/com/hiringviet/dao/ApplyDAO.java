package vn.com.hiringviet.dao;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import vn.com.hiringviet.model.Apply;

@Repository
@Transactional
public interface ApplyDAO extends CommonDAO<Apply>{
}
