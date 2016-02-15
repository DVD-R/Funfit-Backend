package com.funfit.usjr.thesis.backend.data.dao.service.impl;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import com.funfit.usjr.thesis.backend.data.dao.service.EventDao;
import com.funfit.usjr.thesis.backend.models.Event;

@Transactional
@Repository("eventDao")
public class EventDaoImpl extends GenericDaoImpl<Event> implements EventDao{

	public EventDaoImpl() {
		super(Event.class);
		// TODO Auto-generated constructor stub
	}

}