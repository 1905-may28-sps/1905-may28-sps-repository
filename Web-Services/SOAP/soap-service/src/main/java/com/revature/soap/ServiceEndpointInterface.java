package com.revature.soap;

import java.util.List;

import javax.jws.WebService;

/*
 * Service endpoint interface for our SOAP service
 * 
 * This interface and its functionality is what will 
 * be exposed through our SOAP service; we will 
 * consume its implemented functionality in our SOAP 
 * client. 
 */

@WebService
public interface ServiceEndpointInterface {
	
	void addData(String str);
	List<String> readData();

}
