package com.funfit.usjr.thesis.backend;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.funfit.usjr.thesis.backend.data.dao.service.EventDao;
import com.funfit.usjr.thesis.backend.data.dao.service.FactionDao;
import com.funfit.usjr.thesis.backend.data.dao.service.MarkerDao;
import com.funfit.usjr.thesis.backend.models.Event;
import com.funfit.usjr.thesis.backend.models.Faction;
import com.funfit.usjr.thesis.backend.models.Marker;
import com.funfit.usjr.thesis.backend.models.RefurbishMarker;

@Controller
public class ApplicationController {

	@Autowired
	private MarkerDao markerDao;
	
	@Autowired
	private FactionDao factionDao;
	
	@Autowired
	private EventDao eventDao;
	
	@RequestMapping(value = "/getMarkers", 
					produces = MediaType.APPLICATION_JSON_VALUE,
					method = RequestMethod.GET)
	public @ResponseBody List<Marker> getMarkers(){
		return markerDao.index();
	}
	
	
	@RequestMapping(value = "/updateMarkerDetails",
					consumes = MediaType.APPLICATION_JSON_VALUE,
					produces = MediaType.APPLICATION_JSON_VALUE,
					method = RequestMethod.POST)
	public @ResponseBody List<Marker> updateMarkerDetail(@RequestBody RefurbishMarker refurbishMarker){

//		Marker ma = markerDao.show1(refurbishMarker.getId());
//		System.out.println(refurbishMarker.getId());
			markerDao.checkLevel(refurbishMarker);	
		
		
			List<Marker> markerList = markerDao.index();
			
		return markerList;
	}
	
	@RequestMapping(value = "/getEvents", produces = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.GET)
	public @ResponseBody List<Event> getEvents(){
		return eventDao.index();
	}
}