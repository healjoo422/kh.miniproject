package com.kh.miniproject;

import java.util.Objects;

public class Book {
	private static int BOOK_ID_GENERATOR= 1001;
	
	private int id;
	private String title;
	private String author;
	
	
	public Book() {
	}

	public Book(String title, String author) {
		super();
		this.id = BOOK_ID_GENERATOR++;
		this.title = title;
		this.author = author;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	@Override
	public String toString() {
		return "[괸라번호=" + id + ", 책 이름=" + title + ", 저자=" + author + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(title, author);
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
		return Objects.equals(author, other.author) && Objects.equals(title, other.title);
	}
	
}
