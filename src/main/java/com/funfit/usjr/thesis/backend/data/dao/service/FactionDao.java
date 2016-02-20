package com.funfit.usjr.thesis.backend.data.dao.service;
import org.springframework.transaction.annotation.Transactional;

import com.funfit.usjr.thesis.backend.data.dao.GenericDao;
import com.funfit.usjr.thesis.backend.models.Faction;
import com.funfit.usjr.thesis.backend.models.RefurbishMarker;

@Transactional
public interface FactionDao extends GenericDao<Faction>{
	public Faction checkClusterUser(RefurbishMarker refurbishMarker);
	public Faction query(int id);
}
