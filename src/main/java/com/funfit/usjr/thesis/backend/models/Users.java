package com.funfit.usjr.thesis.backend.models;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "users")
public class Users implements Serializable{

	@Id
	@Column(name = "id")
	private int id;

	@Column(name = "firstname", nullable = false)
	private String firstname;
	
	@Column(name = "lastname", nullable = false)
	private String lastname;
	
	@Column(name = "email", nullable = false)
	private String email;
	
	@Column(name = "gender", nullable = false)
	private String gender;

	@Column(name = "age", nullable = false)
	private int age;

	@Column(name = "gcmKey", nullable = false)
	private String gcmKey;
	
	public Users(){}
	
	public Users(int id, String firstname, String lastname, String email, String gender, int age, String gcmKey) {
		super();
		this.id = id;
		this.firstname = firstname;
		this.lastname = lastname;
		this.email = email;
		this.gender = gender;
		this.age = age;
		this.gcmKey = gcmKey;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}
		
	public String getGcmKey(){
		return gcmKey;
	}
	
	public void setGcmKey(String gcmKey){
		this.gcmKey = gcmKey;
	}
}
