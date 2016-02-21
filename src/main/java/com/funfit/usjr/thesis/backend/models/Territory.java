package com.funfit.usjr.thesis.backend.models;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "territory")
public class Territory implements Serializable{

	@Id
	@Column(name = "id")
	private int id;

	@ManyToOne
	@JoinColumn(name = "faction_id", referencedColumnName = "id")
	private Faction faction;
	
	@Column(name = "encoded_polyline", nullable = false)
	private String encoded_polyline;
	
	@Column(name = "status")
	private String status;
	
	@Column(name = "time_stamp")
	private Date time_stamp;

	@Column(name = "level")
	private int level;
	
	@Column(name = "faction_description")
	private String faction_description;
	
	public Territory(){}
	
	public Territory(int id, Faction faction, String encoded_polyline, String status, Date time_stamp, int level,String faction_description) {
		super();
		this.id = id;
		this.faction = faction;
		this.encoded_polyline = encoded_polyline;
		this.status = status;
		this.time_stamp = time_stamp;
		this.level = level;
		this.faction_description = faction_description;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Faction getFaction() {
		return faction;
	}

	public void setFaction(Faction faction) {
		this.faction = faction;
	}

	public String getEncoded_polyline() {
		return encoded_polyline;
	}

	public void setEncoded_polyline(String encoded_polyline) {
		this.encoded_polyline = encoded_polyline;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Date getTime_stamp() {
		return time_stamp;
	}

	public void setTime_stamp(Date time_stamp) {
		this.time_stamp = time_stamp;
	}

	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
	}

	public String getFaction_description() {
		return faction_description;
	}

	public void setFaction_description(String faction_description) {
		this.faction_description = faction_description;
	}	
	
}
