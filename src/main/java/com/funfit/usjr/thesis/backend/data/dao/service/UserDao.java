package com.funfit.usjr.thesis.backend.data.dao.service;

import org.springframework.transaction.annotation.Transactional;

import com.funfit.usjr.thesis.backend.data.dao.GenericDao;
import com.funfit.usjr.thesis.backend.models.User;

/**
 * 
 * @author victor
 *
 */
@Transactional
public interface UserDao extends GenericDao<User>{

}