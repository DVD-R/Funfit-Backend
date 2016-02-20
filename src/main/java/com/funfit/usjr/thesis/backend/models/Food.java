package com.funfit.usjr.thesis.backend.models;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "food")
public class Food implements Serializable{

	@Id @GeneratedValue
	@Column(name = "id")
	private int id;
	
	@ManyToOne
	@JoinColumn(name = "user_id", referencedColumnName = "id")
	private Users user;
	
	@Column(name = "food_name", nullable = false)
	private String food_name;
	
	@Column(name = "calcium", nullable = false)
	private  String calcium;

	@Column(name = "calories", nullable = false)
	private  String calories;

	@Column(name = "carbohydrate", nullable = false)
    private  String carbohydrate;

	@Column(name = "cholesterol", nullable = false)
    private  String cholesterol;

	@Column(name = "fat", nullable = false)
    private  String fat;

	@Column(name = "fiber", nullable = false)
    private  String fiber;

	@Column(name = "iron", nullable = false)
    private  String iron;

	@Column(name = "measurement_description", nullable = false)
    private  String measurement_description;

	@Column(name = "metric_serving_amount", nullable = false)
    private  String metric_serving_amount;

	@Column(name = "metric_serving_unit", nullable = false)
    private  String metric_serving_unit;

	@Column(name = "monounsaturated_fat", nullable = false)
    private  String monounsaturated_fat;

	@Column(name = "number_of_units", nullable = false)
    private  String number_of_units;

	@Column(name = "polyunsaturated_fat", nullable = false)
    private  String polyunsaturated_fat;

	@Column(name = "potassium", nullable = false)
    private  String potassium;

	@Column(name = "protein", nullable = false)
    private  String protein;

	@Column(name = "saturated_fat", nullable = false)
    private  String saturated_fat;

	@Column(name = "serving_description", nullable = false)
    private  String serving_description;

	@Column(name = "serving_id", nullable = false)
    private  String serving_id;

	@Column(name = "sodium", nullable = false)
    private  String sodium;

	@Column(name = "sugar", nullable = false)
    private  String sugar;

	@Column(name = "trans_fat", nullable = false)
    private  String trans_fat;

	@Column(name = "vitamin_a", nullable = false)
    private  String vitamin_a;

	@Column(name = "vitamin_c", nullable = false)
    private  String vitamin_c;

	public Food(){}
	
	public Food(int id, Users user, String food_name, String calcium, String calories, String carbohydrate,
			String cholesterol, String fat, String fiber, String iron, String measurement_description,
			String metric_serving_amount, String metric_serving_unit, String monounsaturated_fat,
			String number_of_units, String polyunsaturated_fat, String potassium, String protein, String saturated_fat,
			String serving_description, String serving_id, String sodium, String sugar, String trans_fat,
			String vitamin_a, String vitamin_c) {
		super();
		this.id = id;
		this.user = user;
		this.food_name = food_name;
		this.calcium = calcium;
		this.calories = calories;
		this.carbohydrate = carbohydrate;
		this.cholesterol = cholesterol;
		this.fat = fat;
		this.fiber = fiber;
		this.iron = iron;
		this.measurement_description = measurement_description;
		this.metric_serving_amount = metric_serving_amount;
		this.metric_serving_unit = metric_serving_unit;
		this.monounsaturated_fat = monounsaturated_fat;
		this.number_of_units = number_of_units;
		this.polyunsaturated_fat = polyunsaturated_fat;
		this.potassium = potassium;
		this.protein = protein;
		this.saturated_fat = saturated_fat;
		this.serving_description = serving_description;
		this.serving_id = serving_id;
		this.sodium = sodium;
		this.sugar = sugar;
		this.trans_fat = trans_fat;
		this.vitamin_a = vitamin_a;
		this.vitamin_c = vitamin_c;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Users getUser() {
		return user;
	}

	public void setUser(Users user) {
		this.user = user;
	}

	public String getFood_name() {
		return food_name;
	}

	public void setFood_name(String food_name) {
		this.food_name = food_name;
	}

	public String getCalcium() {
		return calcium;
	}

	public void setCalcium(String calcium) {
		this.calcium = calcium;
	}

	public String getCalories() {
		return calories;
	}

	public void setCalories(String calories) {
		this.calories = calories;
	}

	public String getCarbohydrate() {
		return carbohydrate;
	}

	public void setCarbohydrate(String carbohydrate) {
		this.carbohydrate = carbohydrate;
	}

	public String getCholesterol() {
		return cholesterol;
	}

	public void setCholesterol(String cholesterol) {
		this.cholesterol = cholesterol;
	}

	public String getFat() {
		return fat;
	}

	public void setFat(String fat) {
		this.fat = fat;
	}

	public String getFiber() {
		return fiber;
	}

	public void setFiber(String fiber) {
		this.fiber = fiber;
	}

	public String getIron() {
		return iron;
	}

	public void setIron(String iron) {
		this.iron = iron;
	}

	public String getMeasurement_description() {
		return measurement_description;
	}

	public void setMeasurement_description(String measurement_description) {
		this.measurement_description = measurement_description;
	}

	public String getMetric_serving_amount() {
		return metric_serving_amount;
	}

	public void setMetric_serving_amount(String metric_serving_amount) {
		this.metric_serving_amount = metric_serving_amount;
	}

	public String getMetric_serving_unit() {
		return metric_serving_unit;
	}

	public void setMetric_serving_unit(String metric_serving_unit) {
		this.metric_serving_unit = metric_serving_unit;
	}

	public String getMonounsaturated_fat() {
		return monounsaturated_fat;
	}

	public void setMonounsaturated_fat(String monounsaturated_fat) {
		this.monounsaturated_fat = monounsaturated_fat;
	}

	public String getNumber_of_units() {
		return number_of_units;
	}

	public void setNumber_of_units(String number_of_units) {
		this.number_of_units = number_of_units;
	}

	public String getPolyunsaturated_fat() {
		return polyunsaturated_fat;
	}

	public void setPolyunsaturated_fat(String polyunsaturated_fat) {
		this.polyunsaturated_fat = polyunsaturated_fat;
	}

	public String getPotassium() {
		return potassium;
	}

	public void setPotassium(String potassium) {
		this.potassium = potassium;
	}

	public String getProtein() {
		return protein;
	}

	public void setProtein(String protein) {
		this.protein = protein;
	}

	public String getSaturated_fat() {
		return saturated_fat;
	}

	public void setSaturated_fat(String saturated_fat) {
		this.saturated_fat = saturated_fat;
	}

	public String getServing_description() {
		return serving_description;
	}

	public void setServing_description(String serving_description) {
		this.serving_description = serving_description;
	}

	public String getServing_id() {
		return serving_id;
	}

	public void setServing_id(String serving_id) {
		this.serving_id = serving_id;
	}

	public String getSodium() {
		return sodium;
	}

	public void setSodium(String sodium) {
		this.sodium = sodium;
	}

	public String getSugar() {
		return sugar;
	}

	public void setSugar(String sugar) {
		this.sugar = sugar;
	}

	public String getTrans_fat() {
		return trans_fat;
	}

	public void setTrans_fat(String trans_fat) {
		this.trans_fat = trans_fat;
	}

	public String getVitamin_a() {
		return vitamin_a;
	}

	public void setVitamin_a(String vitamin_a) {
		this.vitamin_a = vitamin_a;
	}

	public String getVitamin_c() {
		return vitamin_c;
	}

	public void setVitamin_c(String vitamin_c) {
		this.vitamin_c = vitamin_c;
	}
	
	
}