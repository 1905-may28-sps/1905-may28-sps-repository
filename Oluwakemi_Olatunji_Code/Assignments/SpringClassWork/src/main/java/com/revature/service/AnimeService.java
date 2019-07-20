package com.revature.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.revature.beans.Anime;

@Service 
public class AnimeService {

	private static List<Anime> anime = new ArrayList<Anime>();
	private static int lastId = 3;
	static {
		anime.add(new Anime(1,"Naruto", 500));
		anime.add(new Anime(2, "Bleach", 366));
		anime.add(new Anime(3, "One Bleach", 860 ));
	}
	
	public List<Anime> getAll(){
		return anime;
	}
	
	public Anime save(Anime a) {
		a.setId(++lastId);
		anime.add(a);
		return a;
	}
	
}
