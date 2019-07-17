package com.revature.hello;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class DemoApp {
	
	/*
	 * Attribute : autowire
		Controls whether bean properties are "autowired". This is an 
 automagical process in which bean references don't need to be 
 coded explicitly in the XML bean definition file, but rather the 
 Spring container works out dependencies. The effective default is 
 "no". 
 	There are 4 modes:
		1. "no" The traditional Spring default. No 
 automagical wiring. Bean references must be defined in the XML 
 file via the <ref/> element (or "ref" attribute). We recommend this 
 in most cases as it makes documentation more explicit. Note that 
 this default mode also allows for annotation-driven autowiring, if 
 activated. "no" refers to externally driven autowiring only, not 
 affecting any autowiring demands that the bean class itself 
 expresses. 
 		2. "byName" Autowiring by property name. If a bean of 
 class Cat exposes a "dog" property, Spring will try to set this to 
 the value of the bean "dog" in the current container. If there is no 
 matching bean by name, nothing special happens. 
 		3. "byType" 
 Autowiring if there is exactly one bean of the property type in the 
 container. If there is more than one, a fatal error is raised, and you 
 cannot use byType autowiring for that bean. If there is none, 
 nothing special happens. 
 		4. "constructor" Analogous to "byType" 
 for constructor arguments. If there is not exactly one bean of the 
 constructor argument type in the bean factory, a fatal error is 
 raised. Note that explicit dependencies, i.e. "property" and 
 "constructor-arg" elements, always override autowiring. Note: This 
 attribute will not be inherited by child bean definitions. Hence, it 
 needs to be specified per concrete bean definition. It can be 
 shared through the 'default-autowire' attribute at the 'beans' level 
 and potentially inherited from outer 'beans' defaults in case of 
 nested 'beans' sections (e.g. with different profiles).
	 */
	
	public static void main(String[] args) {
	
//		ParentBean b = new ParentBean();
//		System.out.println(b.getDependency().getMessage());
		
		ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
		ParentBean pb = (ParentBean) context.getBean(ParentBean.class);
		System.out.println(pb.getDependency().getMessage());
		
	}
	
	static void exploringDI() {
		//The following instantiation uses the new keyword, and therefore does not rely on IoC
		HelloSpring spring = new HelloSpring();
		System.out.println(spring.getMessage());
		
		//If we want to use spring and leverage IoC and DI, we must leverage our AppContext
		ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
		HelloSpring hello = (HelloSpring) context.getBean("thisIsABean");
		System.out.println(hello.getMessage());
		
		HelloSpring anotherInstance = (HelloSpring) context.getBean(HelloSpring.class);
		System.out.println(anotherInstance.getMessage());
		
		hello.setMessage("changing instance method");
		
		System.out.println(anotherInstance.getMessage());
	}

}
