package com.imran.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import com.imran.model.UserModel;

public class UserService {
	
	static HashMap<Integer, UserModel> userMapData = getUserMap();
	
	private UserModel user;
	
	public static HashMap<Integer, UserModel> getUserMap(){
		return userMapData;
	}
	
	public UserService(){	
		if(userMapData == null){	
			userMapData = new HashMap<Integer, UserModel>();
			
			UserModel imran = new UserModel(1, "imran", "12345", 200);
			UserModel hossain = new UserModel(1, "hossain", "1234", 300);
			userMapData.put(1, imran);
			userMapData.put(2, hossain);					
		}	
	}
	
	
	
	public UserModel userByUserName(String username){		
		for (UserModel user : userMapData.values()) {
			if(user.getUserName().equals(username)){
				this.user = user;
			}
		}
		return this.user;

	}
	

	
	
	
	
	

}
