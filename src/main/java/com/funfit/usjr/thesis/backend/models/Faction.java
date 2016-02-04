package com.funfit.usjr.thesis.backend.models;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "faction")
public class Faction implements Serializable{

	@Id	
	private int id;
	
	@ManyToOne
	@JoinColumn(name = "territory_id", referencedColumnName = "id")
	private Territory territory;
	
	@ManyToOne
	@JoinColumn(name = "user_id", referencedColumnName = "id")
	private User user;

	public Faction(){}
	
	public Faction(int id, Territory territory, User user) {
		super();
		this.id = id;
		this.territory = territory;
		this.user = user;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Territory getTerritory() {
		return territory;
	}

	public void setTerritory(Territory territory) {
		this.territory = territory;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
}