package com.funfit.usjr.thesis.backend.utils;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import com.google.maps.model.LatLng;

public class CreatePolyline {

	private EncodePolyline encodePolyline;
	
	public CreatePolyline(){
		encodePolyline = new EncodePolyline();
	}
	
	public String create(ArrayList<LatLng> hp){
		
		
		 double oldlat=0;
		    double oldlon=0;
		    StringBuilder nb = new StringBuilder();
		    for(int i=0;i<hp.size();i++){
		    	LatLng temp = hp.get(i);

		        double p1 = temp.lat;
		        double p2 = temp.lng;
		        
		        if(Math.abs(p1-oldlat)>=0.00001){
		            String temp2 = encodePolyline.encode(p1-oldlat);
		            nb.append(temp2);
		        } else {
		            nb.append("?");
		        }
		        if(Math.abs(p2-oldlon)>=0.00001){
		            String temp2 = encodePolyline.encode(p2-oldlon);
		            nb.append(temp2);
		        } else {
		            nb.append("?");
		        }
		        oldlat = p1;
		        oldlon = p2;
		    }
		    
		    String temp = nb.toString();
		    
		    //Check temp for "*\*" pattern
		    Pattern pattern = Pattern.compile("\".*\\.*\"");
		    Matcher matcher = pattern.matcher(temp);
		    
		    while (matcher.find()) {
		        //Use matcher.start() and .end() to replace "\" with "\\"
		        temp = temp.substring(0, matcher.start()) + temp.substring(matcher.start(),matcher.end()).replaceAll("\\\\", "\\\\\\\\") + temp.substring(matcher.end());
		    }
		    
		    return temp;
	}
}
