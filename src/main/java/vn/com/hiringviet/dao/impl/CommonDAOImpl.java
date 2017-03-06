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

// TODO: Auto-generated Javadoc
/**
 * The Class CommonDAOImpl.
 *
 * @param <T> the generic type
 */
public abstract class CommonDAOImpl<T extends Serializable> implements
		CommonDAO<T> {

	/** The entity class. */
	private Class<T> entityClass;

	/** The session factory. */
	@Autowired
	private SessionFactory sessionFactory;

	/**
	 * Instantiates a new common dao impl.
	 */
	@SuppressWarnings("unchecked")
	public CommonDAOImpl() {
		entityClass = (Class<T>) ((ParameterizedType) getClass()
				.getGenericSuperclass()).getActualTypeArguments()[0];
	}

	/**
	 * Gets the session.
	 *
	 * @return the session
	 */
	public Session getSession() {
		Session session = this.sessionFactory.getCurrentSession();
		if (session == null) {
			session = this.sessionFactory.openSession();
		}
		return session;
	}

	/* (non-Javadoc)
	 * @see vn.com.hiringviet.dao.CommonDAO#findOne(int)
	 */
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

	/* (non-Javadoc)
	 * @see vn.com.hiringviet.dao.CommonDAO#findAll()
	 */
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

	/* (non-Javadoc)
	 * @see vn.com.hiringviet.dao.CommonDAO#create(java.io.Serializable)
	 */
	@Override
	@Transactional
	public int create(T entity) {
		int result=-1;
		try {
			result = (Integer) getSession().save(entity);
			getSession().evict(entity);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	/* (non-Javadoc)
	 * @see vn.com.hiringviet.dao.CommonDAO#update(java.io.Serializable)
	 */
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

	/* (non-Javadoc)
	 * @see vn.com.hiringviet.dao.CommonDAO#delete(java.io.Serializable)
	 */
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

	/* (non-Javadoc)
	 * @see vn.com.hiringviet.dao.CommonDAO#deleteById(int)
	 */
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
