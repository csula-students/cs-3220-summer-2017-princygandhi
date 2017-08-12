package edu.csula.jaxrs;
import edu.csula.jaxrs.models.OrdersDAO;
import edu.csula.jaxrs.models.Order;

import edu.csula.jaxrs.models.Database;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;


import javax.inject.Singleton;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Path("orderservice")
@Singleton // used to keep resource between requests otherwise request cope
public class OrderService {
  
	OrdersDAO dao = new OrdersDAO();

    @GET
    @Path("orders")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Order> list() {
    	         return dao.list();
    }

    @GET
    @Path("orders/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Order GetItemById(@PathParam("id") int id) {
    	 return dao.get(id).get();
    }
    
    
    @POST
    @Path("orders")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public boolean add(Order entry) {
    	 dao.add(entry);
         System.out.println(dao.list());
         return true;
	}
    
    
    @DELETE
    @Path("orders/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public boolean deleteItem(@PathParam("id") int id) {
    	System.out.println(id);
    	OrdersDAO dao = new OrdersDAO();
    	dao.delete(id);
    	return true;
    	
    }
    
    @PUT
    @Path("orders/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public boolean updateItem(Order item, @PathParam("id") int id) {

    	 if (id == item.getId()) {
             dao.update(item);
             System.out.println(dao.list());
             return true;
         } else {
             return false;
         }
    }
}