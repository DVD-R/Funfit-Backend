package com.funfit.usjr.thesis.backend.data.dao;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

/** 
 * @author victor
 * @param <T>
 */
public interface GenericDao<T> {

	public List<T> index();
	
	public boolean create(T data);
	
	public T show(long id);
	
	public boolean update(T data);
	
	public boolean delete(T data);
}
