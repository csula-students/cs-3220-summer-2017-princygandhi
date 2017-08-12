package edu.csula.jaxrs.models;


import edu.csula.jaxrs.models.DAO;

import edu.csula.jaxrs.models.Database;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.Optional;
import java.util.ArrayList;

public class OrdersDAO implements DAO<Order> {
    
	public List<Order> list() {
       List<Order> list = new ArrayList<>();
       Database db = new Database();
        try (Connection c = db.connection()) {
            Statement stmt = c.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM orders ;");
            while (rs.next()) {
                    list.add(new Order(
                       rs.getInt("ID"), 
                        rs.getString("CUSTOMERNAME"),
                        rs.getDate("CREATED"),
                        rs.getString("STATUS")
                    ));
            }
        } catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}

    public Optional<Order> get(int id) {
    	Optional<Order>  Order = Optional.empty();
        Order temp = null;
        Database db = new Database();
        try (Connection c = db.connection()) {
            Statement stmt = c.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM Orders WHERE ID=" + id);
            while (rs.next()) {
            	temp = new Order(
            			 rs.getInt("ID"), 
                         rs.getString("CUSTOMERNAME"),
                         rs.getDate("CREATED"),
                         rs.getString("STATUS")
                );
            }
            c.close();
            Order = Optional.of(temp);
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return Order;
    }

     
    public void delete(int id) {
    	
    	   Database db = new Database();
	        try (Connection c = db.connection()) {
	            PreparedStatement pstmt = c.prepareStatement("DELETE FROM Orders WHERE ID = "+ id); 
	            pstmt.executeUpdate();
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
    	
    }

	@Override
	public void add(Order entry) {
		// TODO Auto-generated method stub
		  Database db = new Database();
	        try (Connection c = db.connection()) {
	            PreparedStatement pstmt = c.prepareStatement("INSERT INTO Orders (CUSTOMERNAME,CREATED,STATUS) VALUES ( ?, ?, ?)");
	            pstmt.setString(1, entry.getCustomerName());
	            pstmt.setDate(2, (Date) entry.getCreated());
	            pstmt.setString(3, entry.getStatuses());
	            pstmt.executeUpdate();
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	}

	@Override
	public void update(Order entry) {
		// TODO Auto-generated method stub
		
		    Database db = new Database();
	        try (Connection c = db.connection()) {
	            PreparedStatement pstmt = c.prepareStatement("UPDATE Orders SET CUSTOMERNAME = '"+ entry.getCustomerName() +"',"+
	            											 "STATUS = '"+ entry.getStatuses() +"',"+ 
	            											 "CREATED = '"+ entry.getCreated() +"' "+ 
	            											 " WHERE ID = " + entry.getId()); 
	            pstmt.executeUpdate();
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
		
		
		
		
	}
 
}