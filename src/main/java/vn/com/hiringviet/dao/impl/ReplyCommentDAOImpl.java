package vn.com.hiringviet.dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.hibernate.transform.Transformers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import vn.com.hiringviet.dao.ReplyCommentDAO;
import vn.com.hiringviet.dto.ReplyCommentDTO;
import vn.com.hiringviet.model.ReplyComment;

// TODO: Auto-generated Javadoc
/**
 * The Class ReplyCommentDAOImpl.
 */
@Repository
@Transactional
public class ReplyCommentDAOImpl extends CommonDAOImpl<ReplyComment> implements ReplyCommentDAO {

	/** The session factory. */
	@Autowired
	private SessionFactory sessionFactory;

	/**
	 * Sets the session factory.
	 *
	 * @param sessionFactory the new session factory
	 */
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	/* (non-Javadoc)
	 * @see vn.com.hiringviet.dao.ReplyCommentDAO#getListCommentByPostId(java.lang.Integer, java.lang.Integer, java.lang.Integer)
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<ReplyCommentDTO> getListCommentByPostId(Integer first, Integer max, Integer commentId) {

		Session session = sessionFactory.getCurrentSession();

		Criteria criteria = session.createCriteria(ReplyComment.class, "replyComment");
		criteria.createAlias("replyComment.changeLog", "changeLog");
		criteria.createAlias("replyComment.account", "account");
		criteria.createAlias("replyComment.comment", "comment");
		criteria.setProjection(Projections.projectionList()
				.add(Projections.property("changeLog").as("changeLog"))
				.add(Projections.property("account").as("account"))
				.add(Projections.property("replyComment.replyComment").as("replyComment"))
				.add(Projections.property("replyComment.id").as("replyCommentId")));
		criteria.add(Restrictions.eq("comment.id", commentId));
		criteria.setFirstResult(first);
		criteria.setMaxResults(max);
		criteria.setResultTransformer(Transformers.aliasToBean(ReplyCommentDTO.class));

		List<ReplyCommentDTO> resulCommentDTOs = (List<ReplyCommentDTO>) criteria.list();
		return resulCommentDTOs;
	}

	/* (non-Javadoc)
	 * @see vn.com.hiringviet.dao.ReplyCommentDAO#delete(java.lang.Integer)
	 */
	@Override
	public boolean delete(Integer replyCommentId) {

		ReplyComment replyComment = findOne(replyCommentId);

		if (replyComment != null) {
			return delete(replyComment);
		}

		return false;
	}
}
