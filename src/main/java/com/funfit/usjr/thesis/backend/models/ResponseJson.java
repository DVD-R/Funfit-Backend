package com.funfit.usjr.thesis.backend.models;

import java.io.Serializable;

public class ResponseJson{

	private double rdi;
	private String encodePolyline;
	

	public ResponseJson(){		
	}

	public double getRdi() {
		return rdi;
	}

	public void setRdi(double rdi) {
		this.rdi = rdi;
	}

	public String getEncodePolyline() {
		return encodePolyline;
	}

	public void setEncodePolyline(String encodePolyline) {
		this.encodePolyline = encodePolyline;
	}		
}