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
import com.funfit.usjr.thesis.backend.models.Users;
import com.funfit.usjr.thesis.backend.models.Velocity;
import com.funfit.usjr.thesis.backend.service.GenerateIdService;
import com.funfit.usjr.thesis.backend.service.NotificationService;
import com.funfit.usjr.thesis.backend.service.ProfileService;

/**
 * 
 * @author victor
 *
 */
@Controller
public class ProfileController {
	
	private boolean flag2 = true;

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

	@Autowired
	private GenerateIdService generateIdService;
	
	@RequestMapping(value = "/initiate",
			consumes = MediaType.APPLICATION_JSON_VALUE,
			produces = MediaType.APPLICATION_JSON_VALUE,
			method = RequestMethod.POST)
	public @ResponseBody Rdi response(@RequestBody ProfileRequestJson profileRequestJson){
		System.out.println(profileRequestJson.getUserId());
		List<ProfileRequestJson> userlist = new ArrayList<>();
		userlist.add(profileRequestJson);
	
		
		Users user = null;
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
			user = new Users();
			faction = new Faction();
		
			healthPreference = new HealthPreference();
			user.setId(Integer.parseInt(prof.getUserId()));
			user.setLastname(prof.getLastname());
			user.setFirstname(prof.getFirstname());
			user.setEmail(prof.getEmail());
			user.setGender(prof.getGender());
			user.setAge(prof.getAge());
			user.setGcmKey(prof.getGcmKey());
			
			//HEALTHPREFERCED TRANSACTIONS
			healthPreference.setActivity_level(prof.getActivitylevel());
			healthPreference.setHeight(prof.getHeight());
			healthPreference.setWeight(prof.getWeight());
			healthPreference.setUser(user);
			
			if(prof.getFaction_description().equals("velocity")){
				faction.setId(generateIdService.generateId());
				faction.setUser(Integer.parseInt(prof.getUserId()));
				faction.setFaction_description(prof.getFaction_description());
				faction.setVelocity(velocity);
			}else if(prof.getFaction_description().equals("impulse")){
				faction.setId(generateIdService.generateId());
				faction.setUser(Integer.parseInt(profileRequestJson.getUserId()));
				faction.setFaction_description(prof.getFaction_description());
				faction.setImpulse(impulse);	
			}
		}
		Users checking = userDao.show(Integer.parseInt(profileRequestJson.getUserId()));
		boolean flag = userDao.checkEmail(profileRequestJson.getEmail());
	
		
		if(checking == null){
			userDao.create(user);
			healthPreferenceDao.create(healthPreference);
			factionDao.create(faction);
		}
		
		Faction f = factionDao.query(Integer.parseInt(profileRequestJson.getUserId()));
		
		return  profileService.generateResponse(profileRequestJson);
	}
	
	
	@RequestMapping(value = "/notification", method = RequestMethod.GET)
	public void pushNotification(){
		System.out.println("HELLO WORLD");

		List<String> deviceId = new ArrayList<>();
		deviceId.add("APA91bHXvT-J1X4bQIbZhJI0LB1ZPQdUneWW4rFjSF2QAzHwSDYDV6QYn-nOQZYZJSUhT1xi69XWYFiA_jqw4SSjSk82qT88lGywFWi-Snx8ZwWp2dDHH8xH0umZk8QbawhALuv1xmAC9x1VG1LEb-I-OfXZBkZDZA");
		try {
			notificationService.broadcast(deviceId);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println(e);
		}
	}
}