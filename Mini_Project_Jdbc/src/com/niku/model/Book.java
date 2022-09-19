package com.niku.model;

import java.util.Objects;

public class Book implements Comparable{
	int bookId;
	String name;
	String authorName;
	double price;
	
	public Book(int bookId, String name, String authorName, double price) {
		this.bookId = bookId;
		this.name = name;
		this.authorName = authorName;
		this.price = price;
	}

	public int getBookId() {
		return bookId;
	}

	public void setBookId(int bookId) {
		this.bookId = bookId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAuthorName() {
		return authorName;
	}

	public void setAuthorName(String authorName) {
		this.authorName = authorName;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	@Override
	public int hashCode() {
		return Objects.hash(authorName, bookId, name, price);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Book other = (Book) obj;
		return Objects.equals(authorName, other.authorName) && bookId == other.bookId
				&& Objects.equals(name, other.name)
				&& Double.doubleToLongBits(price) == Double.doubleToLongBits(other.price);
	}

	@Override
	public String toString() {
		return "Book [bookId=" + bookId + ", name=" + name + ", authorName=" + authorName + ", price=" + price + "]"+"\n";
	}


	@Override 
	public int compareTo(Object o) {
		// TODO Auto-generated method stub
		return this.bookId - ((Book) o).getBookId();
	}
	
}
