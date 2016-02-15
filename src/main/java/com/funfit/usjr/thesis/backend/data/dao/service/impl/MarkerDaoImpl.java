package com.funfit.usjr.thesis.backend.data.dao.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.funfit.usjr.thesis.backend.data.dao.service.FactionDao;
import com.funfit.usjr.thesis.backend.data.dao.service.MarkerDao;
import com.funfit.usjr.thesis.backend.models.Faction;
import com.funfit.usjr.thesis.backend.models.Marker;
import com.funfit.usjr.thesis.backend.models.RefurbishMarker;

@Transactional
@Repository("markerDao")
public class MarkerDaoImpl extends GenericDaoImpl<Marker> implements MarkerDao{

	@Autowired
	FactionDao factionDao;
	
	public MarkerDaoImpl() {
		super(Marker.class);
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean checkLevel(RefurbishMarker refurbishMarker) {
		// TODO Auto-generated method stub
		
		Marker marker = (Marker)getCurrentSession().get(Marker.class, refurbishMarker.getId());
		marker.setCluster_name(refurbishMarker.getCluster_description());
		marker.setLvl(1);
		marker.setFaction(refurbishMarker.getFaction_id());
		getCurrentSession().update(marker);
		if(!marker.equals(null)){
			return true;
		}else{
			return false;		
		}
	}
}