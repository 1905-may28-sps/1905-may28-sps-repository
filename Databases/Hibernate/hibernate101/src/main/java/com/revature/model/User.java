package com.revature.model;

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

/*
 * Mapping classes with annotations (classes can also be mapped with 
 * XML, but that is much less common)
 * 
 * Though we will see tons of annotations here, the only two 
 * that we need are 
 * @Entity 
 * @Id
 */

@Entity //registers a class as an entity(Table) in the DB
@Table(name="BLOG_USER") //allows us to name table, and apply other constraints
public class User {
	
	@Id //necessary for Hibernate to identify instances of this class uniquely
	@Column(name="USER_ID")
	//More on @SequenceGenerator at: https://docs.oracle.com/javaee/5/api/javax/persistence/SequenceGenerator.html
	//name(required), optional: allocationSize, initialValue, sequenceName
	@SequenceGenerator(name="USER_SEQ_GEN", sequenceName="B_U_SEQ", allocationSize=1)
	//more on @GeneratedValue at https://www.objectdb.com/java/jpa/entity/generated
	@GeneratedValue(generator="USER_SEQ_GEN", strategy=GenerationType.SEQUENCE)
	private int id;
	
	@Column(nullable=false, unique=true)
	private String username;
	
	@Column(nullable=false)
	private String password;
	
	@ManyToMany(fetch=FetchType.EAGER, cascade=CascadeType.ALL)
	@JoinTable(name="Following", //@JoinTable is used to define the join/junction table 
	joinColumns=@JoinColumn(name="USER_ID"), //specify the column of the main entity
	inverseJoinColumns=@JoinColumn(name="FOLLOWING")) // specify the inverse side of the relationship
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
