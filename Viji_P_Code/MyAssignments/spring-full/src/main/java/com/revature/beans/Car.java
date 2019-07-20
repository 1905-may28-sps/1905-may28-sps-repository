package com.revature.beans;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Component
@Entity
@Table
public class Car {
	
	@Id
	@Column(name="CAR_ID")
	@SequenceGenerator(name="car_seq_gen", sequenceName="car_seq", allocationSize=1, initialValue=20)
	@GeneratedValue(generator="car_seq_gen", strategy=GenerationType.SEQUENCE)
	private int id;
	
	@Column(name="CAR_BRAND", nullable=false)
	private String brand;
	
	@Column(name="YEAR_MADE", nullable=false)
	private int yearMade;
	
	public Car() {}

	public Car(int id, String brand, int yearMade) {
		super();
		this.id = id;
		this.brand = brand;
		this.yearMade = yearMade;
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

	public int getYearMade() {
		return yearMade;
	}

	public void setYearMade(int yearMade) {
		this.yearMade = yearMade;
	}

	@Override
	public String toString() {
		return "Car [id=" + id + ", brand=" + brand + ", yearMade=" + yearMade + "]";
	}
	
		
}
