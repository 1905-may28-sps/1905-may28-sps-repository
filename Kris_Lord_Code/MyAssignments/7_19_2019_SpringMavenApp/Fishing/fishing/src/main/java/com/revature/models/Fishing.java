package com.revature.models;

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
public class Fishing {

	@Id
	@Column(name="FISHID")
	@SequenceGenerator(name="FISHIDGEN", sequenceName="FISHFID", allocationSize=1)
	@GeneratedValue(generator="FISHIDGEN", strategy=GenerationType.SEQUENCE)
	private int id;
	
	@Column(nullable=false)
	private String bait;
	
	@Column(nullable=false)
	private String species;
	
	@Column(nullable=false)
	private int weight;
	
	@Column(nullable=false)
	private String locationCaught;
	
	public Fishing() {
		
	}
	
	public Fishing(int id, String bait, String species, int weight, String locationCaught) {
		super();
		this.id = id;
		this.bait = bait;
		this.species = species;
		this.weight = weight;
		this.locationCaught = locationCaught;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getBait() {
		return bait;
	}

	public void setBait(String bait) {
		this.bait = bait;
	}

	public String getSpecies() {
		return species;
	}

	public void setSpecies(String species) {
		this.species = species;
	}
	
	public int getWeight() {
		return weight;
	}

	public void setWeight(int weight) {
		this.weight = weight;
	}

	public String getLocationCaught() {
		return locationCaught;
	}

	public void setLocationCaught(String locationCaught) {
		this.locationCaught = locationCaught;
	}

	@Override
	public String toString() {
		return "Fishing [id=" + id + ", bait=" + bait + ", species=" + species + ", weight=" + weight + ", locationCaught=" + locationCaught
				+ "]";
	}
		
}
