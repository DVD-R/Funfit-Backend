package com.funfit.usjr.thesis.backend.service.impl;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.funfit.usjr.thesis.backend.service.NotificationService;
import com.google.android.gcm.server.Constants;
import com.google.android.gcm.server.Message;
import com.google.android.gcm.server.Message.Builder;
import com.google.android.gcm.server.MulticastResult;
import com.google.android.gcm.server.Result;
import com.google.android.gcm.server.Sender;

@Service("notificationService")
@Transactional
public class NotificationServiceImpl implements InitializingBean , NotificationService{
	
	
    /** Api Key to access GCM <should be externalised> */
    private String apiKey = "AIzaSyD2Ki9bOc_yj6NnwpDneNiqflBffgHiGaY";
    
	/** Message Sender. */
	private Sender sender;
	
	/** The message to sent. */
	private Message messageToSend;
	
	@Override
	public void afterPropertiesSet() throws Exception {
		// TODO Auto-generated method stub
		sender = new Sender(apiKey);
		Builder mb = new Message.Builder();
		// Used to eventually group messages and override previous sendings
		mb.collapseKey(String.valueOf(System.currentTimeMillis()));
		// DATA
		mb.addData("title", "Here is my notification Title");
		mb.addData("message", "GCM is now available.");
		// Custom extra param...
		mb.addData("productCode", "503");
		
		// Initialize message
		messageToSend = mb.build();
	}

public void broadcast(List<String> items) throws Exception {
		
		List<String> devices = new ArrayList<String>(items);
		List<Result> results;
		try {
			// message with single adressee
		    if (devices.size() == 1) {
		       System.out.println("Sending message to a single device");
		       // Retries are handled by spring-batch and no the sender
		       // But you can use : sender.send(messageToSend, devices.get(0), retryCount)
		       Result result = sender.sendNoRetry(messageToSend, devices.get(0));
		       results = Arrays.asList(result);
		    // muticasting
		    } else {
		       MulticastResult result = sender.sendNoRetry(messageToSend, devices);
		       results = result.getResults();
		       System.out.println("Multicasting message to a " + items.size() + " devices.");
		    }
		    
		    // analyze the results
		    for (int i = 0; i < devices.size(); i++) {
		        Result result = results.get(i);
		        if (result.getMessageId() != null) {
			       System.out.println("  --> Succesfully sent message to device #" + i);

		          String canonicalRegId = result.getCanonicalRegistrationId();
		          // Some token should be updated in database
		          if (canonicalRegId != null) {
		        	devices.set(i, canonicalRegId);
		        	// < HERE DO CALL TO UPDATE TOKEN DATABASE >
				       System.out.println("The device " + i + " has updated its its");

		            }
		        } else {
		          String error = result.getErrorCodeName();
		          if (Constants.ERROR_NOT_REGISTERED.equals(error)) {
				       System.out.println("App has been removed on device " + i + ", unregister");

		             // < HERE DO CALL TO UPDATE TOKEN DATABASE >
		          } else {
		            // HERE UPDATE REJECTED ITEMS.... 
				       System.out.println("  --> An error occured fo device " + i + " : " + error);

		          }
		        }
		     }
		    
		} catch(Exception e) {

			throw e;
		}
	}
	
}
