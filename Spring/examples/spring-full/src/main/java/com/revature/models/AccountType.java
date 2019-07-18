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
@Table(name="BANK_ACC_TYPE")
public class AccountType {
	
	@Id
	@Column(name="TYPE_ID")
	@SequenceGenerator(name="TYPE_ID_GEN", sequenceName="B_TYPE_ID", allocationSize=1)
	@GeneratedValue(generator="TYPE_ID_GEN", strategy=GenerationType.SEQUENCE)
	private int id;
	
	@Column(name="ACC_TYPE", unique=true, nullable=false)
	private String type;
	
	public AccountType() {}

	public AccountType(String type) {
		super();
		this.type = type;
	}

	public AccountType(int id, String type) {
		super();
		this.id = id;
		this.type = type;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
	
	

}