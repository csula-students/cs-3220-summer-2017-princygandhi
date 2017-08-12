package edu.csula.jaxrs.models;

import java.util.Arrays;
import java.util.Collection;
import java.util.Date;
import java.util.List;

public class Order{
	public final int id;
	public final String customerName;
	public final String status;
	public final Date created;
	

	public Order(int id, String customerName, java.sql.Date created, String status) {
		// TODO Auto-generated constructor stub
		this.id = id;
 		this.customerName = customerName;
		this.status = status;
		this.created = created;
	
	}

	public int getId() {
		return id;
	}


	public String getCustomerName() {
		return customerName;
	}
	
	public String getStatuses() {
		return status;
	}
	
	public Date getCreated()
	{
		return created;
	}
	

}
