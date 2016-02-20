package com.funfit.usjr.thesis.backend.data.dao.service.impl;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.funfit.usjr.thesis.backend.data.dao.service.TerritoryDao;
import com.funfit.usjr.thesis.backend.models.Territory;

@Repository("territoryDao")
@Transactional
public class TerritoryDaoImpl extends GenericDaoImpl implements TerritoryDao{

	public TerritoryDaoImpl() {
		super(Territory.class);
		// TODO Auto-generated constructor stub
	}

}
