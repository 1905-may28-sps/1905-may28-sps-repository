package com.revature.soap;

import java.util.ArrayList;
import java.util.List;

import javax.jws.WebService;

@WebService(endpointInterface="com.revature.soap.ServiceEndpointInterface")
public class Service implements ServiceEndpointInterface{
	
	static List<String> data = new ArrayList<String>();
	static {
		data.add("hello SOAP world!");
		data.add("goodbye");
	}

	@Override
	public void addData(String str) {
		data.add(str);
	}

	@Override
	public List<String> readData() {
		return data;
	}

}
