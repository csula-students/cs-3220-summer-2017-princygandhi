package lab4pkg;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import lab4pkg.Order.Statuses;


/**
 * Servlet implementation class RestaurantServlet
 */
@WebServlet("/restaurant")
public class RestaurantServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		   
			List<FoodItem> entries = (List<FoodItem>) getServletContext().getAttribute("entries");
			request.setAttribute("items", entries);
			request.getRequestDispatcher("./index.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
PrintWriter out = response.getWriter();
		
		List<FoodItem> entries = (List<FoodItem>) getServletContext().getAttribute("entries");
		List<Order> orderEntries = new ArrayList<>();

		for(int i = 0; i < entries.size(); i++)
		{
			int qty = Integer.parseInt(request.getParameter("fitem_id_"+i));
			
			if(qty > 0)
			{
				FoodItem leEntry = null;
				int foodItemId = Integer.parseInt(request.getParameter("fid_"+i));
				for (FoodItem entry: entries) {
					if (entry.getId() == foodItemId) {
						leEntry = entry;
					}
				}

				orderEntries.add(new Order(orderEntries.size(),leEntry,"Princy",Statuses.IN_QUEUE,new java.util.Date(System.currentTimeMillis()),qty,(qty * leEntry.getPrice())));
			}
		}
		getServletContext().setAttribute("orderEntries", orderEntries);
		response.sendRedirect("./order");
		
	}

}
