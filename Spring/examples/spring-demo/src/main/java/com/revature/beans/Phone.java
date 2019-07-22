package com.revature.beans;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

import org.springframework.stereotype.Component;

@Component
@Entity
public class Phone {
	
	@Id
	@SequenceGenerator(name="phone_seq_gen", sequenceName="phone_seq", allocationSize=1, initialValue=20)
	@GeneratedValue(generator="phone_seq_gen", strategy=GenerationType.SEQUENCE)
	private int id;
	private String brand;
	private String version;

	public Phone() {}

	public Phone(int id, String brand, String version) {
		super();
		this.id = id;
		this.brand = brand;
		this.version = version;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public String getVersion() {
		return version;
	}

	public void setVersion(String version) {
		this.version = version;
	}
	
	

}
