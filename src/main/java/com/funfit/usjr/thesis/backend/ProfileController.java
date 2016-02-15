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

import com.funfit.usjr.thesis.backend.data.dao.service.FactionDao;
import com.funfit.usjr.thesis.backend.data.dao.service.HealthPreferenceDao;
import com.funfit.usjr.thesis.backend.data.dao.service.ImpulseDao;
import com.funfit.usjr.thesis.backend.data.dao.service.UserDao;
import com.funfit.usjr.thesis.backend.data.dao.service.VelocityDao;
import com.funfit.usjr.thesis.backend.models.Faction;
import com.funfit.usjr.thesis.backend.models.HealthPreference;
import com.funfit.usjr.thesis.backend.models.Impulse;
import com.funfit.usjr.thesis.backend.models.ProfileRequestJson;
import com.funfit.usjr.thesis.backend.models.Rdi;
import com.funfit.usjr.thesis.backend.models.User;
import com.funfit.usjr.thesis.backend.models.Velocity;
import com.funfit.usjr.thesis.backend.service.NotificationService;
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
	
	@Autowired
	FactionDao factionDao;
	
	@Autowired
	NotificationService notificationService;
	
	@Autowired
	private VelocityDao velocityDao;
	
	@Autowired
	private ImpulseDao impulseDao;

	@RequestMapping(value = "/initiate",
			consumes = MediaType.APPLICATION_JSON_VALUE,
			produces = MediaType.APPLICATION_JSON_VALUE,
			method = RequestMethod.POST)
	public @ResponseBody List<Rdi> response(@RequestBody ProfileRequestJson profileRequestJson){
		List<ProfileRequestJson> userlist = new ArrayList<>();
		userlist.add(profileRequestJson);
	
		
		User user = null;
		HealthPreference healthPreference = null;
		Faction faction = null;
		List<Velocity> v = velocityDao.index();
		List<Impulse> i = impulseDao.index();
		Velocity velocity = null;
		Impulse impulse = null;
		
		for(Velocity vl: v){
		velocity = new Velocity();	
		velocity.setId(vl.getId());
		velocity.setClusterName(vl.getClusterName());
		}
		
		for(Impulse imp: i){
			impulse = new Impulse();
			impulse.setId(imp.getId());
			impulse.setClusterName(imp.getClusterName());
		}

		
		for(ProfileRequestJson prof: userlist){
			user = new User();
			faction = new Faction();
		
			healthPreference = new HealthPreference();
			user.setId(prof.getId());
			user.setLastname(prof.getLastname());
			user.setFirstname(prof.getFirstname());
			user.setEmail(prof.getEmail());
			user.setGender(prof.getGender());
			user.setAge(prof.getAge());
			
			//HEALTHPREFERCED TRANSACTIONS
			healthPreference.setActivity_level(prof.getActivitylevel());
			healthPreference.setHeight(prof.getHeight());
			healthPreference.setWeight(prof.getWeight());
			healthPreference.setUser(user);
			
			if(prof.getFaction_description().equals("velocity")){
				faction.setUser(prof.getId());
				faction.setFaction_description(prof.getFaction_description());
				faction.setVelocity(velocity);
			}else if(prof.getFaction_description().equals("impulse")){
				faction.setUser(profileRequestJson.getId());
				faction.setFaction_description(prof.getFaction_description());
				faction.setImpulse(impulse);	
			}
		}
		User checking = userDao.showUser(profileRequestJson.getId());
		
		userDao.create(user);
		if(checking == null){
			healthPreferenceDao.create(healthPreference);
			factionDao.create(faction);
		}
		
		System.out.println(user.getFirstname());
		System.out.println(user.getLastname());
	
		Faction f = factionDao.query(profileRequestJson.getId());
		
		return  profileService.generateResponse(profileRequestJson , f.getId());
	}
	
	@RequestMapping(value = "/notification", method = RequestMethod.GET)
	public void pushNotification(){
		System.out.println("HELLO WORLD");

		List<String> deviceId = new ArrayList<>();
		deviceId.add("APA91bHXvT-J1X4bQIbZhJI0LB1ZPQdUneWW4rFjSF2QAzHwSDYDV6QYn-nOQZYZJSUhT1xi69XWYFiA_jqw4SSjSk82qT88lGywFWi-Snx8ZwWp2dDHH8xH0umZk8QbawhALuv1xmAC9x1VG1LEb-I-OfXZBkZDZA");
		try {
			notificationService.write(deviceId);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println(e);
		}
	}
	
}