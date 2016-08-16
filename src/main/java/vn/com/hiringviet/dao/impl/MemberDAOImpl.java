package vn.com.hiringviet.dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.LogicalExpression;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.hibernate.sql.JoinType;
import org.hibernate.transform.Transformers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import vn.com.hiringviet.common.StatusEnum;
import vn.com.hiringviet.constant.ConstantValues;
import vn.com.hiringviet.dao.MemberDAO;
import vn.com.hiringviet.dto.MemberDTO;
import vn.com.hiringviet.model.Account;
import vn.com.hiringviet.model.Connect;
import vn.com.hiringviet.model.Member;

@Repository
@Transactional
public class MemberDAOImpl extends CommonDAOImpl<Member> implements MemberDAO {

	@Autowired
	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public Member getMemberByAccount(Account account) {

		Session session = this.sessionFactory.getCurrentSession();
		Criteria criteria = session.createCriteria(Member.class, "member");
		criteria.createAlias("member.changeLog", "changeLog");
		criteria.createAlias("member.account", "account");
		criteria.add(Restrictions.eq("changeLog.status", StatusEnum.ACTIVE.getValue()));
		criteria.add(Restrictions.eq("account.id", account.getId()));
		criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);

		Member result = (Member) criteria.uniqueResult();

		return result;
	}

	@Override
	public MemberDTO getMemberByAccountId(Integer accountId) {

		Session session = this.sessionFactory.getCurrentSession();
		Criteria criteria = session.createCriteria(Member.class, "member");
		criteria.createAlias("member.changeLog", "changeLog");
		criteria.createAlias("member.account", "account");
		criteria.setProjection(Projections.projectionList()
				.add(Projections.property("member.id").as("id"))
				.add(Projections.property("member.firstName").as("firstName"))
				.add(Projections.property("member.lastName").as("lastName"))
				.add(Projections.property("account.avatarImage").as("avatarImage"))
				.add(Projections.property("changeLog.status").as("status")));
		criteria.add(Restrictions.eq("account.id", accountId));
		criteria.setResultTransformer(Transformers.aliasToBean(MemberDTO.class));

		MemberDTO memberDTO = (MemberDTO) criteria.uniqueResult();
		return memberDTO;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<MemberDTO> getListMemberSuggest(String keywork) {

		Session session = this.sessionFactory.getCurrentSession();

		LogicalExpression checkFirstNameAndLastName = Restrictions.or(Restrictions.like("member.firstName", keywork + "%"), Restrictions.like("member.lastName", keywork + "%"));
		LogicalExpression checkFullName = Restrictions.or(checkFirstNameAndLastName, Restrictions.like("member.fullName", keywork + "%"));

		Criteria criteria = session.createCriteria(Member.class, "member");
		criteria.createAlias("member.changeLog", "changeLog");
		criteria.createAlias("member.account", "account");
		criteria.createAlias("member.resume", "resume");
		criteria.createAlias("resume.address", "address");
		criteria.createAlias("address.district", "district", JoinType.LEFT_OUTER_JOIN);
		criteria.createAlias("district.province", "province", JoinType.LEFT_OUTER_JOIN);
		criteria.createAlias("province.country", "country", JoinType.LEFT_OUTER_JOIN);
		criteria.setProjection(Projections.projectionList()
				.add(Projections.groupProperty("member.id").as("id"))
				.add(Projections.property("member.firstName").as("firstName"))
				.add(Projections.property("member.lastName").as("lastName"))
				.add(Projections.property("account.avatarImage").as("avatarImage"))
				.add(Projections.count("account.toFollows").as("numberFollower"))
				.add(Projections.property("district.districtName").as("district"))
				.add(Projections.property("province.provinceName").as("province"))
				.add(Projections.property("country.countryName").as("country")));
		criteria.add(checkFullName);
		criteria.setMaxResults(ConstantValues.MAX_RECORD_COUNT);
		criteria.setResultTransformer(Transformers.aliasToBean(MemberDTO.class));

		List<MemberDTO> memberDTOs = (List<MemberDTO>) criteria.list();
		return memberDTOs;
	}

	@Override
	public void addConnect(Connect connect) {

		Session session = this.sessionFactory.getCurrentSession();

		session.persist(connect);

	}

}
