package com.funfit.usjr.thesis.backend.data.dao.service.impl;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.funfit.usjr.thesis.backend.data.dao.service.HealthPreferenceDao;
import com.funfit.usjr.thesis.backend.models.HealthPreference;

@Repository("healthPreferenceDao")
@Transactional
public class HealthPreferenceDaoImpl extends GenericDaoImpl<HealthPreference> implements HealthPreferenceDao{

	public HealthPreferenceDaoImpl() {
		super(HealthPreference.class);
		// TODO Auto-generated constructor stub
	}
}
