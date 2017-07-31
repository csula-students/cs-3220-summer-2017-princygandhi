package homework4pkg;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/hw4/adminfoods")
public class RestaurantAdminServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
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

			FoodItemsDAO dao = new FoodItemsDAO();
	        request.setAttribute("fooditems", dao.list());
	        request.getRequestDispatcher("/Inventory.jsp")
	        .forward(request, response);
	        
	}

}
