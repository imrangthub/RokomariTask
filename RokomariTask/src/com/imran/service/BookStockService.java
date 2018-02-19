package com.imran.service;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.imran.model.BookStockModel;



public class BookStockService {
	
	private List<BookStockModel> bookStockMapData;
	
	public BookStockService(){		
		if(bookStockMapData == null){
			bookStockMapData = new ArrayList<BookStockModel>();
			
			BookStockModel java = new BookStockModel(1, "Java", 150);
			BookStockModel php = new BookStockModel(2, "php", 50);
			BookStockModel c = new BookStockModel(3, "C", 20);
			
			bookStockMapData.add(java);
			bookStockMapData.add(php);
			bookStockMapData.add(c);
			
		}		
	}
	
	
	public  List<BookStockModel> bookStockList(){
		return this.bookStockMapData;
	}
	
	

}
