package vn.com.hiringviet.dao.impl;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import vn.com.hiringviet.dao.SkillResumeDAO;
import vn.com.hiringviet.model.SkillResume;

/**
 * The Class SkillResumeDAOImpl.
 */
@Repository
@Transactional
public class SkillResumeDAOImpl extends CommonDAOImpl<SkillResume> implements SkillResumeDAO {

}
