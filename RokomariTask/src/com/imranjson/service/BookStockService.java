package com.imranjson.service;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import com.imranjson.model.BookStockModel;
import com.imranjson.model.UserModel;



public class BookStockService {
	
	private int id;
	private String bookName;
	private float price;

	private BookStockModel bookObj;
	List<BookStockModel> bookList;
	
	
	public List<BookStockModel> bookList(){
		this.bookList = new ArrayList<BookStockModel>();	
		
	    JSONParser jsonParser = new JSONParser();	
		try{
			Object bookDataFormJsonFile = jsonParser.parse(new FileReader("G:\\TASK\\RokomariTask\\File\\jsonFolder\\bookListJsonData.txt"));
			JSONObject jsonObject = (JSONObject) bookDataFormJsonFile;		
		    JSONArray bookJsonData = (JSONArray) jsonObject.get("bookJsonData");
		
		    for (Object bookData: bookJsonData) {
		    	JSONObject bookObj = (JSONObject) bookData;
		    	this.bookObj = new BookStockModel();
		    	
		  
     	    	 this.id = Integer.parseInt((String)bookObj.get("id"));
		    	 this.bookName = (String) bookObj.get("bookName");
        	     this.price = Float.parseFloat((String) bookObj.get("price"));
	    	
		    	this.bookObj.setId(this.id);
		    	this.bookObj.setBookName(this.bookName);
		    	this.bookObj.setPrice((this.price));

               
		    	this.bookList.add(this.bookObj);	        
	        }   
			
		}catch(Exception e){
			
		}		
		return this.bookList;
	}
	
	
	
	
	

}
