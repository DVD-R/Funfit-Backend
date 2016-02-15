package com.funfit.usjr.thesis.backend;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.funfit.usjr.thesis.backend.data.dao.service.AdminDao;
import com.funfit.usjr.thesis.backend.data.dao.service.EventDao;
import com.funfit.usjr.thesis.backend.data.dao.service.ImpulseDao;
import com.funfit.usjr.thesis.backend.data.dao.service.MarkerDao;
import com.funfit.usjr.thesis.backend.data.dao.service.VelocityDao;
import com.funfit.usjr.thesis.backend.models.Admin;
import com.funfit.usjr.thesis.backend.models.Event;
import com.funfit.usjr.thesis.backend.models.Impulse;
import com.funfit.usjr.thesis.backend.models.Marker;
import com.funfit.usjr.thesis.backend.models.Velocity;

@Controller
public class ViewController {

	@Autowired
	private VelocityDao velocityDao;
	
	@Autowired
	private ImpulseDao impulseDao;
	
	@Autowired
	private AdminDao adminDao;
	
	@Autowired
	private MarkerDao markerDao;
	
	@Autowired
	private EventDao eventDao;
	
	BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
	@RequestMapping(value = "/")
	public String blankpage1() {
			
		List<Velocity> velocityCount = velocityDao.index();
		if(velocityCount.size() == 0){
			Velocity velocity = new Velocity();
			velocity.setClusterName("velocity");
			velocityDao.create(velocity);
		}
		
		List<Impulse> impulseCount = impulseDao.index();
		if(impulseCount.size() == 0){
			Impulse impulse = new Impulse();
			impulse.setClusterName("impulse");
			impulseDao.create(impulse);
		}

		
		ModelAndView model = new ModelAndView();
		model.setViewName("index");
		return "index";
	}
	
	@RequestMapping(value = "home")
	public String backToHome(){
		ModelAndView model = new ModelAndView();
		model.setViewName("index");
		return "index";
	}
	
	@RequestMapping(value = "login", method = RequestMethod.GET)
	public String login(){
		ModelAndView model = new ModelAndView();
		
		model.setViewName("login");
		return "login";
	}
	
	@RequestMapping(value ="/loginTransaction", method = RequestMethod.GET)
	public String loginTransaction(@RequestParam(value = "username") String username,
								 @RequestParam(value = "password") String password){
	
		
		Admin a = adminDao.createQuery(username);
		
		boolean check = passwordEncoder.matches(password, a.getPassword());

		System.out.println(check);
		
		System.out.println("Username: "+ username);
		System.out.println("Password: "+ password);
		return "redirect:dashboard";
	}

	
	@RequestMapping(value ="signup")
	public String signup(){
		ModelAndView model = new ModelAndView();
		model.setViewName("signup");
		return "signup";
	}
	
	@RequestMapping(value ="/signupTransaction", method = RequestMethod.GET)
	public String signupTransaction(@RequestParam(value = "username") String username,
							 @RequestParam(value = "password") String password,
							 @RequestParam(value = "confirmPassword") String confirmPassword,
							 @RequestParam(value = "email") String email){
		
		String encryptedPassword = passwordEncoder.encode(password);
		
		Admin admin = new Admin();
		admin.setUsername(username);
		admin.setPassword(encryptedPassword);
		admin.setEmail(email);
		adminDao.create(admin);
		
		return "redirect:/login";
	}
	
	@RequestMapping(value = "/createMarker", method = RequestMethod.GET)
	public String createMarker(@RequestParam(value = "locationName") String locationName,
							   @RequestParam(value = "latitude") double latitude,
							   @RequestParam(value = "longitude") double longitude){
		
		
		Marker marker = new Marker();
		marker.setName(locationName);
		marker.setLat(latitude);
		marker.setLng(longitude);
		marker.setLvl(0);
		marker.setCluster_name(null);
		markerDao.create(marker);
		return "marker";
	}
	
	
	@RequestMapping(value = "/createEvent", method = RequestMethod.GET)
	public String createEvent(@RequestParam(value = "eventName") String eventName,
							  @RequestParam(value = "locationName") String locationName,
							  @RequestParam(value = "latitude") double latitude,
							  @RequestParam(value = "longitude") double longitude,
							  @RequestParam(value = "eventDate") Date eventDate,
							  @RequestParam(value = "promotionalImage") String promotionalImage){
		
		System.out.println(eventName);
		
		int organizerId = (int) Math.floor(System
				.currentTimeMillis() / 1000L);
		
		Event event = new Event();
		event.setEventName(eventName);
		event.setLocationName(locationName);
		event.setLatitude(latitude);
		event.setLongitude(longitude);
		event.setEventDate(eventDate);
		event.setPromotionalImage(promotionalImage);
		event.setOrganizerId(organizerId);
		eventDao.create(event);
		
		return "redirect:dashboard";
	}
	
	@RequestMapping(value ="dashboard")
	public String redirectToDashboard(){
		System.out.println("dashboard");

		return "dashboard";
	}
	
	@RequestMapping(value = "events", method = RequestMethod.GET)
	public String redirectEvents(){
		
		return "events";
	}
	
	@RequestMapping(value = "marker")
	public String redirectMarker(){
		return "marker";
	}
	
	@RequestMapping(value = "map")
	public String redirectMap(){
		return "map";
	}
}