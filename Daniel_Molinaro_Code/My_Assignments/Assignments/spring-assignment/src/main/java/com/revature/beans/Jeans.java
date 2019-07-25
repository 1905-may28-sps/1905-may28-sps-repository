package com.revature.beans;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

import org.springframework.stereotype.Component;

@Component
@Entity
public class Jeans {
	
	@Id
	@SequenceGenerator(name="jeans_seq_gen", sequenceName="jeans_seq", allocationSize=1, initialValue=20)
	@GeneratedValue(generator="jeans_seq_gen", strategy=GenerationType.SEQUENCE)
	private int id;
	private String brand;
	private int styleNumber;
	private String fit;

	public Jeans() {}

	public Jeans(int id, String brand, int styleNumber, String fit) {
		super();
		this.id = id;
		this.brand = brand;
		this.styleNumber = styleNumber;
		this.fit = fit;
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

	public int getStyleNumber() {
		return styleNumber;
	}

	public void setStyleNumber(int styleNumber) {
		this.styleNumber = styleNumber;
	}

	public String getFit() {
		return fit;
	}

	public void setFit(String fit) {
		this.fit = fit;
	}

	

}