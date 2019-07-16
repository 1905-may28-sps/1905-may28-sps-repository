# Introduction to [Spring](www.spring.io)


### Topics Covered:
* What is Spring
	* Java IoC framework used to build enterprise level applications 
	* Initially served as a simpler, lightweight alternative to standard J2EE development tools 
	* Provides a large number of helper classes, and tools to abstract standard functionality 
	* "Convention over configuration"
* Depencency Injection 
	* We can use XML or annotations to inject depenedencies in Spring. What exactly are depencencies you ask? Anything that an object has a "HAS-A" relationship with. 
		* ie. User object HAS A id, username, etc... we typically do not inject property values, although we can 
		* We typically inject beans into other beans, through a process called bean wiring. For example, a UserService class is dependent upon a UserRepository class. We will not programatically instantiate our User Repo (ie UserRepo repo = new UserRepo();), but instead we will simply declare 
the dependency and allow our container to manage its instantiation. 


### TO MAKE STANDARD SPRING APP:
* Build simple maven project with required jars
	* beans
	* context
	* core 
	* commons logging
* create spring bean configuration file (beans.xml) with the appropriate namespaces




### Important Annotations 
* `@Bean` - applied on a method to specify that it returns a bean to be managed by the Spring context. Spring Bean annotation is usually declared in Configuration class methods. 
* `@Component`
* `@Autowired`

