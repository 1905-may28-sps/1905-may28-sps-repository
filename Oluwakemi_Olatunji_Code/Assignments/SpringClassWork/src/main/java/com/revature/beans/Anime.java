package com.revature.beans;



import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import org.springframework.stereotype.Component;

@Component
public class Anime {
	
	
	@Min(value = 0)
	private int id;
	
	@NotNull
	@Pattern(regexp="[a-z-A-Z]*")
	private String mainCharacter;
	
	@NotNull
	private int numberOfEpisodes;
	
	public Anime () {}

	public Anime(int id, String mainCharacter, int numberOfEpisodes) {
		super();
		this.id = id;
		this.mainCharacter = mainCharacter;
		this.numberOfEpisodes = numberOfEpisodes;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getMainCharacter() {
		return mainCharacter;
	}

	public void setMainCharacter(String mainCharacter) {
		this.mainCharacter = mainCharacter;
	}

	public int getNumberOfEpisodes() {
		return numberOfEpisodes;
	}

	public void setNumberOfEpisodes(int numberOfEpisodes) {
		this.numberOfEpisodes = numberOfEpisodes;
	}

	@Override
	public String toString() {
		return "Anime [id=" + id + ", mainCharacter=" + mainCharacter + ", numberOfEpisodes=" + numberOfEpisodes + "]";
	}
	
	

}
