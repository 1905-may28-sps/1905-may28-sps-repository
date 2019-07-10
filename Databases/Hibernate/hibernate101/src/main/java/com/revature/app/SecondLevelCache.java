package com.revature.app;

/*
 * Second-level cache is SessionFactory-scoped, meaning 
 * it is shared by all sessions created with the same 
 * session factory. When an entity instance is looked up 
 * by its id (either by application logic or by Hibernate 
 * internally, e.g. when it loads associations to that 
 * entity from other entities), and if second-level 
 * caching is enabled for that entity, the following happens:
 * - If an instance is already present in the first-level 
 * cache, it is returned from there
 * - If an instance is not found in the first-level cache, 
 * and the corresponding instance state is cached in the 
 * second-level cache, then the data is fetched from there 
 * and an instance is assembled and returned
 * - Otherwise, the necessary data are loaded from the 
 * database and an instance is assembled and returned
 * 
 * In order to use L2 cache, we must use a cache provider
 * A common provider is Ehcache
 * <dependency>
		<groupId>org.hibernate</groupId>
		<artifactId>hibernate-ehcache</artifactId>
		<version>5.2.2.Final</version>
	</dependency>
 * Must then enable L2 cache in your hibernate.cfg.xml 
 * 
 * then create a ehcache.xml configuring cache details 
 * 
 * Lastly, we must annotate all classes with @Cacheable
 */

public class SecondLevelCache {

}
