package com.imranjson.service;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.io.FileReader;

import java.util.ArrayList;

import java.util.List;


import com.imranjson.model.UserModel;

public class UserService {
	
	private int id;
	private String userName;
	private String password;
	private double balance;

	private UserModel userObj;
	List<UserModel> userList;

	
	
	public List<UserModel> userList(){
		this.userList = new ArrayList<UserModel>();	
		
	    JSONParser jsonParser = new JSONParser();	
		try{
			Object userDataFormJsonFile = jsonParser.parse(new FileReader("G:\\TASK\\RokomariTask\\File\\jsonFolder\\userJsonData.txt"));
			JSONObject jsonObject = (JSONObject) userDataFormJsonFile;		
		    JSONArray userJsonData = (JSONArray) jsonObject.get("userJsonData");
		
		    for (Object userData: userJsonData) {
		    	JSONObject userObj = (JSONObject) userData;
		    	this.userObj = new UserModel();
		    	
		  
     	    	 this.id = Integer.parseInt((String)userObj.get("id"));
		    	 this.userName = (String) userObj.get("userName");
        	     this.password = (String) userObj.get("password");
		    	 this.balance = Double.parseDouble((String)userObj.get("balance"));
	    	
		    	this.userObj.setId(this.id);
		    	this.userObj.setUserName(this.userName);
		    	this.userObj.setPassword(this.password);
		    	this.userObj.setBalance(this.balance);
               
		    	this.userList.add(this.userObj);	        
	        }   
			
		}catch(Exception e){
			
		}		
		return this.userList;
	}
	
	
	
	public UserModel getUserByUserName(String userName){
		this.userList = userList();
		for(UserModel user  :userList){
			if(user.getUserName().equals(userName)){
				this.userObj = user;
			}
		}
		
		return this.userObj;
	}
	
	
	

}
