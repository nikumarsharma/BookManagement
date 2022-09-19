package com.niku.dao;

import java.util.Iterator;
import java.util.Scanner;
import com.niku.model.Book;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import com.niku.model.Book;
public class BookDAO implements IDAOBook{
	Scanner sc = new Scanner(System.in);

	//Display All Book
	@Override
	public List<Book> DisplayBookDetails() {
		// TODO Auto-generated method stub
		List<Book> books=new ArrayList<>();
		try {
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/manhattan_jdbc","root","NKSums@123");
			Statement statement=con.createStatement();
			ResultSet res=statement.executeQuery("select * from book");
			while(res.next()) {
				 books.add(new Book(res.getInt(1),res.getString(2),res.getString(3),res.getDouble(4)));
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return books;
	}
	
	@Override
	public void searchByName(String name) {
		// TODO Auto-generated method stub
		try {
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/manhattan_jdbc","root","NKSums@123");
			PreparedStatement statement=con.prepareStatement("select * from book where name=?");
			statement.setString(1,name);
			ResultSet res=statement.executeQuery();
			while(res.next()) {
				System.out.println("Book Id = "+ res.getInt(1)+"  Title: "+res.getString(2) +"  Author Name: "+res.getString(3)+" Price  "+res.getInt(4)+"Rs");
			}
			
	}catch(SQLException e) {
		e.printStackTrace();
	}
	}
	
	/* public void searchByName(String name) {
		Iterator<Book> itr = data.iterator();
		int cntr=0;
        while(itr.hasNext()) {
        	Book bname=itr.next();
            if(((bname).getName()).equals(name)) 
            {
            	cntr++;
            	System.out.println(bname); 
            }       
        } 
        if(cntr==0){
        	System.out.println("You Entered Invalid Book Name");
        }
	} */
	
	@Override
	public void insertBook(Book b) {
		// TODO Auto-generated method stub
		try {
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/manhattan_jdbc","root","NKSums@123");
		PreparedStatement statement=con.prepareStatement("insert into book values(?,?,?,?)");
		int id=b.getBookId();
		String name=b.getName();
		String authorName=b.getAuthorName();
		double price=b.getPrice();
		statement.setInt(1,id);
		statement.setString(2,name);
		statement.setString(3, authorName);
		statement.setDouble(4, price);
		int row=statement.executeUpdate();
		if(row==1)
			System.out.println("New Row inserted Successfully");
		
	}catch(SQLException e) {
		e.printStackTrace();
	}
}
	@Override
	public void deleteBookById(int id) {
		// TODO Auto-generated method stub
	
		try {
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/manhattan_jdbc","root","NKSums@123");
			PreparedStatement statement=con.prepareStatement("delete from book where bookId=?");
			statement.setInt(1,id);
			int row=statement.executeUpdate();
			if(row==1)
				System.out.println("Selected Row Deleted");
			else
				System.out.println("You entered Invalid Book Id");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	/* public void deleteById(int id) {
		int cntr=0;
		Iterator<Book> itr = data.iterator();
        while(itr.hasNext()) {
        	
        	Book bid=itr.next();
            if(((bid).getBookId())==id) {
            	itr.remove();
            	cntr++;
            	System.out.println("Your Record Deleted......");
            }    

        } 
        if(cntr==0){
        	System.out.println("You Entered Invalid Book Id");
        }	
	} */

	@Override
	public void updatePriceById(int id, Double price) {
		// TODO Auto-generated method stub
		try {
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/manhattan_jdbc","root","NKSums@123");
			PreparedStatement statement=con.prepareStatement("update book set price=? where bookId=?");
			statement.setDouble(1,price);
			statement.setInt(2, id);
			int row=statement.executeUpdate();
			if(row==1)
				System.out.println("Price is Updated");
	}catch(SQLException e) {
		e.printStackTrace();
	}
	}

	/*
	 * @Override public void insertBook(BookDAO b) { // TODO Auto-generated method
	 * stub
	 * 
	 * }
	 */
	
	/* public void updatePriceById(int id) {
		
		int cntr=0;
		Iterator<Book> itr = data.iterator();
        while(itr.hasNext()) {
        	Book bid=itr.next();
            if(((bid).getBookId())==id) {
            	System.out.println(bid); 
        		System.out.println("Enter the Updated Price");
        		Double updatedPrice = sc.nextDouble();
        		bid.setPrice(updatedPrice);
				data.add(bid);
				System.out.println("Price Updated.......");
            	cntr++;
            }    
        }
        if(cntr==0){
        	System.out.println("Enter Valid Book ID.......");
        }
	}*/

}
