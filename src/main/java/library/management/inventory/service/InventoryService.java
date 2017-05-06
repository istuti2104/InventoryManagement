package library.management.inventory.service;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import library.management.bo.Book;
import library.management.inventory.dao.InventoryDAOImpl;

@Path("/inventoryService")
public class InventoryService {
	
	private InventoryDAOImpl dao ;

	@GET
	@Path("/books/{bookId}")
	@Produces(MediaType.APPLICATION_JSON)
	public String searchBookById(@PathParam("bookId") int id) {
		
		return dao.searchInventoryById(id);
		
	}
	
	@PUT
	@Path("/book/{book}")
	@Consumes(MediaType.APPLICATION_JSON)
	public void markBookForRent(@PathParam("book")Book book) {
		
		dao.markBookForRent(book.getBookId(), book.getQuantity());
	}
	
	@POST
	@Path("/book/{book}")
	@Consumes(MediaType.APPLICATION_JSON)
	public void addBookInInventory(@PathParam("book") Book book) {
		
		dao.addBookInInventory(book);
	}
	
	public InventoryDAOImpl getDAO() {
		dao = new InventoryDAOImpl();
		return dao;
	}
	
}
