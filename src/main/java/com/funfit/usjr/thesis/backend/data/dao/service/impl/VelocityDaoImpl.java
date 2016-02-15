package com.funfit.usjr.thesis.backend.data.dao.service.impl;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.funfit.usjr.thesis.backend.data.dao.service.VelocityDao;
import com.funfit.usjr.thesis.backend.models.Velocity;

@Transactional
@Repository("velocityDao")
public class VelocityDaoImpl extends GenericDaoImpl<Velocity> implements VelocityDao{

	public VelocityDaoImpl() {
		super(Velocity.class);
		// TODO Auto-generated constructor stub
	}
}
