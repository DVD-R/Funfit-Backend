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
@Table(name = "Marker")
public class Marker implements Serializable{

	@Id @GeneratedValue
	private int id;
	
	@Column(name = "lat", nullable = false)
	private double lat;
	
	@Column(name = "lng", nullable = false)
	private double lng;
	
	@Column(name = "name", nullable = false)
	private String name;
	
	@Column(name = "lvl")
	private int lvl;
	
	@Column(name = "cluster_id")
	private int cluster_id;
	
	@Column(name = "cluster_name")
	private String cluster_name;

	public Marker(){}
	public Marker(int id, double lat, double lng, String name, int lvl, int cluster_id, String cluster_name) {
		super();
		this.id = id;
		this.lat = lat;
		this.lng = lng;
		this.name = name;
		this.lvl = lvl;
		this.cluster_id = cluster_id;
		this.cluster_name = cluster_name;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public double getLat() {
		return lat;
	}

	public void setLat(double lat) {
		this.lat = lat;
	}

	public double getLng() {
		return lng;
	}

	public void setLng(double lng) {
		this.lng = lng;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getLvl() {
		return lvl;
	}

	public void setLvl(int lvl) {
		this.lvl = lvl;
	}

	public int getFaction() {
		return cluster_id;
	}

	public void setFaction(int cluster_id) {
		this.cluster_id = cluster_id;
	}

	public String getCluster_name() {
		return cluster_name;
	}

	public void setCluster_name(String cluster_name) {
		this.cluster_name = cluster_name;
	}
	
	
}
