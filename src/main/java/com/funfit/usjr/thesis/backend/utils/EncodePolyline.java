package com.funfit.usjr.thesis.backend.utils;

import java.util.ArrayList;

public class EncodePolyline {

	public EncodePolyline(){
	
	}
	
	public String encode(double latlong){
		
		 String poly;
		    int signNum = (int) Math.signum(latlong);
		    
		    int b = (int) Math.round(latlong*1e5);
		    ArrayList<Integer> ab = new ArrayList<>();
		    
		    //Left shift
		    b=b<<1;
		    
		    //Invert if negative
		    if(signNum<0){
		        b=~b;
		    }
		    
		    //Split into 5-bit chunks and reverse order
		    while(b>0){
		        ab.add(b % 32);
		        b=b>>5;
		    }
		    
		    //Convert to ASCII
		    StringBuilder nc4 = new StringBuilder();
		    for(int i=0;i<ab.size()-1;i++){
		        //Or with 0x20 and add 63
		        char c = (char) ((ab.get(i) | 0x20)+63);
		        nc4.append(c);
		    }
		    //Add 63 to last chunk
		    nc4.append((char) (ab.get(ab.size()-1)+63));
		    poly=nc4.toString();
		    
		    return poly;
	}
}
