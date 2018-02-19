package com.imran.service;

import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

import com.imran.model.BookStockModel;
import com.imran.model.UserModel;

public class BookBuyingService {
	
	private String userInput;
	BookStockService bookStockService = new BookStockService();
	Scanner scanner = new Scanner(System.in);
	private List<BookStockModel> bookStockMapData;
	UserModel userModel;
	BookStockModel bookStock;
	boolean isEnoughMoney;
	boolean accountTransectionStatus;
	
	public void browsingUI(UserModel userModel){	
		if(userModel != null) this.userModel = userModel;
		System.out.println("Do you wanna See Book list to buy? Y/N");
		 this.userInput = scanner.nextLine();
		if(this.userInput.toLowerCase().equals("y")){
			bookStockMapData = bookStockService.bookStockList();
			for(BookStockModel bookStock : bookStockMapData){
				System.out.print(bookStock.getBookName()+"\t");
			}			
			System.out.println("\nPlease Enter Your book Name: ");
			 this.userInput = scanner.nextLine();
			 if(userInput != null){
				 bookBuyValidation(this.userInput); 
			 }
			 
			
		}
		
	}
	
	public void bookBuyValidation(String bookName){
		bookStockMapData = bookStockService.bookStockList();
		for(BookStockModel bookStock : bookStockMapData){
			if(bookName.toLowerCase().equals(bookStock.getBookName().toLowerCase())){
				this.bookStock = bookStock;
				System.out.print("You select:- "+bookStock.getBookName()+" What is price: "+bookStock.getPrice());
				System.out.print("Do you wann by? \nPlease press: y/n");
				 this.userInput = scanner.nextLine();
				 if(this.userInput.toLowerCase().equals("y")){
						this.isEnoughMoney = checkBlance(this.userModel.getBalance(), bookStock.getPrice());
					 if(this.isEnoughMoney){
						 bookBuy(this.userModel, this.bookStock);
					 }else{
							System.out.println("Buying Failed. Not Enough Money"); 
					 }
				 }
				
			}
			
		}
	}
	
	
	public boolean checkBlance(double blance, float amount){
		if(blance >= amount){
			this.isEnoughMoney = true;
		}	
		return this.isEnoughMoney;
	}
	
	
	public void bookBuy(UserModel userModel,BookStockModel bookStock){
		float bookPrice = bookStock.getPrice();
		float userBlance = (float)userModel.getBalance();
		float changeMoney = (userBlance - bookPrice);
		if(changeMoney>0){
			System.out.println("Successfully Buying completed. You Blance now: "+(userBlance - bookPrice));
			System.out.println("Your Change is: "+changeMoney);
		}else{
			System.out.println("Successfully Buying completed. You Blance now: "+(userBlance - bookPrice));	
		}
		System.out.println("Do you want to buy more ? Y / N");
		this.userInput = scanner.nextLine();
		if(userInput.toLowerCase().equals("y")){
			BookBuyingService byObj = new BookBuyingService();
			byObj.browsingUI(userModel);
		}
		
	}
	

}
