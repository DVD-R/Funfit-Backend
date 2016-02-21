package com.funfit.usjr.thesis.backend;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.funfit.usjr.thesis.backend.data.dao.service.TerritoryDao;
import com.funfit.usjr.thesis.backend.dto.ResponseTerritory;
import com.funfit.usjr.thesis.backend.models.Territory;

@RestController
public class TerritoryController {

	@Autowired
	private TerritoryDao territoryDao;
	
	@RequestMapping(value = "/getTerritory",
					produces = MediaType.APPLICATION_JSON_VALUE,
					method = RequestMethod.GET)
	public List<ResponseTerritory> getTerritory(){
		List<Territory> listTerritory = territoryDao.index();
		ResponseTerritory responseTerritory = null;
		List<ResponseTerritory> listResponseTerritory = new ArrayList<>();
		for(Territory territory: listTerritory){
			responseTerritory = new ResponseTerritory();
			responseTerritory.setId(territory.getId());
			responseTerritory.setEncoded_polyline(territory.getEncoded_polyline());
			responseTerritory.setLevel(territory.getLevel());
			responseTerritory.setStatus(territory.getStatus());
			responseTerritory.setFaction_description(territory.getFaction_description());
			listResponseTerritory.add(responseTerritory);
		}
		
		return  listResponseTerritory;
	}
	
}