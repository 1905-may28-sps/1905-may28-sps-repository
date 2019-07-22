# What is Spring Boot?

Spring Boot is a Spring project that takes the approach of Convention over Configuration. It makes it easy to create standalone Spring-based applications and integrates any of the other Spring projects like Web, Security, AOP, and more.

Spring Boot approaches projects with a biased view of the dependencies on your classpath and attempts to automatically configure those dependencies based on common usage. For instance, if your project includes “spring-boot-starter-web” dependencies, then Spring Boot will attempt to configure Spring MVC components like the DispatcherServlet, InternalViewResolver, DefaultHandlerMapper, and an embedded Tomcat servlet container.

### Benefits of using Spring Boot
Auto-configuration
The most glaring perk of using Spring Boot is the auto-configuration mechanism which is enabled by the annotation @SpringBootApplication. 
The @SpringBootApplication annotation includes three other annotations which make the magic happen, @SpringBootConfiguration, @EnableAutoConfiguration, and @ComponentScan. 

### Dependency Management
Next would be the “starter” dependencies and the “starter parent”. These build dependencies simplify the work it takes to gather the dependencies for your projects. Here are the “spring-boot-starter-web” starter dependencies:




By simply including “spring-boot-starter-web” in your Maven or Gradle dependencies, you will also get the other dependencies necessary for a Spring Boot Web application. 

So what is a Spring Boot Starter?
Dependency management is a critical aspect of any complex project… so why not automate it? Spring Boot starters were built to address exactly this problem. Starter POMs are a set of convenient dependency descriptors that you can include in your application. You get a "one stop shop" for all the Spring and related technology that you need, without having to hunt through sample code and copy and paste loads of dependency descriptors. There are more than 30 available, including web (develop REST services), test (includes Spring Test, Junit, Hamcrest, and Mockito), the Data JPA starter(persistence, to be talked about more when using Spring Data), and mail (hides the complexity of dealing with the Java Mail API)
-Source: Baeldung

### Spring Boot CLI
Lastly, the Spring Boot CLI adds useful commands including support for running groovy scripts. It can also help with other tasks during application development.
* How does Auto-configuration work?
There is a lot of work that happens in the background when it comes to auto-configuration, but here is a short synopsis. 
	• Spring Boot will scan your application’s classpath looking for registered dependencies and according to those dependencies it can make a best guess effort on how to configure those dependencies to work based on the bias of common use. 
	• For instance, if you have “spring-boot-starter-data-jpa” Spring boot makes the effort to configure Hibernate as the application’s ORM, and it will also attempt to find a JDBC driver on the classpath and attempt to add that to Hibernate’s configuration. 

Spring Boot also allows you to override most of its auto-configuration. In the previous example, we could customize our data-jpa instance to use proper database connection credentials, driver, dialect, and any other desirable properties. This can be done in multiple ways (applications.properties, Java Configuration, and in some instances XML/YAML/JSON)


##### Important Note
It is important to note that Spring Boot, by default, builds applications as jar files regardless of application type. This is significant when it comes to Java web applications because Spring boot also configures an embedded Tomcat Servlet Container to start at runtime and automatically deploys the application to that instance of Tomcat that is running intrinsically to the application. 

Spring Boot web applications, however, can also be built as wars and deployed to a pre-installed Tomcat webserver.





