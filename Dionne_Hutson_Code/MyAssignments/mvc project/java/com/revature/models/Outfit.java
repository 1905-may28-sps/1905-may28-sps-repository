package com.revature.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

import org.springframework.stereotype.Component;

@Component
@Entity
public class Outfit {
	@Id
	@Column(name="OUTFIT_ID")
	@SequenceGenerator(name="O_ID_GEN", sequenceName="O_O_ID", allocationSize=1)
	@GeneratedValue(generator="O_ID_GEN", strategy=GenerationType.SEQUENCE)
	private int id;
	
	@Column(nullable=false, unique=true)
	private String name;
	
	@Column(nullable=true)
	private String top;
	
	@Column(nullable=true)
	private String bottom;
	
	@Column(nullable=true)
	private String shoe;
	
	@Column(nullable=true)
	private String acessories;
	
	@Column(nullable=true)
	private String other;
	
	@Column(nullable=true)
	private String weather;
	
	public Outfit() {}

	public Outfit(int id, String name, String top, String bottom, String shoe, String acessories, String other, String weather) {
		super();
		this.id = id;
		this.name=name;
		this.top = top;
		this.bottom = bottom;
		this.shoe = shoe;
		this.acessories = acessories;
		this.other = other;
		this.weather = weather;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTop() {
		return top;
	}

	public void setTop(String top) {
		this.top = top;
	}

	public String getBottom() {
		return bottom;
	}

	public void setBottom(String bottom) {
		this.bottom = bottom;
	}

	public String getShoe() {
		return shoe;
	}

	public void setShoe(String shoe) {
		this.shoe = shoe;
	}

	public String getAcessories() {
		return acessories;
	}

	public void setAcessories(String acessories) {
		this.acessories = acessories;
	}

	public String getOther() {
		return other;
	}

	public void setOther(String other) {
		this.other = other;
	}

	public String getWeather() {
		return weather;
	}

	public void setWeather(String weather) {
		this.weather = weather;
	}
	
	

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Outfit [id=" + id + ", name=" + name +", top=" + top + ", bottom=" + bottom + ", shoe=" + shoe + ", acessories="
				+ acessories + ", other=" + other + ", weather=" + weather + "]";
	}
	
	
	
	

}