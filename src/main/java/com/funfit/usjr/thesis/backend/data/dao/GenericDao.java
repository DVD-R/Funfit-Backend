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
	
	public T show1(int id);
	
	public T show(int id);
	
	public T showUser(String id);
	
	public boolean update(T data);
	
	public boolean delete(T data);
}
