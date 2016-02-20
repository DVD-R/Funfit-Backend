package com.funfit.usjr.thesis.backend.models;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Participant")
public class Participant implements Serializable{

	@Id @GeneratedValue
	private int p_id;
	
	@ManyToOne
	@JoinColumn(name = "event_id", referencedColumnName = "e_id")
	private Event event;
	
	@ManyToOne
	@JoinColumn(name = "user_id", referencedColumnName = "id")
	private Users user;

	public Participant(int p_id, Event event, Users user) {
		super();
		this.p_id = p_id;
		this.event = event;
		this.user = user;
	}

	public int getP_id() {
		return p_id;
	}

	public void setP_id(int p_id) {
		this.p_id = p_id;
	}

	public Event getEvent() {
		return event;
	}

	public void setEvent(Event event) {
		this.event = event;
	}

	public Users getUser() {
		return user;
	}

	public void setUser(Users user) {
		this.user = user;
	}
	
}
