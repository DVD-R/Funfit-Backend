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

	@Id @GeneratedValue
	@Column(name = "id")
	private int id;

	@ManyToOne
	@JoinColumn(name = "user_id", referencedColumnName = "id")
	private User user;
	
	@Column(name = "encoded_polyline", nullable = false)
	private String encoded_polyline;
	
	@Column(name = "status")
	private String status;
	
	@Column(name = "time_stamp")
	private Date time_stamp;

	public Territory(){}
	
	public Territory(int id, User user, String encoded_polyline, String status, Date time_stamp) {
		super();
		this.id = id;
		this.user = user;
		this.encoded_polyline = encoded_polyline;
		this.status = status;
		this.time_stamp = time_stamp;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
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
}
