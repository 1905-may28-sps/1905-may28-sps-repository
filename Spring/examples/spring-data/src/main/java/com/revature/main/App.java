package com.revature.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.revature.repository.PostRepository;
import com.revature.repository.UserRepository;

public class App {

	public static void main(String[] args) {
		
		ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
		
		UserRepository userRepo = (UserRepository) context.getBean(UserRepository.class);
		PostRepository postRepo = (PostRepository) context.getBean(PostRepository.class);
		
		
		
	}
}
