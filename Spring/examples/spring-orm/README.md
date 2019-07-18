# Spring ORM
###### Spring's Object-Relational Mapping module. Used to abstract Java Persistence functionality. 

* Benefits:
	* Easier testing
	* less boiler plate code
	* easy transaction management 
	* all configuration is in beans.xml (there is no hibernate.cgf.xml)
* How does it work?
	* Spring ORM uses contextual sessions (sessions which exist within the application context) to configure our JPA tool (usually Hibernate) with the spring container. 
	* In order to do this, we wire a DataSource bean into a SessionFactory bean, which then gets wired into a TransactionManager bean and all of our DAOs

* `@Repository` annotation
	* Annotate DAOs with this, it indicates to the PerisstenceExceptionTransalationPostProcessor that exceptions thrown by your DAOs should be interpreted as Spring's data access exceptions. This gives us more details into what went wrong when an exception is thrown. 
* `@Transactional` annotation 
	* 
