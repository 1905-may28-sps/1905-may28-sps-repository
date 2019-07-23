package com.revature.soap;

import org.apache.cxf.jaxws.JaxWsProxyFactoryBean;

public class App {
	

	public static void main(String[] args) {
		//http://170.41.34.124:8081/....
		String url = "http://localhost:8081/soap-service/endpoint";
		
		JaxWsProxyFactoryBean beanFactory
			= new JaxWsProxyFactoryBean();
		beanFactory.setServiceClass(ServiceEndpointInterface.class);
		beanFactory.setAddress(url);
		
		//CONSUME!
		
		ServiceEndpointInterface service 
			 = (ServiceEndpointInterface) beanFactory.create();
		service.addData("this is happening again!!!!");
		
	}

}
