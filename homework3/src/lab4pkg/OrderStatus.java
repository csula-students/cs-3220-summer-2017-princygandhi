package lab4pkg;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class OrderStatus
 */
@WebServlet("/lab4/OrderStatus")
public class OrderStatus extends HttpServlet {
	private static final long serialVersionUID = 1L;
     
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		List<Order> orderEntries = (List<Order>) getServletContext().getAttribute("orderEntries");
		request.setAttribute("orderEntries", orderEntries);
		request.getRequestDispatcher("../statuses.jsp").forward(request, response);
	}
 
}
