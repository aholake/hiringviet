package vn.com.hiringviet.dao;

import java.io.Serializable;
import java.util.List;

/**
 * The Interface CommonDAO.
 *
 * @param <T> the generic type
 */
public interface CommonDAO<T extends Serializable> {

	/**
	 * Find one.
	 *
	 * @param id the id
	 * @return the t
	 */
	public T findOne(int id);

	/**
	 * Find all.
	 *
	 * @return the list
	 */
	public List<T> findAll();

	/**
	 * Creates the.
	 *
	 * @param entity the entity
	 * @return the int
	 */
	public int create(T entity);

	/**
	 * Update.
	 *
	 * @param entity the entity
	 * @return true, if successful
	 */
	public boolean update(T entity);

	/**
	 * Delete.
	 *
	 * @param entity the entity
	 * @return true, if successful
	 */
	public boolean delete(T entity);

	/**
	 * Delete by id.
	 *
	 * @param id the id
	 * @return true, if successful
	 */
	public boolean deleteById(int id);
}
