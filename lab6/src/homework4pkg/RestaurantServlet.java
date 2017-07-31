package homework4pkg;

import java.io.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import java.util.List;
import java.util.ArrayList;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.WebServlet;
/**
 * Servlet implementation class RestaurantServlet
 */
@WebServlet("/hw4/RestaurantServlet")
public class RestaurantServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	
	 
	public void doGet( HttpServletRequest request, HttpServletResponse response)
	        throws ServletException, IOException {

		FoodItemsDAO dao = new FoodItemsDAO();
        request.setAttribute("fooditems", dao.list());
        request.getRequestDispatcher("/index.jsp").forward(request, response);
        
	}

}
