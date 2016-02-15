package com.funfit.usjr.thesis.backend.data.dao.service.impl;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.funfit.usjr.thesis.backend.data.dao.service.AdminDao;
import com.funfit.usjr.thesis.backend.models.Admin;

import java.util.List;

import org.hibernate.Query;

@Transactional
@Repository("adminDao")
public class AdminDaoImpl extends GenericDaoImpl<Admin> implements AdminDao{

	public AdminDaoImpl() {
		super(Admin.class);
		// TODO Auto-generated constructor stub
	}

	@Override
	public Admin createQuery(String email) {
		// TODO Auto-generated method stub
		String hql = "select a from Admin a where a.email = :email";
		Query query = getCurrentSession().createQuery(hql);
		query.setParameter("email", email);
		return (Admin) query.uniqueResult();
	}

}
