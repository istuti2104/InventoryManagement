package library.management.bo;

public class Book {
	
	private int bookId;
	private String name;
	private String isbn;
	private int quantity;
	private String author;
	private String shelfName;
	
	Book(String name, String isbn, int quantity, String author) {
		this.name = name;
		this.isbn = isbn;
		this.quantity = quantity;
		this.author = author;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getIsbn() {
		return isbn;
	}
	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public int getBookId() {
		return bookId;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	
	public void reduceQty(int qty) {
		quantity = quantity - qty;
	}
	
	public boolean isQtyPresent(int qty) {
		return quantity >= qty;
	}

	public String getShelfName() {
		return shelfName;
	}

	public void setShelfName(String shelfName) {
		this.shelfName = shelfName;
	}
	
	
	

}
