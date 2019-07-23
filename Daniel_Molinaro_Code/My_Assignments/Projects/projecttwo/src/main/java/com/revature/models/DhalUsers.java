package com.revature.models;

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
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Component
@Entity
@Table(name="dhal_users")
public class DhalUsers {
	
	@Id
	@Column(name="user_id")
	@SequenceGenerator(name="dhal_users_trigger", sequenceName="dhal_users_seq", allocationSize=1)
	@GeneratedValue(generator="dhal_users_trigger", strategy=GenerationType.SEQUENCE)
	private int id;
	
	@Column(name="email", unique=true, nullable=false)
	private String email;
	
	@Column(name="password", nullable=false)
	private String password;
	
	@Column(name="first_name", nullable=false)
	private String firstName;
	
	@Column(name="last_name", nullable=false)
	private String lastName;
	
	@ManyToOne(cascade=CascadeType.ALL, fetch=FetchType.EAGER)
	@JoinColumn(name="author_id")
	private DhalComments authorId;
	
	
	@ManyToOne(cascade=CascadeType.ALL, fetch=FetchType.EAGER)
	@JoinColumn(name="rater_id")
	private DhalTrackRatings raterId;
	
	public DhalUsers() {}

	public DhalUsers(int id, String email, String password, String firstName, String lastName, DhalComments authorId,
			DhalTrackRatings raterId) {
		super();
		this.id = id;
		this.email = email;
		this.password = password;
		this.firstName = firstName;
		this.lastName = lastName;
		this.authorId = authorId;
		this.raterId = raterId;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public DhalComments getAuthorId() {
		return authorId;
	}

	public void setAuthorId(DhalComments authorId) {
		this.authorId = authorId;
	}

	public DhalTrackRatings getRaterId() {
		return raterId;
	}

	public void setRaterId(DhalTrackRatings raterId) {
		this.raterId = raterId;
	}
	
	
	

	
}