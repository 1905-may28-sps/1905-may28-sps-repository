package com.revature.repository;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.revature.beans.User;

/*
 * @Transactional - we need this annotation to indicate
 * that the TX manager should be used here, and to manage
 * our transactions. This annotation can be applied to 
 * classes, as well as methods to provide more information
 * on how you want your transactions to be managed
 * 
 * @Repository - annotate classes at the persistence 
 * layer, which will act as a DB repository, but it is
 * not necessary
 */

@Transactional
@Repository
public class UserRepository {
	
	@Autowired
	SessionFactory hello;
	
	public User getById(int id) {
		return (User) hello.getCurrentSession().get(User.class, id); 
	}

}
