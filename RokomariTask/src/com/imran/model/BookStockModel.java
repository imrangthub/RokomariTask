package com.imran.model;

public class BookStockModel {
	
	private int id;
	private String bookName;
	private float price;
	
	public BookStockModel(){}
	
	
	public BookStockModel(int id, String bookName, float price) {
		super();
		this.id = id;
		this.bookName = bookName;
		this.price = price;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getBookName() {
		return bookName;
	}


	public void setBookName(String bookName) {
		this.bookName = bookName;
	}


	public float getPrice() {
		return price;
	}


	public void setPrice(float price) {
		this.price = price;
	}

	
	

}
