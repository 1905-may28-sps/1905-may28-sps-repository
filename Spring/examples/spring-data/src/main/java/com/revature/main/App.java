package com.revature.main;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.revature.beans.Post;
import com.revature.beans.User;
import com.revature.repository.PostRepository;
import com.revature.repository.UserRepository;

public class App {
	
	static  ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
	static	UserRepository userRepo = (UserRepository) context.getBean(UserRepository.class);
	static	PostRepository postRepo = (PostRepository) context.getBean(PostRepository.class);

	public static void main(String[] args) {
		
		//User u = userRepo.findByUsernameLikeIgnoreCase("Revauser");
		System.out.println(userRepo.findByUsernameStartingWith("gen"));
		
		System.out.println(postRepo.findBySubjectContainingIgnoreCaseOrBodyContainingIgnoreCase("spring", "spring"));
	}
	
	static void doThings() {
		
		User u = new User("revaUser", "123");
		u = userRepo.save(u);
		
		Post p = new Post("Angular", "We build SPAs with Angular.", u);
		postRepo.save(p);
//		
//		List<User> users = userRepo.findAll();
//		System.out.println(users);
		System.out.println(userRepo.findOne(4)); //DO NOT USE GETONE()
//		
//		List<Post> posts = postRepo.findAll();
//		System.out.println(posts);
	}
}
