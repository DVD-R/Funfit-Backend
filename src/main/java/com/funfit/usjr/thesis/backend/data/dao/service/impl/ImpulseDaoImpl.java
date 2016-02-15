package com.funfit.usjr.thesis.backend.data.dao.service.impl;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.funfit.usjr.thesis.backend.data.dao.service.ImpulseDao;
import com.funfit.usjr.thesis.backend.models.Impulse;

@Transactional
@Repository("impulseDao")
public class ImpulseDaoImpl extends GenericDaoImpl<Impulse> implements ImpulseDao{

	public ImpulseDaoImpl() {
		super(Impulse.class);
		// TODO Auto-generated constructor stub
	}
}
