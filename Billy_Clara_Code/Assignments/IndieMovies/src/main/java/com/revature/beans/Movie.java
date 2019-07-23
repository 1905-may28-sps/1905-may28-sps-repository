package com.revature.beans;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;


//BASIC REQUIREMENTS FOR OUR BEAN

import org.springframework.stereotype.Component;

@Component
@Entity
public class Movie {
	
	@Id
	@SequenceGenerator(name="movie_gen", sequenceName="movie_seq", allocationSize=1, initialValue=20 )
	@GeneratedValue(generator="movie_gen", strategy=GenerationType.SEQUENCE)
	private int id;
	private String title;
	private String genre;
	private int year;
	
	public Movie() {}

	public Movie(int id, String title, String genre, int year) {
		super();
		this.id = id;
		this.title = title;
		this.genre = genre;
		this.year = year;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setName(String title) {
		this.title = title;
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	@Override
	public String toString() {
		return "Movie [id=" + id + ", name=" + title + ", genre=" + genre + ", year=" + year + "]";
	}
	
	

}
