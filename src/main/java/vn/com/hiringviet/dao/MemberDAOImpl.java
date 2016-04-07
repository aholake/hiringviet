package vn.com.hiringviet.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import vn.com.hiringviet.model.Member;

@Repository
public class MemberDAOImpl implements MemberDAO{
	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	@Transactional
	public List<Member> getMemberList() {
		List<Member> memberList = null;
		Session session = sessionFactory.getCurrentSession();
		
		memberList = session.createCriteria(Member.class).list();
		return memberList;
	}
}
