package com.revature.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.revature.beans.User;


/*
 * @Service is a specialization of @Component
 * It can only be applied to classes
 * It is used to mark the class as a service provider
 */
@Service
public class UserService {
	
	/*
	 * If this was a real service(was used to persist data to db),
	 * here is where we would autowire our DAO as follows
	 * 
	 * @Autowired
	 * UserRepository userRepo;
	 * 
	 * Then we would be able to use methods of our dao in this class
	 * 
	 * but instead, just to learn about rest controllers, we will 
	 * make a static arraylist of users
	 */
	
	private static List<User> users = new ArrayList<User>();
	private static int lastId = 3;
	static {
		users.add(new User(1, "Genesis", "123"));
		users.add(new User(2, "testUser", "password"));
		users.add(new User(3, "ravisingh", "bossman12"));
	}
	
	public List<User> getAll(){
		return users;
	}
	
	public User save(User u) {
		u.setId(++lastId);
		users.add(u);
		return u;
	}

}
