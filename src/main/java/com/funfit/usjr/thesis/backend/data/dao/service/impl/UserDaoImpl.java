package com.funfit.usjr.thesis.backend.data.dao.service.impl;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.funfit.usjr.thesis.backend.data.dao.service.UserDao;
import com.funfit.usjr.thesis.backend.models.ProfileRequestJson;
import com.funfit.usjr.thesis.backend.models.User;

/**
 * 
 * @author victor
 *
 */
@Transactional
@Repository("userDao")
public class UserDaoImpl extends GenericDaoImpl<User> implements UserDao{

	public UserDaoImpl() {
		super(User.class);
		// TODO Auto-generated constructor stub
	}
}