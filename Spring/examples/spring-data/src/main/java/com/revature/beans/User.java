package com.revature.beans;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Component //registers this class as a spring bean
@Entity //registers a class as an entity(table) in DB
@Table(name="BLOG_USERS")
public class User {
	
	@Id //necessary for Hibernate to identify objects uniquely
	@Column(name="USER_ID")
	//More on @SequenceGenerator at: https://docs.oracle.com/javaee/5/api/javax/persistence/SequenceGenerator.html
	//name(required), optional: allocationSize, initialValue, sequenceName
	@SequenceGenerator(name="U_SEQ_GEN", sequenceName="U_SEQ", allocationSize=1)
	//more on @GeneratedValue at https://www.objectdb.com/java/jpa/entity/generated
	@GeneratedValue(generator="U_SEQ_GEN", strategy=GenerationType.SEQUENCE)
	private int id;
	
	//change name of col and apply constraints
	//@Column attributes can be found at https://docs.jboss.org/hibernate/jpa/2.1/api/javax/persistence/Column.html
	@Column(nullable=false, unique=true)
	private String username;
	
	@Column(nullable=false)
	private String password;
	
	@ManyToMany(cascade=CascadeType.ALL, fetch=FetchType.EAGER)
	//@JoinTable is used to define the join/junction table
	@JoinTable(name="Following",
	//specify thhe column with the main entity below
	joinColumns=@JoinColumn(name="USER_ID"),
	//inverse side of the relationship below
	inverseJoinColumns=@JoinColumn(name="FOLLOWING_ID"))
	private Set<User> following = new HashSet<User>();
	
	/*
	 * we CAN but do not need to bidirectionally map this relationship
	 * mapped by refers to the collection on the inverse side of the
	 * relationship 
	 */
	@ManyToMany(mappedBy="following")
	private Set<User> followers = new HashSet<User>();
	
	public User() {}
	
	public User(String username, String password) {
		super();
		this.username = username;
		this.password = password;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	

	public Set<User> getFollowing() {
		return following;
	}

	public void setFollowing(Set<User> following) {
		this.following = following;
	}
	

	public Set<User> getFollowers() {
		return followers;
	}

	public void setFollowers(Set<User> followers) {
		this.followers = followers;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", username=" + username + ", password=" + password + "]";
	}


}
