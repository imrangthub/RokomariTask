package com.imranjson.controller;

import java.util.List;
import java.util.Scanner;

import org.json.simple.JSONObject;

import com.imranjson.model.BookStockModel;
import com.imranjson.model.UserModel;

public class UpdateDataController {
	
	private int id;
	private String bookName;
	private float price;
	UserModel userInfo;
	private BookStockModel bookObj;
	List<BookStockModel> bookList;
	Scanner scanner;
	String userInput;
	
	public void updateUserInof(UserModel user){
		if(user != null){
			this.userInfo = user;
		}
		System.out.println("From Update"+this.userInfo.getBalance()+" "+this.userInfo.getUserName());
		
		JSONObject obj = new JSONObject();
		
        obj.put("id", this.userInfo.getId());
        obj.put("userName", this.userInfo.getUserName());
        obj.put("password", this.userInfo.getPassword());
        obj.put("blance", this.userInfo.getBalance());
		System.out.println(obj);
	}

}
