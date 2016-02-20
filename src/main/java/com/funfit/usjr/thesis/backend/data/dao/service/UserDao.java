package com.funfit.usjr.thesis.backend.data.dao.service;

import org.springframework.transaction.annotation.Transactional;

import com.funfit.usjr.thesis.backend.data.dao.GenericDao;
import com.funfit.usjr.thesis.backend.models.Users;
import com.google.appengine.api.users.User;

/**
 * 
 * @author victor
 *
 */
@Transactional
public interface UserDao extends GenericDao<Users>{
	public boolean checkEmail(String email);
}