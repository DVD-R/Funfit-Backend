package com.funfit.usjr.thesis.backend.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.funfit.usjr.thesis.backend.models.ProfileRequestJson;
import com.funfit.usjr.thesis.backend.models.ResponseJson;
import com.funfit.usjr.thesis.backend.service.ProfileService;
import com.funfit.usjr.thesis.backend.utils.CreatePolyline;
import com.funfit.usjr.thesis.backend.utils.RdiGenerator;
import com.google.maps.model.LatLng;

@Service("profileService")
@Transactional
public class ProfileServiceImpl implements ProfileService{

	private RdiGenerator rdiGenerator;
	
	private CreatePolyline createPolyline;
	private static ArrayList<LatLng> encapsulate;
	private static ArrayList<LatLng> encapsulate2;
	static{
		encapsulate = circle();
		encapsulate2 = circle2();
	}
	
	@Override
	public List<ResponseJson> generateResponse(ProfileRequestJson profileRequestJson) {
		// TODO Auto-generated method stub
		int age = profileRequestJson.getAge();
		double weight = profileRequestJson.getWeight();
		double height = profileRequestJson.getHeight();
		String activityLevel = profileRequestJson.getActivitylevel();
		
          
		rdiGenerator = new RdiGenerator();
		createPolyline = new CreatePolyline();
		double RDI = 0;
		
		switch(profileRequestJson.getGender()){
		case "Male":
			RDI = rdiGenerator.equationForMen(weight, height, age, activityLevel);
			break;
		case "Female":
			RDI = rdiGenerator.equationForWoman(weight, height, age, activityLevel);
			break;
		}
				
		ArrayList<String> polyline = new ArrayList<String>();
		polyline.add(createPolyline.create(encapsulate));
		polyline.add(createPolyline.create(encapsulate2));
		
		for(String encodedPolyline: polyline){
		System.out.println(encodedPolyline);
		}
		List<ResponseJson> responseJsonList = new ArrayList<ResponseJson>();
		
		
		ResponseJson responseJson;
		for(String encodedPolyline: polyline){
		responseJson = new ResponseJson();
		responseJson.setRdi(RDI);
		responseJson.setEncodePolyline(encodedPolyline);
		responseJsonList.add(responseJson);
		}
		return responseJsonList;
	}
	
	private static ArrayList<LatLng> circle(){
		ArrayList<LatLng> latlong = new ArrayList<LatLng>();
		latlong.add(new LatLng(	10.290651,123.861208));
		latlong.add(new LatLng(	10.290736, 123.861648));
		latlong.add(new LatLng(	10.290588, 123.861916));
		latlong.add(new LatLng(	10.290049, 123.862281));
		latlong.add(new LatLng(	10.289585, 123.862549));
		latlong.add(new LatLng(	10.289237, 123.862410));
		latlong.add(new LatLng(	10.288920, 123.861831));
		latlong.add(new LatLng(	10.289120, 123.861348));
		latlong.add(new LatLng(	10.289627, 123.861155));
		latlong.add(new LatLng(	10.290155, 123.860951));
		latlong.add(new LatLng(	10.290567, 123.861069));
		return latlong;
	}
	
	private static ArrayList<LatLng> circle2(){
		ArrayList<LatLng> latlong = new ArrayList<LatLng>();
		latlong.add(new LatLng(	10.291828, 123.863805));
		latlong.add(new LatLng(	10.291870, 123.864534));
		latlong.add(new LatLng(	10.291237, 123.864899));
		latlong.add(new LatLng(	10.290540, 123.865028));
		latlong.add(new LatLng(	10.290139, 123.864513));
		latlong.add(new LatLng(	10.290118, 123.863740));
		latlong.add(new LatLng(	10.290350, 123.863011));
		latlong.add(new LatLng(	10.291152, 123.862925));
		latlong.add(new LatLng(	10.291659, 123.863161));
		latlong.add(new LatLng(	10.291828, 123.863483));
		return latlong;
	}
}