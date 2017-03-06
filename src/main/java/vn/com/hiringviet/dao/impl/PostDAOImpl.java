package vn.com.hiringviet.dao.impl;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import vn.com.hiringviet.dao.PostDAO;
import vn.com.hiringviet.model.Post;

/**
 * The Class PostDAOImpl.
 */
@Repository
@Transactional
public class PostDAOImpl extends CommonDAOImpl<Post> implements PostDAO {

}
