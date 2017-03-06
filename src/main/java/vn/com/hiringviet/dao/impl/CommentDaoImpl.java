package vn.com.hiringviet.dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.hibernate.sql.JoinType;
import org.hibernate.transform.Transformers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import vn.com.hiringviet.dao.CommentDAO;
import vn.com.hiringviet.dto.CommentDTO;
import vn.com.hiringviet.model.ChangeLog;
import vn.com.hiringviet.model.Comment;
import vn.com.hiringviet.util.Utils;

// TODO: Auto-generated Javadoc
/**
 * The Class CommentDaoImpl.
 */
@Repository
@Transactional
public class CommentDaoImpl extends CommonDAOImpl<Comment> implements CommentDAO {

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
	 * @see vn.com.hiringviet.dao.CommentDAO#getListComment(java.lang.Integer, java.lang.Integer, java.lang.Integer, boolean)
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<CommentDTO> getListComment(Integer first, Integer max, Integer id, boolean isPost) {

		Session session = sessionFactory.getCurrentSession();

		Criteria criteria = session.createCriteria(Comment.class, "comment");
		criteria.createAlias("comment.member", "member");
		criteria.createAlias("comment.member.resume", "resume");
		criteria.createAlias("comment.member.account", "account", JoinType.LEFT_OUTER_JOIN);

		if (isPost) {
			criteria.createAlias("comment.post", "post");
		} else {
			criteria.createAlias("comment.job", "job");
		}

		criteria.createAlias("comment.changeLog", "changeLog");
		criteria.createAlias("comment.replyCommentSet", "replyCommentSet", JoinType.LEFT_OUTER_JOIN);
		criteria.setProjection(Projections.projectionList()
				.add(Projections.groupProperty("member.id").as("memberId"))
				.add(Projections.groupProperty("account.id").as("accountId"))
				.add(Projections.groupProperty("comment.id").as("commentId"))
				.add(Projections.property("account.avatarImage").as("avatarImage"))
				.add(Projections.property("changeLog").as("changeLog"))
				.add(Projections.property("comment.comment").as("comment"))
				.add(Projections.property("member.firstName").as("firstName"))
				.add(Projections.property("member.lastName").as("lastName"))
				.add(Projections.count("replyCommentSet.id").as("numberReplyComment")));

		if (isPost) {
			criteria.add(Restrictions.eq("post.id", id));
		} else {
			criteria.add(Restrictions.eq("job.id", id));
		}

		criteria.addOrder(Order.asc("comment.id"));
		criteria.setFirstResult(first);
		criteria.setMaxResults(max);
		criteria.setResultTransformer(Transformers.aliasToBean(CommentDTO.class));

		List<CommentDTO> comments = (List<CommentDTO>) criteria.list();
		return comments;
	}

	/* (non-Javadoc)
	 * @see vn.com.hiringviet.dao.CommentDAO#create(vn.com.hiringviet.dto.CommentDTO)
	 */
	@Override
	public Integer create(CommentDTO commentDTO) {

		Integer result = 1;
		Query query = null;
		StringBuffer insertChangeLogSQL = new StringBuffer();
		ChangeLog changeLog = Utils.createDefaultChangeLog();
		insertChangeLogSQL.append("INSERT INTO change_log (created_date, status, updated_date) VALUES (:createdDate, 1, :updatedDate)");
		query = getSession().createSQLQuery(insertChangeLogSQL.toString());
		query.setParameter("createdDate", changeLog.getCreatedDate());
		query.setParameter("updatedDate", changeLog.getUpdatedDate());

		result = query.executeUpdate();
		if (result <= 0) {
			return result;
		}

		StringBuffer getLastIdSQL = new StringBuffer();
		getLastIdSQL.append("SELECT change_log.id FROM change_log ORDER BY id desc LIMIT 0,1");
		query = getSession().createSQLQuery(getLastIdSQL.toString());
		Integer clId = (Integer) query.uniqueResult();

		StringBuffer insertCommentSQL = new StringBuffer();
		insertCommentSQL.append("INSERT INTO comment (comment, change_log_id, job_id, member_id, post_id) VALUES (:comment, :changeLogId, :jobId, :memberId, :postId)");
		query = getSession().createSQLQuery(insertCommentSQL.toString());
		query.setParameter("comment", commentDTO.getComment());
		query.setParameter("changeLogId", clId);
		query.setParameter("jobId", commentDTO.getJobId());
		query.setParameter("memberId", commentDTO.getMember().getId());
		query.setParameter("postId", commentDTO.getPostId());

		result = query.executeUpdate();
		if (result <= 0) {
			return result;
		}

		return result;

	}

	/* (non-Javadoc)
	 * @see vn.com.hiringviet.dao.CommentDAO#delete(java.lang.Integer)
	 */
	@Override
	public boolean delete(Integer commentId) {

		Comment comment = findOne(commentId);

		if (comment != null) {
			return delete(comment);
		}
		return false;
	}

}
