package vn.com.hiringviet.dao.impl;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import vn.com.hiringviet.dao.CommonDAO;

public abstract class CommonDAOImpl<T extends Serializable> implements
		CommonDAO<T> {

	private Class<T> entityClass;

	@Autowired
	private SessionFactory sessionFactory;

	@SuppressWarnings("unchecked")
	public CommonDAOImpl() {
		entityClass = (Class<T>) ((ParameterizedType) getClass()
				.getGenericSuperclass()).getActualTypeArguments()[0];
	}

	public Session getSession() {
		Session session = this.sessionFactory.getCurrentSession();
		if (session == null) {
			session = this.sessionFactory.openSession();
		}
		return session;
	}

	@SuppressWarnings("unchecked")
	@Override
	@Transactional
	public T findOne(int id) {
		try {
			return (T) getSession().get(entityClass, id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@SuppressWarnings("unchecked")
	@Override
	@Transactional
	public List<T> findAll() {
		try {
			Query query = getSession().createQuery(
					"FROM " + entityClass.getSimpleName());
			return query.list();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	@Transactional
	public int create(T entity) {
		try {
			return (Integer) getSession().save(entity);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return -1;
	}

	@Override
	@Transactional
	public boolean update(T entity) {
		try {
			getSession().clear();
			getSession().update(entity);
			getSession().flush();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	@Transactional
	public boolean delete(T entity) {
		try {
			getSession().delete(entity);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	@Transactional
	public boolean deleteById(int id) {
		T deleteEntity = findOne(id);
		if (deleteEntity != null) {
			try {
				getSession().delete(deleteEntity);
				return true;
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return false;
	}

}
