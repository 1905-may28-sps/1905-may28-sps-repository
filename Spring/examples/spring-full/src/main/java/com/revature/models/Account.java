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
@Table(name="BANK_ACCOUNTS")
public class Account {
	
	@Id
	@Column(name="ACC_ID")
	@SequenceGenerator(name="ACC_ID_GEN", sequenceName="B_ACC_ID", allocationSize=1)
	@GeneratedValue(generator="ACC_ID_GEN", strategy=GenerationType.SEQUENCE)
	private int id;
	
	@Column(name="BALANCE", nullable=false)
	private double balance;
	
	@ManyToOne(cascade=CascadeType.ALL, fetch=FetchType.EAGER)
	@JoinColumn(name="ACC_TYPE")
	private AccountType type;
	
	@ManyToMany(cascade=CascadeType.ALL, fetch=FetchType.EAGER)
	@JoinTable(name="BANK_ACC_OWNERS", 
	joinColumns=@JoinColumn(name="ACC_ID"),
	inverseJoinColumns=@JoinColumn(name="U_ID"))
	private Set<User> owners;

	public Account() {}
	
	public Account(int id, double balance, AccountType type, Set<User> owners) {
		super();
		this.id = id;
		this.balance = balance;
		this.type = type;
		this.owners = owners;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	public AccountType getType() {
		return type;
	}

	public void setType(AccountType type) {
		this.type = type;
	}

	public Set<User> getOwners() {
		return owners;
	}

	public void setOwners(Set<User> owners) {
		this.owners = owners;
	}
	
	
}
	
