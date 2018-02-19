package com.imran.controller;

import com.imran.service.BookBuyingService;
import com.imran.model.UserModel;

public class BookBuyingController {
	BookBuyingService bookBuyingService = new BookBuyingService();
	private UserModel userModel;
	
	
	public void browsingBook(UserModel userModel){
		if(userModel != null){
			this.userModel = userModel;
		}
				
		   bookBuyingService.browsingUI(this.userModel);
	}

}
