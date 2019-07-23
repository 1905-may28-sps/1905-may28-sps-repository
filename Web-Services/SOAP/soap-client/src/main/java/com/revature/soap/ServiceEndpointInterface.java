package com.revature.soap;

import javax.jws.WebService;

@WebService
public interface ServiceEndpointInterface {

	void addData(String str);
	String readData();
}
