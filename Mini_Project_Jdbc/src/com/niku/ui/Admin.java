package com.niku.ui;
import com.niku.dao.BookDAO;
import com.niku.model.Book;

import java.util.List;
import java.util.Scanner;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Admin {
	

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		
		System.out.println("-------------------------------------------");
		System.out.println("Welcome to Book Management System");
		System.out.println("-------------------------------------------");
		Scanner sc = new Scanner(System.in);
		BookDAO bookDaoObj = new BookDAO();
		
		while(true) {
			
			System.out.println("PRESS 1 TO VIEW ALL BOOKS");
			System.out.println("PRESS 2 TO SEARCH BOOK BY TITLE");
			System.out.println("PRESS 3 TO INSERT A BOOK");
			System.out.println("PRESS 4 TO DELETE A BOOK");
			System.out.println("PRESS 5 TO UPDATE THE BOOK PRICE By ID");
			System.out.println("PRESS 6 TO EXIT");
			System.out.println("Enter Your Choice...");
			int c = sc.nextInt();
			
			if(c==1) {
				List<Book> b=bookDaoObj.DisplayBookDetails();
				System.out.println(b);
				
				while(true) {
				System.out.println("Enter Y to Main Menu");
				String str = sc.next();
				if(str.equals("y")) 
					break;
				}
				
			}
			else if(c==2) {
				System.out.println("Enter the book Name to seach: ");
				
				InputStreamReader r=new InputStreamReader(System.in);    
				BufferedReader br=new BufferedReader(r);
				String name=br.readLine();   
			
				bookDaoObj.searchByName(name);

				System.out.println("*************************************");
				
				while(true) {
				System.out.println("Enter Y to Main Menu");
				String str = sc.next();
				if(str.equals("y")) 
					break;
				}
				
			}
			else if(c==3) {
				System.out.println("Enter the book Details to be Inserted: ");
				System.out.println("Enter the Book Id :");
				int tid = sc.nextInt();
				
				System.out.println("Enter the Book Name :");
				String tname =sc.next();
				
				System.out.println("Enter the Author Name :");
				String taName =sc.next();
				
				System.out.println("Enter the Book Price :");
				Double tprice = sc.nextDouble();
				
				Book obj = new Book(tid, tname, taName, tprice);
				bookDaoObj.insertBook(obj);
				
				while(true) {
				System.out.println("Enter Y to Main Menu");
				String str = sc.next();
				if(str.equals("y")) 
					break;
				}
				
			}
			else if(c==4) {
				//
				System.out.println("Enter the Book Id to delete Record:");
				int deleteId = sc.nextInt();
				
				bookDaoObj.deleteBookById(deleteId);
				
				while(true) {
				System.out.println("Enter Y to Main Menu");
				String str = sc.next();
				if(str.equals("y")) 
					break;
				}
				
			}
			else if(c==5) {
				//
				System.out.println("Enter the Book Id to Update Price:");
				int uId = sc.nextInt();
				System.out.println("Enter the Updated Price:");
				double uPrice = sc.nextDouble();
				bookDaoObj.updatePriceById(uId, uPrice);
				
				while(true) {
				System.out.println("Enter Y to Main Menu");
				String str = sc.next();
				if(str.equals("y")) 
					break;
				}
			}
			else if(c==6) {
				//
				break;
			}	
			else {
				System.out.println("***** Invalid Choice Please Select 1-6 *****");
				System.out.println("--------------------------------------------");
			}
		}
		System.out.println("-------------------------------------------");
		System.out.println("Thank you for using Book Management System");
		System.out.println("--------------------------------------------");

	}

}

