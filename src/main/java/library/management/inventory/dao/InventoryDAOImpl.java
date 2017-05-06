package library.management.inventory.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import library.management.bo.Book;

public class InventoryDAOImpl {

	private final String DRIVER_NAME = "org.postgresql.Driver";
	private final String CONNECTION_STRING = "jdbc:postgresql://localhost:5432/inventoryManagement";
	private final String USER_NAME = "postgres";
	private final String PASSWORD = "postgres";
	
	public Connection getDBConnection() {
		
		Connection con = null;
		try {
			 Class.forName(DRIVER_NAME);
			 con = DriverManager.getConnection(CONNECTION_STRING, USER_NAME, PASSWORD);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return con;
	}
	
	public String searchInventoryById(int bookId)  {
		
		String shelfAddress = null;
		Connection con = null;
		PreparedStatement pstmt = null;
		String sql = "Select address from shelf where shelfId in(select shelfId from book where bookId = ?)";
	    
	    try {
	    	con = getDBConnection();
	    	pstmt = con.prepareStatement(sql);
	    	pstmt.setInt(1, bookId);
	    	ResultSet rs = pstmt.executeQuery();
	    	
	    	while(rs.next())
	    	{
	    		shelfAddress = rs.getString("address");
	    	}
	    	
	    }catch(Exception e) {
	    	e.printStackTrace();
	    }
	    finally {
	    	try{
	    		if(con != null)
		    		con.close();
		    	if(pstmt != null)
		    		pstmt.close();
	    	}
	    	catch(Exception e) {
	    		e.printStackTrace();
	    	}
	    }
	    
	    return shelfAddress;
	}
	
	public void markBookForRent(int bookId,int qty) {
		
		Connection con = null;
		PreparedStatement pstmt = null;
		String sql = "Update book set quantity = quantity - ? where bookId = ?";
	    
	    try {
	    	con = getDBConnection();
	    	pstmt = con.prepareStatement(sql);
	    	pstmt.setInt(1, qty);
	    	pstmt.setInt(2, bookId);
	    	pstmt.executeUpdate();
	    	
	    }catch(Exception e) {
	    	e.printStackTrace();
	    }
	    finally {
	    	try{
	    		if(con != null)
		    		con.close();
		    	if(pstmt != null)
		    		pstmt.close();
	    	}
	    	catch(Exception e) {
	    		e.printStackTrace();
	    	}
	    }
	    
	}
	
	public void addBookInInventory(Book book) {
		
		Connection con = null;
		PreparedStatement pstmt = null;
		String sql = "Insert into book (bookid, name, isbn, author, quantity) values (DEFAULT, ?,?,?,?)";
		try {
			
			con = getDBConnection();
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, book.getName());
			pstmt.setString(2, book.getIsbn());
			pstmt.setString(3, book.getAuthor());
			pstmt.setInt(3, book.getQuantity());
			pstmt.executeQuery();
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try{
	    		if(con != null)
		    		con.close();
		    	if(pstmt != null)
		    		pstmt.close();
	    	}
	    	catch(Exception e) {
	    		e.printStackTrace();
	    	}
		}
	}
}
