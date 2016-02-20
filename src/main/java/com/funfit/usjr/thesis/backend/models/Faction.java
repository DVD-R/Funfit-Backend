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

	@Id
	private int id;
	
	@Column(name = "faction_description")
	private String faction_description;
		
	
	
	@Column(name = "user_id")
	private int user_id;

	@ManyToOne
	@JoinColumn(name = "impulse_id", referencedColumnName = "id")
	private Impulse impulse;
	
	@ManyToOne
	@JoinColumn(name = "velocity_id", referencedColumnName = "id")
	private Velocity velocity;
	
	public Faction(){}

	public Faction(int id, String faction_description, int user_id, Impulse impulse, Velocity velocity) {
		super();
		this.id = id;
		this.faction_description = faction_description;
		this.user_id = user_id;
		this.impulse = impulse;
		this.velocity = velocity;
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

	public int getUser() {
		return user_id;
	}

	public void setUser(int user_id) {
		this.user_id = user_id;
	}

	public Impulse getImpulse() {
		return impulse;
	}

	public void setImpulse(Impulse impulse) {
		this.impulse = impulse;
	}

	public Velocity getVelocity() {
		return velocity;
	}

	public void setVelocity(Velocity velocity) {
		this.velocity = velocity;
	}
}