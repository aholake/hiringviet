package vn.com.hiringviet.dao.impl;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.ArrayList;
import java.util.List;

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
		return this.sessionFactory.getCurrentSession();
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
		List<T> result = new ArrayList<T>();
		try {
			result = getSession().createCriteria(entityClass).list();
			return result;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	@Transactional
	public int create(T entity) {
		try {
			return (int) getSession().save(entity);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return -1;
	}

	@Override
	@Transactional
	public boolean update(T entity) {
		try {
			getSession().update(entity);
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
				getSession().update(deleteEntity);
				return true;
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return false;
	}

}
