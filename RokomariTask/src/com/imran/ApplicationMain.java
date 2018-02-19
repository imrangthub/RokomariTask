package com.imran;

import java.util.Scanner;


import com.imran.controller.AuthController;
import com.imran.service.BookBuyingService;

public class ApplicationMain {
	BookBuyingService bookBuyingService = new BookBuyingService();

	public static void main(String[] args) {
		System.out.println("<< ===========   Welcome to Rokomari Project    ========== >>");
		
		AuthController authController = new AuthController();
	
		
		authController.loginUI();
		
		
		System.out.println("Thank you for using this app.");

	}
	

}

