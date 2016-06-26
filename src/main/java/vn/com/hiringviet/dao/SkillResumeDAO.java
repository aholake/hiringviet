package vn.com.hiringviet.dao;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import vn.com.hiringviet.model.SkillResume;

@Repository
@Transactional
public interface SkillResumeDAO extends CommonDAO<SkillResume> {

}
