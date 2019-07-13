package com.reavture.app;

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
		//1. login.
		/*
		System.out.println("welcome, please enter your username");
		String un = scanner.nextLine();
		
		System.out.println("now your password");
		String pw = scanner.nextLine();
		*/
		 //2. register 
		//view your posts 
		//create new posts
	}
	
	static void test() {
		
	}
	
	
	static User login() {
		return null;
		
	}
	
	static User register() {
		return null;
		
	}
	static Post writePost(User loggerUser) {
		System.out.println("What subject are you writing about?");
		String subj = scanner.nextLine();
		System.out.println("Write your post:");
		String post = scanner.nextLine();
		Post p = new Post(subj, post, loggerUser);
		p = pDao.save(p);
		return p;
	}
}
