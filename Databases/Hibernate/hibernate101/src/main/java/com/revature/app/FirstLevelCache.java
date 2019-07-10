package com.revature.app;


/*
 * Exploring Caching in Hibernate
 * 
 * Caching is a facility provided by ORM frameworks which help 
 * users to get fast running web application, while help framework 
 * itself to reduce number of queries made to database in a single 
 * transaction. Hibernate achieves the second goal by implementing 
 * first level cache.
 * 
 * First level cache in hibernate is enabled by default and you 
 * do not need to do anything to get this functionality working. In 
 * fact, you can not disable it even forcefully.
 * 
 * Its easy to understand the first level cache if we understand 
 * the fact that it is associated with Session object. As we know 
 * session object is created on demand from session factory and it 
 * is lost, once the session is closed. Similarly, first level cache 
 * associated with session object is available only till session 
 * object is live. It is available to session object only and is not 
 * accessible to any other session object in any other part of application.
 */
public class FirstLevelCache {

}
