package com.funfit.usjr.thesis.backend.data.dao.service.impl;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.funfit.usjr.thesis.backend.data.dao.service.FactionDao;
import com.funfit.usjr.thesis.backend.models.Faction;
import com.funfit.usjr.thesis.backend.models.RefurbishMarker;

@Transactional
@Repository("factionDao")
public class FactionDaoImpl extends GenericDaoImpl<Faction> implements FactionDao{

	public FactionDaoImpl() {
		super(Faction.class);
		// TODO Auto-generated constructor stub
	}

	@Override
	public Faction checkClusterUser(RefurbishMarker refurbishMarker) {
		// TODO Auto-generated method stub
		
		String hql = "select f from Faction f where f.user_id = :user_id";
		List<Faction> query = getCurrentSession().createQuery(hql)
					  .setParameter("user_id", refurbishMarker.getUser_id())
					  .list();
		Faction f = new Faction();
		for(Faction fac: query){
			f.setId(fac.getId());
			f.setFaction_description(fac.getFaction_description());
			f.setImpulse(fac.getImpulse());
			f.setUser(fac.getUser());
			f.setVelocity(fac.getVelocity());
		}
		
		return f;
	}

	@Override
	public Faction query(int id) {
		// TODO Auto-generated method stub
		String hql = "select f from Faction f where f.user_id = :user_id";
		List<Faction> query = getCurrentSession().createQuery(hql)
					  .setParameter("user_id",id)
					  .list();
		Faction f = new Faction();
		for(Faction fac: query){
			f.setId(fac.getId());
			f.setFaction_description(fac.getFaction_description());
			f.setImpulse(fac.getImpulse());
			f.setUser(fac.getUser());
			f.setVelocity(fac.getVelocity());
		}
		
		return f;
	}

}
