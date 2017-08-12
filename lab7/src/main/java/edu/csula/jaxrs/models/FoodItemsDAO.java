package edu.csula.jaxrs.models;


import edu.csula.jaxrs.models.DAO;

import edu.csula.jaxrs.models.Database;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.Optional;
import java.util.ArrayList;

public class FoodItemsDAO implements DAO<FoodItem> {
    
	public List<FoodItem> list() {
        List<FoodItem> list = new ArrayList<>();
        Database db = new Database();
        try (Connection c = db.connection()) {
            Statement stmt = c.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM FoodItems");
            while (rs.next()) {
                list.add(new FoodItem(
                		rs.getInt("id"),
  	                    rs.getString("Name"),
  	                    rs.getString("Description"),
  	                    rs.getString("ImgUrl"),
  	                    rs.getDouble("Price")
                ));
            }
            c.close();
        } catch (SQLException e) {
            e.printStackTrace();
            return list;
        }
        return list;
    }

    public Optional<FoodItem> get(int id) {
    	Optional<FoodItem>  fooditem = Optional.empty();
        FoodItem temp = null;
        Database db = new Database();
        try (Connection c = db.connection()) {
            Statement stmt = c.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM FoodItems WHERE id=" + id);
            while (rs.next()) {
            	temp = new FoodItem(
                		rs.getInt("id"),
  	                    rs.getString("Name"),
  	                    rs.getString("Description"),
  	                    rs.getString("ImgUrl"),
  	                    rs.getDouble("Price")
                );
            }
            c.close();
            fooditem = Optional.of(temp);
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return fooditem;
    }

     
    public void delete(int id) {
    	
    	   Database db = new Database();
	        try (Connection c = db.connection()) {
	            PreparedStatement pstmt = c.prepareStatement("DELETE FROM FoodItems WHERE ID = "+ id); 
	            pstmt.executeUpdate();
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
    	
    }

	@Override
	public void add(FoodItem entry) {
		// TODO Auto-generated method stub
		  Database db = new Database();
	        try (Connection c = db.connection()) {
	            PreparedStatement pstmt = c.prepareStatement("INSERT INTO FoodItems (Name,Description,ImgURL,Price) VALUES (?, ?, ?, ?)");
	            pstmt.setString(1, entry.getName());
	            pstmt.setString(2, entry.getDescription());
	            pstmt.setString(3, entry.getImgURL());
	            pstmt.setDouble(4, entry.getPrice());
	            pstmt.executeUpdate();
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	}

	@Override
	public void update(FoodItem entry) {
		// TODO Auto-generated method stub
		
		    Database db = new Database();
	        try (Connection c = db.connection()) {
	            PreparedStatement pstmt = c.prepareStatement("UPDATE FoodItems SET Name = '"+ entry.getName() +"',"+
	            											 "Description = '"+ entry.getDescription() +"',"+ 
	            											 "ImgURL = '"+ entry.getImgURL() +"',"+ 
	            											 "Price = "+ entry.getPrice() +" WHERE Id = " + entry.getId()); 
	            pstmt.executeUpdate();
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
		
		
		
		
	}
}