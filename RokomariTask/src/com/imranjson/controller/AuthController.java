package com.imranjson.controller;

import java.util.HashMap;
import java.util.Scanner;

import com.imranjson.model.UserModel;
import com.imranjson.service.UserService;

public class AuthController {
	
	String username;
	String password;
	String userInput;
	Scanner scanner = new Scanner(System.in);
	UserModel logUserInfo;
	UserService userService = new UserService();
	
	
	boolean loginStatus = false;
	
	
	 public void loginUI(){			
		 HashMap<String, Object> logedUserInfoMap = null;
			 System.out.println("User name: \n");
			 this.username = scanner.nextLine();
			
			 System.out.println("Password: \n");
			 this.password = scanner.nextLine();
			
		   if(!this.username.isEmpty() && !this.password.isEmpty()){
			    this.logUserInfo = userLogin(this.username, this.password);
			   if(this.loginStatus){
				   System.out.println("Login Success for: "+this.logUserInfo.getUserName());
				   System.out.println("Do you want to see Book List? Y");
				   this.userInput = scanner.nextLine();
				   if(this.userInput.toLowerCase().equals("y")){
					   BookBuyingController bookBuyController = new BookBuyingController();
					   bookBuyController.browseBook(this.logUserInfo);
				   }
			   }else{
				   System.out.println("Login failed, User not found..!");
			   }
			   
		   }else{
			   
			   System.out.println("Missaing Username or Password.");			   
		   }
		   
		   System.out.println("Try again ? Y");
		   String tryAgaintext = scanner.nextLine();
		   if(tryAgaintext.toLowerCase().equals("y")){
			   loginUI();
		   }
	 }
	 
	 public UserModel userLogin(String userName, String password){
		 UserModel logUser = userService.getUserByUserName(userName);
           if(logUser != null && logUser.getPassword().equals(password)){
        	   this.loginStatus = true;
           }else{
        	   this.loginStatus = false;
        	   System.out.println("User name or Password Wrong...!");  
           }
           return logUser;
	 }
	
	
	   

}
