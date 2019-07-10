package com.revature.app;

import java.util.Scanner;

import com.revature.data.PostDao;
import com.revature.data.UserDao;
import com.revature.model.Post;
import com.revature.model.User;

public class BlogApp {
	
	static UserDao uDao = new UserDao();
	static PostDao pDao = new PostDao();
	static Scanner scanner = new Scanner(System.in);
	
	public static void main(String[] args) {
		
		System.out.println("Welcome to RevaBlogs!!!!! What would you like to do today?");
		welcome();
	}
	
	static void welcome() {
		System.out.println("Press 1 to login or 2 to register an account");
		try{
			int id = Integer.parseInt(scanner.nextLine());
			switch(id) {
			case 1: login(); break;
			case 2: register(); break;
			default: System.out.println("Please enter either 1 or 2"); welcome(); break;
			}
		}catch(NumberFormatException e) {
			System.out.println("Please enter a valid number");
			welcome();
		}
	}
	
	static void menu() {
		//1. login. 2. register 
		//view your posts 
		//create new posts
		
	}
	
	static void test() {
		
	}
	
	
	static User login() {
		System.out.println("Please enter your username");
		String username = scanner.nextLine();
		User u = uDao.getByUsername(username);
		System.out.println("Please enter your password");
		String pass = scanner.nextLine();
		if(u != null && u.getPassword().equals(pass)) {
			//logged in
		}else {
			//not logged in
		}
		return null;
	}
	
	static User register() {
		System.out.println("Please enter your new username");
		return null;
	}
	
	static Post writePost(User loggedUser) {
		System.out.println("What subject are you writing about?");
		String subj = scanner.nextLine();
		System.out.println("Write your post:");
		String post = scanner.nextLine();
		Post p = new Post(subj, post, loggedUser);
		p = pDao.save(p);
		return p;
	}

}
