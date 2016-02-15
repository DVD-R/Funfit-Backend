package com.funfit.usjr.thesis.backend.models;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name = "Event")
public class Event implements Serializable{

	@Id @GeneratedValue
	private int e_id;
	
	@Column(name = "eventName", nullable = false)
	private String eventName;
	
	@Column(name = "locationName", nullable = false)
	private String locationName;
	
	@Column(name = "latitude", nullable = false)
	private double latitude;
	
	@Column(name = "longitude", nullable = false)
	private double longitude;
	
	@Column(name = "eventDate", nullable = false)
	private Date eventDate;
	
	@Column(name = "promotionalImage", nullable = false)
	private String promotionalImage;
	
	@Column(name = "organizerId", nullable = false)
	private double organizerId;

	public Event(){}
	
	public Event(int e_id, String eventName, String locationName, double latitude, double longitude, Date eventDate,
			String promotionalImage, double organizerId) {
		super();
		this.e_id = e_id;
		this.eventName = eventName;
		this.locationName = locationName;
		this.latitude = latitude;
		this.longitude = longitude;
		this.eventDate = eventDate;
		this.promotionalImage = promotionalImage;
		this.organizerId = organizerId;
	}

	public int getId() {
		return e_id;
	}

	public void setId(int e_id) {
		this.e_id = e_id;
	}

	public String getEventName() {
		return eventName;
	}

	public void setEventName(String eventName) {
		this.eventName = eventName;
	}

	public String getLocationName() {
		return locationName;
	}

	public void setLocationName(String locationName) {
		this.locationName = locationName;
	}

	public double getLatitude() {
		return latitude;
	}

	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}

	public double getLongitude() {
		return longitude;
	}

	public void setLongitude(double longitude) {
		this.longitude = longitude;
	}

	public Date getEventDate() {
		return eventDate;
	}

	public void setEventDate(Date eventDate) {
		this.eventDate = eventDate;
	}

	public String getPromotionalImage() {
		return promotionalImage;
	}

	public void setPromotionalImage(String promotionalImage) {
		this.promotionalImage = promotionalImage;
	}

	public double getOrganizerId() {
		return organizerId;
	}

	public void setOrganizerId(int organizerId) {
		this.organizerId = organizerId;
	}
	
}
