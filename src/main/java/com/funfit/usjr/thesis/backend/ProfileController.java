package com.funfit.usjr.thesis.backend;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.funfit.usjr.thesis.backend.data.dao.service.HealthPreferenceDao;
import com.funfit.usjr.thesis.backend.data.dao.service.UserDao;
import com.funfit.usjr.thesis.backend.models.HealthPreference;
import com.funfit.usjr.thesis.backend.models.ProfileRequestJson;
import com.funfit.usjr.thesis.backend.models.ResponseJson;
import com.funfit.usjr.thesis.backend.models.User;
import com.funfit.usjr.thesis.backend.service.ProfileService;

/**
 * 
 * @author victor
 *
 */
@Controller
public class ProfileController {
	
	@Autowired
	ProfileService profileService;
	
	@Autowired
	UserDao userDao;
	
	@Autowired
	HealthPreferenceDao healthPreferenceDao;
	
	@RequestMapping(value = "/initiate",
			consumes = MediaType.APPLICATION_JSON_VALUE,
			produces = MediaType.APPLICATION_JSON_VALUE,
			method = RequestMethod.POST)
	public void response(@RequestBody ProfileRequestJson profileRequestJson){
		List<ProfileRequestJson> userlist = new ArrayList<>();
		userlist.add(profileRequestJson);
		
		User user = null;
		HealthPreference healthPreference = null;
		for(ProfileRequestJson prof: userlist){
			user = new User();
			healthPreference = new HealthPreference();
			user.setLastname(prof.getLastname());
			user.setFirstname(prof.getFirstname());
			user.setEmail(prof.getEmail());
			user.setGender(prof.getGender());
			user.setAge(prof.getAge());
			
			healthPreference.setActivity_level(prof.getActivitylevel());
			healthPreference.setHeight(prof.getHeight());
			healthPreference.setWeight(prof.getWeight());
			healthPreference.setUser(user);
		}
		
		userDao.create(user);
		User check = userDao.show(1);
		if(check != null){
			healthPreferenceDao.create(healthPreference);
		}
		
		System.out.println(user.getFirstname());
		System.out.println(user.getLastname());
		
//		return  profileService.generateResponse(profileRequestJson);
	}
}