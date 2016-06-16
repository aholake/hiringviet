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

import vn.com.hiringviet.dao.CommentDAO;
import vn.com.hiringviet.dto.CommentDTO;
import vn.com.hiringviet.model.Comment;

@Repository
@Transactional
public class CommentDaoImpl implements CommentDAO {

	@Autowired
	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Comment> getListCommentByPostId(Integer postId) {

		Session session = sessionFactory.getCurrentSession();

		Criteria criteria = session.createCriteria(Comment.class, "comment");
		criteria.createAlias("comment.member", "member");
		criteria.createAlias("comment.member.resume", "resume");
		criteria.createAlias("comment.replyCommentList", "replyCommentList");
		criteria.createAlias("comment.posts", "posts");
		criteria.setProjection(Projections.projectionList()
				.add(Projections.property("member.id").as("memberId"))
				.add(Projections.property("comment.id").as("commentId"))
				.add(Projections.property("comment.id").as("replyCommentId"))
				.add(Projections.property("member.firstName").as("firstName"))
				.add(Projections.property("member.lastName").as("lastName")));
		criteria.add(Restrictions.eq("posts.id", postId));
		criteria.setResultTransformer(Transformers.aliasToBean(CommentDTO.class));

		List<Comment> comments = (List<Comment>) criteria.list();
		return comments;
	}

}
