package vn.com.hiringviet.dao.impl;

import java.util.List;

import org.hibernate.Criteria;
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
import vn.com.hiringviet.model.Comment;

@Repository
@Transactional
public class CommentDaoImpl extends CommonDAOImpl<Comment> implements CommentDAO {

	@Autowired
	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

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

}
