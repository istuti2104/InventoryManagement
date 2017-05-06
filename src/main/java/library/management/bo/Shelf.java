package library.management.bo;

import java.util.ArrayList;
import java.util.List;

public class Shelf {

	private int shelfId;
	private String name;
	private String address;
	
	Shelf() {
		
	}

	Shelf(String name, String address) {
		this.name = name;
		this.address = address;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public int getShelfId() {
		return shelfId;
	}
}
