package com.funfit.usjr.thesis.backend.data.dao.service.impl;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.funfit.usjr.thesis.backend.data.dao.service.UserDao;
import com.funfit.usjr.thesis.backend.models.Faction;
import com.funfit.usjr.thesis.backend.models.ProfileRequestJson;
import com.funfit.usjr.thesis.backend.models.Users;
import com.google.appengine.api.users.User;

/**
 * 
 * @author victor
 *
 */
@Transactional
@Repository("userDao")
public class UserDaoImpl extends GenericDaoImpl<Users> implements UserDao{

	public UserDaoImpl() {
		super(Users.class);
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean checkEmail(String email) {
		// TODO Auto-generated method stub
		String hql = "select u from Users u where u.email = :email";
		List<User> query = getCurrentSession().createQuery(hql)
					  .setParameter("email",email)
					  .list();
		if(query != null){
			return true;	
		}else{
			return false;
		}
	}
}