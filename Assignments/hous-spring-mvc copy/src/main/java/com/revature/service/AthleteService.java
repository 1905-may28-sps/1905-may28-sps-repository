package com.revature.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.revature.beans.Athlete;

@Service
public class AthleteService {
	
	private static List<Athlete> athletes = new ArrayList<Athlete>();
	
	static {
		athletes.add(new Athlete(1, "Michael", "Jordan", "BasketBall"));
		athletes.add(new Athlete(2, "Jerry", "Rice", "FootBall"));
		athletes.add(new Athlete(3, "Leonil", "Messi", "Soccer"));
		athletes.add(new Athlete(4, "Berry", "Bonds", "BaseBall"));
	}
	
	public List<Athlete> getAll(){
		return athletes;
	}
	

}
