package lab4pkg;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class CartServlet
 */
@WebServlet("/restaurant/order")
public class CartServlet extends HttpServlet {
	 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		ServletContext context = getServletContext();
		List<Order> orderEntries = (List<Order>) getServletContext().getAttribute("orderEntries");
		
		String removeItem =request.getParameter("removeItem");
		if(removeItem!=null)
		{
			for(Order entry : orderEntries)
			{
				if(entry.getId() == Integer.parseInt(removeItem))
				{
					orderEntries.remove(entry);
				}
			}
		}
		
		context.setAttribute("orderEntries", orderEntries);
		
		request.setAttribute("orderEntries", orderEntries);
		request.getRequestDispatcher("../order.jsp").forward(request, response);
		
		
	}
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		List<Order> orderEntries = (List<Order>) getServletContext().getAttribute("orderEntries");
		request.setAttribute("orderEntries", orderEntries);
		request.getRequestDispatcher("../statuses.jsp").forward(request, response);
	}

}
