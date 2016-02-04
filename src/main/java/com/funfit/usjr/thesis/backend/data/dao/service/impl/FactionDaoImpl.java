package com.funfit.usjr.thesis.backend.data.dao.service.impl;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.funfit.usjr.thesis.backend.data.dao.service.FactionDao;
import com.funfit.usjr.thesis.backend.models.Faction;

@Transactional
@Repository("factionDao")
public class FactionDaoImpl extends GenericDaoImpl<Faction> implements FactionDao{

	public FactionDaoImpl() {
		super(Faction.class);
		// TODO Auto-generated constructor stub
	}

}
