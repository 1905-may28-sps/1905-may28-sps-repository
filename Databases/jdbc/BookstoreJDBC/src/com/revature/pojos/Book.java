package com.revature.pojos;

public class Book {
	
	private int id;
	private String title;
	private String isbn;
	private double price;
	private int genre;
	
	public Book() {}
	
	public Book(String title, String isbn, double price, int genre) {
		super();
		this.title = title;
		this.isbn = isbn;
		this.price = price;
		this.genre = genre;
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
	public void setTitle(String title) {
		this.title = title;
	}
	public String getIsbn() {
		return isbn;
	}
	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public int getGenre() {
		return genre;
	}
	public void setGenre(int genre) {
		this.genre = genre;
	}
	@Override
	public String toString() {
		return "Book [id=" + id + ", title=" + title + ", isbn=" + isbn + ", price=" + price + ", genre=" + genre + "]";
	}
	
	
	

}
