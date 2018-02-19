package com.imranjson;

import java.util.Scanner;

import com.imranjson.controller.AuthController;



public class ApplicationMain {


	public static void main(String[] args) {
		System.out.println("<< ===========   Welcome to Rokomari Project with JSON and File   ========== >>");
		
		AuthController authController = new AuthController();
		
		authController.loginUI();
		
		System.out.println("Thank you for using this app.");

	}
	

}

