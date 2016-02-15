package com.funfit.usjr.thesis.backend.models;

import java.io.Serializable;

public class Rdi implements Serializable{
private double Rdi;
private int faction_id;

public Rdi(){}

public Rdi(double rdi, int faction_id) {
	super();
	Rdi = rdi;
	this.faction_id = faction_id;
}

public double getRdi() {
	return Rdi;
}

public void setRdi(double rdi) {
	Rdi = rdi;
}

public int getFaction_id() {
	return faction_id;
}

public void setFaction_id(int faction_id) {
	this.faction_id = faction_id;
}


}
