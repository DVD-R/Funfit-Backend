package com.funfit.usjr.thesis.backend;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ViewController {

	@RequestMapping(value = "/")
	public ModelAndView blankpage1() {
		ModelAndView model = new ModelAndView();
		model.setViewName("index");
		return model;
	}
	
	@RequestMapping(value = "home")
	public ModelAndView backToHome(){
		ModelAndView model = new ModelAndView();
		model.setViewName("index");
		return model;
	}
	
	@RequestMapping(value = "login")
	public ModelAndView login(){
		ModelAndView model = new ModelAndView();
		model.setViewName("login");
		return model;
	}
	
	@RequestMapping(value ="/loginTransaction", method = RequestMethod.GET)
	public void loginTransaction(@RequestParam(value = "username") String username,
								 @RequestParam(value = "password") String password){
	
		System.out.println("Username: "+ username);
		System.out.println("Password: "+ password);
	}

	
	@RequestMapping(value ="signup")
	public ModelAndView signup(){
		ModelAndView model = new ModelAndView();
		model.setViewName("signup");
		return model;
	}
	
	@RequestMapping(value ="/signupTransaction", method = RequestMethod.GET)
	public void signupTransaction(@RequestParam(value = "username") String username,
							 @RequestParam(value = "password") String password,
							 @RequestParam(value = "confirmPassword") String confirmPassword,
							 @RequestParam(value = "email") String email){
		
		System.out.println("Username: "+ username);
		System.out.println("Password: "+ password);
		System.out.println("Confirm Password: "+ confirmPassword);
		System.out.println("Email: "+ email);
		
	}
	
	
	@RequestMapping(value ="dashboard")
	public ModelAndView redirectToDashboard(){
		ModelAndView model = new ModelAndView();
		model.setViewName("dashboard");
		return model;
	}
}