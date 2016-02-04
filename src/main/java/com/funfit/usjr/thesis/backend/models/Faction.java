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
@Table(name = "faction")
public class Faction implements Serializable{

	@Id	@GeneratedValue
	private int id;
	
	@Column(name = "faction_description")
	private String faction_description;
	
	@ManyToOne
	@JoinColumn(name = "territory_id", referencedColumnName = "id")
	private Territory territory;
	
	@ManyToOne
	@JoinColumn(name = "user_id", referencedColumnName = "id")
	private User user;

	public Faction(){}
	
	public Faction(int id, String faction_description, Territory territory, User user) {
		super();
		this.id = id;
		this.faction_description = faction_description;
		this.territory = territory;
		this.user = user;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	public String getFaction_description() {
		return faction_description;
	}

	public void setFaction_description(String faction_description) {
		this.faction_description = faction_description;
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