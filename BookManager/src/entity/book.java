package entity;

public class book {
private int bookId;
private String bookImage;
private String bookName;
private String bookAuthor;
private String bookCbs;
private String date;
private long isbn;
private long count;
private double price;
public book(int bookId, String bookImage, String bookName, String bookAuthor, String bookCbs, String date, long isbn,
		long count, double price) {
	super();
	this.bookId = bookId;
	this.bookImage = bookImage;
	this.bookName = bookName;
	this.bookAuthor = bookAuthor;
	this.bookCbs = bookCbs;
	this.date = date;
	this.isbn = isbn;
	this.count = count;
	this.price = price;
}
public book() {
	super();
}
public int getBookId() {
	return bookId;
}
public void setBookId(int bookId) {
	this.bookId = bookId;
}
public String getBookImage() {
	return bookImage;
}
public void setBookImage(String bookImage) {
	this.bookImage = bookImage;
}
public String getBookName() {
	return bookName;
}
public void setBookName(String bookName) {
	this.bookName = bookName;
}
public String getBookAuthor() {
	return bookAuthor;
}
public void setBookAuthor(String bookAuthor) {
	this.bookAuthor = bookAuthor;
}
public String getBookCbs() {
	return bookCbs;
}
public void setBookCbs(String bookCbs) {
	this.bookCbs = bookCbs;
}
public String getDate() {
	return date;
}
public void setDate(String date) {
	this.date = date;
}
public long getIsbn() {
	return isbn;
}
public void setIsbn(long isbn) {
	this.isbn = isbn;
}
public long getCount() {
	return count;
}
public void setCount(long count) {
	this.count = count;
}
public double getPrice() {
	return price;
}
public void setPrice(double price) {
	this.price = price;
}

}
