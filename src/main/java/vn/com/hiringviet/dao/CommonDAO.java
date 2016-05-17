package vn.com.hiringviet.dao;

import java.io.Serializable;
import java.util.List;

public interface CommonDAO<T extends Serializable> {
	public T findOne(int id);
	
	public List<T> findAll();
	
	public int create(T entity);
	
	public boolean update(T entity);
	
	public boolean delete(T entity);
	
	public boolean deleteById(int id);
}
