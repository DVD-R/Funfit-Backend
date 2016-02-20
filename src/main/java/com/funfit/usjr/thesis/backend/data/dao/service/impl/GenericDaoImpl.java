package com.funfit.usjr.thesis.backend.data.dao.service.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.funfit.usjr.thesis.backend.data.dao.GenericDao;
import com.google.common.base.Preconditions;

/**
 * 
 * @author victor
 *
 * @param <T>
 */
@Transactional
public class GenericDaoImpl<T> implements GenericDao<T>{
	private Class<T> thisClass;
	
	@Autowired
	SessionFactory sessionFactory;

	
	public GenericDaoImpl(final Class<T> classToSet){
	thisClass = Preconditions.checkNotNull(classToSet);
	}
	
	@Override
	public List<T> index() {
		return getCurrentSession().createQuery("from " + this.thisClass.getName()).list();
	}

	@Override
	public boolean create(T data) {
		try{
			getCurrentSession().save(Preconditions.checkNotNull(data));
			return true;
		}catch(Exception ex){
			return false;
		}
	}

	@Override
	public T show(int id) {
		// TODO Auto-generated method stub
		return getCurrentSession().get(thisClass, id);
	}

	@Override
	public boolean update(T data) {
		try{
			getCurrentSession().merge(Preconditions.checkNotNull(data));
			return true;
		}catch(Exception e){
		return false;
		}
	}

	@Override
	public boolean delete(T data) {
		try{
			getCurrentSession().delete(data);
		return true;	
		}catch(Exception ex){
		return false;
		}
	}

	protected Session getCurrentSession(){
		return sessionFactory.getCurrentSession();
	}

	@Override
	public T showUser(String id) {
		// TODO Auto-generated method stub
		return getCurrentSession().get(thisClass, id);
	}

	@Override
	public T show1(int id) {
		// TODO Auto-generated method stub
		return null;
	}	
}