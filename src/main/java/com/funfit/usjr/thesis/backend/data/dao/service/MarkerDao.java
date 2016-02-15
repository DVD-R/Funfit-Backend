package com.funfit.usjr.thesis.backend.data.dao.service;

import org.springframework.transaction.annotation.Transactional;

import com.funfit.usjr.thesis.backend.data.dao.GenericDao;
import com.funfit.usjr.thesis.backend.models.Faction;
import com.funfit.usjr.thesis.backend.models.Marker;
import com.funfit.usjr.thesis.backend.models.RefurbishMarker;
@Transactional
public interface MarkerDao extends GenericDao<Marker>{
	public boolean checkLevel(RefurbishMarker refurbishMarker);
}
