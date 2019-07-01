package com.revature.service;

import java.util.ArrayList;
import java.util.List;

import com.revature.pojos.User;

public class DummyUserService {
	
	private static List<User> users = new ArrayList<User>();
	private static int idCount = 4;
	
	static {
		users.add(new User(1, "gab12", "123"));
		users.add(new User(2, "niconoflaw", "pass"));
		users.add(new User(3, "kristhagod", "lord"));
		users.add(new User(4, "viji", "kanban"));
	}
	
	public List<User> getAll(){
		return users;
	}
	
	public User addUser(User u) {
		u.setId(++idCount);
		users.add(u);
		return u;
	}
	
	public User getByUsername(String username) {
		for (User u : users) {
			if(u.getUsername().equalsIgnoreCase(username)) return u;
		}
		return null;
	}

}
