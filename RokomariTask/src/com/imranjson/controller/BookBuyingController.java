package com.imranjson.controller;

import com.imranjson.model.BookStockModel;
import com.imranjson.model.UserModel;
import com.imranjson.service.BookStockService;

import java.util.List;
import java.util.Scanner;



public class BookBuyingController {
	
	private int id;
	private String bookName;
	private float price;
	UserModel logUserInfo;
	private BookStockModel bookObj;
	List<BookStockModel> bookList;
	Scanner scanner;
	String userInput;
	
	public void browseBook(UserModel logUser){
		
		if(logUser != null){
			this.logUserInfo = logUser;
		}
		
		BookStockService bookStockService = new BookStockService();
		this.bookList = bookStockService.bookList();
		for(BookStockModel book: this.bookList){		
			System.out.print(book.getBookName()+"\t");
		}
		System.out.println();
		System.out.println("Please Enter your Book name");
		scanner = new Scanner(System.in);
		this.userInput = scanner.nextLine();
		if(this.userInput != null){
			for(BookStockModel book: this.bookList){
				if(book.getBookName().equals(this.userInput)){
					this.bookObj = book;
				System.out.print("You Choice: "+book.getBookName()+" Book, What is price: "+book.getPrice()+" Do you wanto buy? Y"); 
				this.scanner = new Scanner(System.in);
				this.userInput = this.scanner.nextLine();
				if(this.userInput.toLowerCase().equals("y")){
					buyingBook();
				  }				
				}
			}
			
		}else{
			System.out.println("Invalid Input. Browse again? Press y");
			scanner = new Scanner(System.in);
			this.userInput = scanner.nextLine();
			if(this.userInput != null && this.userInput.toLowerCase().equals("y")){
				browseBook(this.logUserInfo);
			}
			
		}	
	}
	
	
	public void buyingBook(){
		
		if(this.bookObj.getPrice() <= this.logUserInfo.getBalance()){
			double bookPrice = bookObj.getPrice();
			double userBlance = logUserInfo.getBalance();
			
			Double changeMoney = userBlance - bookPrice;
			this.logUserInfo.setBalance(changeMoney);
			UpdateDataController dataCon = new UpdateDataController();
			System.out.println("Successfully Buyinc Completed. Your Blance now:"+changeMoney);
			dataCon.updateUserInof(this.logUserInfo);
			
		}else{
			System.out.println("Not Enought money....!");
		}
		
		
	}


	
}
