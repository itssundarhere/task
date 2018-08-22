package org.book;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Book_DB")
public class BookDatabase {
	@Id	
	private String bookId;
	private String bookName;
	private String authorName;
	private String ISBN;
	private long publication;
	private long price;
	
	public BookDatabase() {
		super();
	}

	public BookDatabase(String bookId, String bookName, String authorName, String ISBN, long publication, long price) {
		super();
		this.bookId = bookId;
		this.bookName = bookName;
		this.authorName = authorName;
		this.ISBN = ISBN;
		this.publication = publication;
		this.price = price;
	}

	public String getBookId() {
		return bookId;
	}

	public void setBookId(String bookId) {
		this.bookId = bookId;
	}

	public String getBookName() {
		return bookName;
	}

	public void setBookName(String bookName) {
		this.bookName = bookName;
	}

	public String getAuthorName() {
		return authorName;
	}

	public void setAuthorName(String authorName) {
		this.authorName = authorName;
	}

	public String getISBN() {
		return ISBN;
	}

	public void setISBN(String isbn2) {
		ISBN = isbn2;
	}

	public long getPublication() {
		return publication;
	}

	public void setPublication(long publication) {
		this.publication = publication;
	}

	public long getPrice() {
		return price;
	}

	public void setPrice(long price) {
		this.price = price;
	}
	
	
}
