package lab4pkg;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 * Servlet implementation class DeleteFoodAdminServlet
 */
@WebServlet("/lab4/deleteItem")

public class DeleteCartItem extends HttpServlet {
	
	public void doGet( HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
			int id = Integer.parseInt(request.getParameter("id"));
			List<Order> orderEntries = (List<Order>) getServletContext().getAttribute("orderEntries");
			
			int index = -1;
			for (int i = 0; i < orderEntries.size(); i ++) {
				if (orderEntries.get(i).getId() == id) {
					index = i;
				}
			}
			orderEntries.remove(index);
			getServletContext().setAttribute("orderEntries", orderEntries);
            
		    response.sendRedirect("./order");
			 
		}

}
