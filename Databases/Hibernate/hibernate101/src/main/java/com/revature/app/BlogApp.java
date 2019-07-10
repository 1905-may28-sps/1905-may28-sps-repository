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
		
	}
	
	
	static User login() {
		//log user in so that they can create posts
		return null;
	}
	
	static User register() {
		//register User so they can make posts 
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
