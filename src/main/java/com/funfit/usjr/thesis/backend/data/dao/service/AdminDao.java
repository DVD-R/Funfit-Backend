package com.funfit.usjr.thesis.backend.data.dao.service;

import org.springframework.transaction.annotation.Transactional;

import com.funfit.usjr.thesis.backend.data.dao.GenericDao;
import com.funfit.usjr.thesis.backend.models.Admin;

@Transactional
public interface AdminDao extends GenericDao<Admin>{
	public Admin createQuery(String username);
}
