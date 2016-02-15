package com.funfit.usjr.thesis.backend.models;

import java.io.Serializable;

public class RefurbishMarker implements Serializable{
	private String user_id;
	private String cluster_description;
	private int id;
	private int faction_id;
	
	public RefurbishMarker(){}

	public RefurbishMarker(String user_id, String cluster_description, int id, int faction_id) {
		super();
		this.user_id = user_id;
		this.cluster_description = cluster_description;
		this.id = id;
		this.faction_id = faction_id;
	}

	public String getUser_id() {
		return user_id;
	}

	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}

	public String getCluster_description() {
		return cluster_description;
	}

	public void setCluster_description(String cluster_description) {
		this.cluster_description = cluster_description;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getFaction_id() {
		return faction_id;
	}

	public void setFaction_id(int faction_id) {
		this.faction_id = faction_id;
	}	

	
}
