package edu.csula.jaxrs;
import edu.csula.jaxrs.models.FoodItemsDAO;
import edu.csula.jaxrs.models.FoodItem;
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

@Path("foodItemService")
@Singleton // used to keep resource between requests otherwise request cope
public class FoodItemService {
  
	FoodItemsDAO dao = new FoodItemsDAO();

    @GET
    @Path("fooditems")
    @Produces(MediaType.APPLICATION_JSON)
    public List<FoodItem> list() {
    	         return dao.list();
    }

    @GET
    @Path("fooditems/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public FoodItem GetItemById(@PathParam("id") int id) {
    	 return dao.get(id).get();
    }
    
    
    @POST
    @Path("fooditems")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public boolean add(FoodItem entry) {
    	 dao.add(entry);
         System.out.println(dao.list());
         return true;
	}
    
    
    @DELETE
    @Path("fooditems/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public boolean deleteItem(@PathParam("id") int id) {
    	System.out.println(id);
    	FoodItemsDAO dao = new FoodItemsDAO();
    	dao.delete(id);
    	return true;
    	
    }
    
    @PUT
    @Path("fooditems/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public boolean updateItem(FoodItem item, @PathParam("id") int id) {

    	 if (id == item.getId()) {
             dao.update(item);
             System.out.println(dao.list());
             return true;
         } else {
             return false;
         }
    }
}