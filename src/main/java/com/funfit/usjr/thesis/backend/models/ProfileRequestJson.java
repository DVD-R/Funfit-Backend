package com.funfit.usjr.thesis.backend.models;

/**
 * 
 * @author victor
 *
 */
public class ProfileRequestJson{

	private String firstname;
	private String lastname;
	private int age;
	private String gender;
	private String activitylevel;
	private double weight;
	private double height;
	private String email;
	private String faction_description;
	public ProfileRequestJson(){}
	
	public ProfileRequestJson(String firstname, String lastname, int age, String gender, String activitylevel,
			double weight, double height, String email, String faction_description) {
		this.firstname = firstname;
		this.lastname = lastname;
		this.age = age;
		this.gender = gender;
		this.activitylevel = activitylevel;
		this.weight = weight;
		this.height = height;
		this.email = email;
		this.faction_description = faction_description;
	}

	
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
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

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getActivitylevel() {
		return activitylevel;
	}

	public void setActivitylevel(String activitylevel) {
		this.activitylevel = activitylevel;
	}

	public double getWeight() {
		return weight;
	}

	public void setWeight(double weight) {
		this.weight = weight;
	}

	public double getHeight() {
		return height;
	}

	public void setHeight(double height) {
		this.height = height;
	}
	
	

	public String getFaction_description() {
		return faction_description;
	}

	public void setFaction_description(String faction_description) {
		this.faction_description = faction_description;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((activitylevel == null) ? 0 : activitylevel.hashCode());
		result = prime * result + age;
		result = prime * result + ((firstname == null) ? 0 : firstname.hashCode());
		result = prime * result + ((gender == null) ? 0 : gender.hashCode());
		long temp;
		temp = Double.doubleToLongBits(height);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((lastname == null) ? 0 : lastname.hashCode());
		temp = Double.doubleToLongBits(weight);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ProfileRequestJson other = (ProfileRequestJson) obj;
		if (activitylevel == null) {
			if (other.activitylevel != null)
				return false;
		} else if (!activitylevel.equals(other.activitylevel))
			return false;
		if (age != other.age)
			return false;
		if (firstname == null) {
			if (other.firstname != null)
				return false;
		} else if (!firstname.equals(other.firstname))
			return false;
		if (gender == null) {
			if (other.gender != null)
				return false;
		} else if (!gender.equals(other.gender))
			return false;
		if (Double.doubleToLongBits(height) != Double.doubleToLongBits(other.height))
			return false;
		if (lastname == null) {
			if (other.lastname != null)
				return false;
		} else if (!lastname.equals(other.lastname))
			return false;
		if (Double.doubleToLongBits(weight) != Double.doubleToLongBits(other.weight))
			return false;
		return true;
	}
		
}