package com.niku.dao;
import java.util.List;

import com.niku.model.Book;

public interface IDAOBook {
	
	public List<Book> DisplayBookDetails();
	public void insertBook(Book b);
    public void deleteBookById(int id);
    public void searchByName(String name);
    public void updatePriceById(int id, Double price);

}
