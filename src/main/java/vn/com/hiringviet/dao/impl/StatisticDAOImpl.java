package vn.com.hiringviet.dao.impl;

import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import vn.com.hiringviet.dao.StatisticDAO;
import vn.com.hiringviet.dto.StatisticDTO;

@Repository
public class StatisticDAOImpl implements StatisticDAO{
	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public StatisticDTO getStatistic() {
		Session session = sessionFactory.getCurrentSession();
		SQLQuery sqlQuery = session.createSQLQuery("SELECT count(*) as totalMember, (SELECT count(*)  FROM company) as totalCompany, (SELECT count(*) FROM job) as totalPost FROM member");
		sqlQuery.addEntity(StatisticDTO.class);
		return (StatisticDTO) sqlQuery.uniqueResult();
	}

}
