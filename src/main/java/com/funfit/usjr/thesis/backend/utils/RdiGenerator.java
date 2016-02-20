package com.funfit.usjr.thesis.backend.utils;

public class RdiGenerator {

	public RdiGenerator(){}
	
	public double equationForMen(double weight, double height, int age, String activityLevel){
		
		double BMR = 66.47 + (13.75 * weight) + (5.0 * height) - (6.75 * age);
		
		double RDI = 0;
		
		switch(activityLevel){
		case "sedentary":
			RDI = BMR * 1.2;
			break;
		case "low active":
			RDI = BMR * 1.375;
			break;
		case "active":
			RDI = BMR * 1.55;
			break;
		case "very active":
			RDI = BMR * 1.725;
			break;
		}
		return RDI;
	}
	
	public double equationForWoman(double weight, double height, int age , String activityLevel){
		
		double BMR = 665.09 + (9.56 * weight) + (1.84 * height) - (4.67 * age);
		double RDI = 0;
		
		switch(activityLevel){
		case "sedentary":
			RDI = BMR * 1.2;
			break;
		case "low active":
			RDI = BMR * 1.375;
			break;
		case "active":
			RDI = BMR * 1.55;
			break;
		case "very active":
			RDI = BMR * 1.725;
			break;
		}
		return RDI;
	}
}
