package com.funfit.usjr.thesis.backend.models;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "velocity")
public class Velocity implements Serializable{

	@Id @GeneratedValue
	@Column(name = "id")
	private long id;
	
	@Column(name = "clusterName")
	private String clusterName;

	public Velocity(){}
	
	public Velocity(long id, String clusterName) {
		super();
		this.id = id;
		this.clusterName = clusterName;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getClusterName() {
		return clusterName;
	}

	public void setClusterName(String clusterName) {
		this.clusterName = clusterName;
	}
	
}
