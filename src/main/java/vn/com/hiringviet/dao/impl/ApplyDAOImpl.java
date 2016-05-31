//package vn.com.hiringviet.dao.impl;
//
//import java.util.List;
//
//import org.hibernate.Session;
//import org.hibernate.SessionFactory;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Repository;
//import org.springframework.transaction.annotation.Transactional;
//
//import vn.com.hiringviet.dao.ApplyDAO;
//import vn.com.hiringviet.model.Apply;
//
//@Repository
//@Transactional
//public class ApplyDAOImpl implements ApplyDAO {
//
//	@Autowired
//	private SessionFactory sessionFactory;
//
//	public void setSessionFactory(SessionFactory sessionFactory) {
//		this.sessionFactory = sessionFactory;
//	}
//
//	@Override
//	public Apply getApplyByID(Integer applyID) {
//
//		Session session = this.sessionFactory.getCurrentSession();
//
//		Apply apply = (Apply) session.get(Apply.class, applyID);
//		return apply;
//	}
//
//	@Override
//	public void addApply(Apply apply) {
//
//		Session session = this.sessionFactory.getCurrentSession();
//		session.persist(apply);
//	}
//
//	@SuppressWarnings("unchecked")
//	@Override
//	public List<Apply> getAll() {
//
//		Session session = this.sessionFactory.getCurrentSession();
//		List<Apply> applyList = session.createCriteria(Apply.class).list();
//		return applyList;
//	}
//
//}
