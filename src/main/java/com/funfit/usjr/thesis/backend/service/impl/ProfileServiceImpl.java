package com.funfit.usjr.thesis.backend.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.funfit.usjr.thesis.backend.models.ProfileRequestJson;
import com.funfit.usjr.thesis.backend.models.Rdi;
import com.funfit.usjr.thesis.backend.service.ProfileService;
import com.funfit.usjr.thesis.backend.utils.CreatePolyline;
import com.funfit.usjr.thesis.backend.utils.RdiGenerator;

@Service("profileService")
@Transactional
public class ProfileServiceImpl implements ProfileService{

	private RdiGenerator rdiGenerator;
	private double RDI;
	private CreatePolyline createPolyline;
	
	@Override
	public Rdi generateResponse(ProfileRequestJson profileRequestJson) {
		// TODO Auto-generated method stub
		int age = profileRequestJson.getAge();
		double weight = profileRequestJson.getWeight();
		double height = profileRequestJson.getHeight();
		String activityLevel = profileRequestJson.getActivitylevel();
		
        System.out.println(weight); 
        System.out.println(height);  
        System.out.println(activityLevel);  
        System.out.println(profileRequestJson.getGender());
		rdiGenerator = new RdiGenerator();
		createPolyline = new CreatePolyline();
		
		
		switch(profileRequestJson.getGender()){
		case "male":
			RDI = rdiGenerator.equationForMen(weight, height, age, activityLevel);
			break;
		case "female":
			RDI = rdiGenerator.equationForWoman(weight, height, age, activityLevel);
			break;
		}
				
		Rdi rdi = new Rdi();
		rdi.setRdi(RDI);
		rdi.setUserId(Integer.parseInt(profileRequestJson.getUserId()));
		return rdi;
	}
	
	
}