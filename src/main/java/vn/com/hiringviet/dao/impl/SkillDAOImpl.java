package vn.com.hiringviet.dao.impl;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import vn.com.hiringviet.dao.SkillDAO;
import vn.com.hiringviet.model.Skill;

@Repository
public class SkillDAOImpl extends CommonDAOImpl<Skill> implements SkillDAO {

}
