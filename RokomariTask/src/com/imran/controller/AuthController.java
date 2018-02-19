package com.imran.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

import com.imran.model.UserModel;
import com.imran.service.BookBuyingService;
import com.imran.service.BookStockService;
import com.imran.service.UserService;

public class AuthController {
	
	String username;
	String password;
	Scanner scanner = new Scanner(System.in);
	UserService userService = new UserService();
	BookBuyingController bookBuyingController = new BookBuyingController();

	
	boolean loginStatus = false;
	UserModel logedUser;
	
	
	 public void loginUI(){			
		 HashMap<String, Object> logedUserInfoMap = null;
			 System.out.println("User name: \n");
			 this.username = scanner.nextLine();
			
			 System.out.println("Password: \n");
			 this.password = scanner.nextLine();
			
		   if(!username.isEmpty() && !password.isEmpty()){
			   logedUserInfoMap = login(this.username, this.password);
			   this.loginStatus = (Boolean)logedUserInfoMap.get("loginStatus");
			   if(this.loginStatus){
				   this.logedUser = (UserModel)logedUserInfoMap.get("logedUser");
				   bookBuyingController.browsingBook(this.logedUser);
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
	
	
	   public HashMap<String, Object> login(String username, String password){	
		   boolean loginStatus = false;
		   HashMap<String, Object> logedUserInfoMap = new HashMap<String, Object>();
		   UserModel logedUser = null;
			
			logedUser = userService.userByUserName(username);
			if(logedUser != null){
				if(logedUser.getPassword().equals(password)){
					loginStatus = true;
					System.out.println("Login Successfully.");
				}else{
					loginStatus = false;	
					System.out.println("Failed to login. Incurret password");
				}	
			}else{
				System.out.println("Failed to login. Can't fined User for this username.");
			}
			logedUserInfoMap.put("loginStatus", loginStatus);
			logedUserInfoMap.put("logedUser", logedUser);
								
		   return logedUserInfoMap;		 
	   }
	   
	   
	   
	   

}
