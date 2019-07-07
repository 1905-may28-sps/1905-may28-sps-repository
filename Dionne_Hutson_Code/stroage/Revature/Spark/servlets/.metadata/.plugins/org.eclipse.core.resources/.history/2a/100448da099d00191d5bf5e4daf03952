package com.revature.service;

import java.util.ArrayList;
import java.util.List;

import com.revature.pojo.User;

public class DummyUserService {
	static int idcount=4;
	private static List<User> users=new ArrayList<User>();
	static {
		users.add(new User(1, "gab12","123"));
		users.add(new User(2, "niconoflaw","pass"));
		users.add(new User(3, "kristhedoc","lord"));
		users.add(new User(4, "viji","kanban"));
		
	}
	public List<User> getAll(){
		return users;
		
	}
	public User addUser(User u) {
		u.setId(++idcount);
		users.add(u);
		return u;}
	public User getByUsername(String username) {
		for (User u:users) {
			if(u.getUsername().equalsIgnoreCase(username)) return u;
		}
		return null;
			
	
		
	}
	

}
