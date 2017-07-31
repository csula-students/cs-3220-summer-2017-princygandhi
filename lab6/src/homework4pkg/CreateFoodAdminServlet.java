package homework4pkg;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.PreparedStatement;

import java.util.List;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

import javax.servlet.annotation.WebServlet;
/**
 * Servlet implementation class CreateFoodAdminServlet
 */
@WebServlet("/hw4/admin_createfood")
public class CreateFoodAdminServlet extends HttpServlet {
	//executes on every page load
	 public void init () throws ServletException {
	        // load driver
	        try {
	            Class.forName( "com.mysql.jdbc.Driver" );
	        } catch( ClassNotFoundException e ) {
	            throw new ServletException( e );
	        }
	    }
	
	
			public void doGet( HttpServletRequest request, HttpServletResponse response)
				throws ServletException, IOException {
				
				 request.getRequestDispatcher("/AddFoodItem.jsp").forward(request, response);
				
			}
			
			@Override
			public void doPost( HttpServletRequest request, HttpServletResponse response)
					throws ServletException, IOException {
						
				
				FoodItem newFoodItem = new FoodItem(0, 
		                 request.getParameter("name"),
		                 request.getParameter("description"),
		                 request.getParameter("imgURL"),
		                 Double.parseDouble(request.getParameter("price"))
		                 );
				
				
				FoodItemsDAO dao = new FoodItemsDAO();
				dao.add(newFoodItem);
				
			    response.sendRedirect("../adminfoods");
			}

}
