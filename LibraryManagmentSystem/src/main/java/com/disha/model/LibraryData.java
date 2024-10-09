package com.disha.model;

public class LibraryData {
	private String bookName;
	private String genre;
	private String authorName;
	private int isbnNo;
	public LibraryData(String bookName, String genre, String authorName, int isbnNo) {
		super();
		this.bookName = bookName;
		this.genre = genre;
		this.authorName = authorName;
		this.isbnNo = isbnNo;
	}
	public String getBookName() {
		return bookName;
	}
	public void setBookName(String bookName) {
		this.bookName = bookName;
	}
	public String getGenre() {
		return genre;
	}
	public void setGenre(String genre) {
		this.genre = genre;
	}
	public String getAuthorName() {
		return authorName;
	}
	public void setAuthorName(String authorName) {
		this.authorName = authorName;
	}
	public int getIsbnNo() {
		return isbnNo;
	}
	public void setIsbnNo(int isbnNo) {
		this.isbnNo = isbnNo;
	}
	@Override
	public String toString() {
		return "bookName=" + bookName + ", genre=" + genre + ", authorName=" + authorName + ", isbnNo="
				+ isbnNo;
	}
	public LibraryData() {
		super();
	}
	
	
	

}
