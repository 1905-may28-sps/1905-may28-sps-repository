package com.revature.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.revature.beans.Post;
import com.revature.beans.Reaction;
import com.revature.beans.ReactionComposite;
import com.revature.beans.ReactionType;
import com.revature.beans.User;
import com.revature.repository.PostRepository;
import com.revature.repository.ReactionRepository;
import com.revature.repository.ReactionTypeRepository;
import com.revature.repository.UserRepository;

public class App {
	
	static  ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
	static	UserRepository userRepo = (UserRepository) context.getBean(UserRepository.class);
	static	PostRepository postRepo = (PostRepository) context.getBean(PostRepository.class);
	static 	ReactionRepository reactionRepo = (ReactionRepository) context.getBean(ReactionRepository.class);
	static ReactionTypeRepository typeRepo = (ReactionTypeRepository) context.getBean(ReactionTypeRepository.class);
	
	public static void main(String[] args) {
		
	//	typeRepo.save(new ReactionType("https://upload.wikimedia.org/wikipedia/commons/thumb/e/e0/SNice.svg/220px-SNice.svg.png"));
		ReactionType type = typeRepo.findOne(1);

		Reaction r = new Reaction(new ReactionComposite(4, 24), type);
		reactionRepo.save(r);
		
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
