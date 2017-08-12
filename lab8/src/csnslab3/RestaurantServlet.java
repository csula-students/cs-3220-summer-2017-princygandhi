package csnslab3;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import csnslab3.Order.Statuses;

 

/**
 * Servlet implementation class RestaurantServlet
 */
@WebServlet(loadOnStartup=1, urlPatterns={"/restaurant"})
public class RestaurantServlet extends HttpServlet {
	
	public void init() {
		   List<FoodItem> entries = new ArrayList<>();
		   entries.add(new FoodItem(entries.size(), "Chipotle","Mexican Food","https://blogs.hopkins-interactive.com/2019/files/Chipotle_Barbacoa_Bowl_2x.jpg",9.99));
		   entries.add(new FoodItem(entries.size(), "Hamburger","Americal Food","http://www.in-n-out.com/images/menu_v2/cheeseburger_meal.png",10.99));
		   entries.add(new FoodItem(entries.size(), "Pizza","Americal Food","https://s-media-cache-ak0.pinimg.com/originals/22/52/a9/2252a9064d6aa07990f9c8b8c5644b61.jpg",12.99));
		   getServletContext().setAttribute("entries", entries);
		}
	
	public void doGet( HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		    
		response.setContentType("text/html");
			PrintWriter out = response.getWriter();
			List<FoodItem> entries = (List<FoodItem>) getServletContext().getAttribute("entries");
			out.println("<form method=\"post\">");
			out.println("<div style='width:80%;margin: 0px auto'><h1> Hello Customer! </h1><hr/>");
			out.println("<h2> Food Menu! </h2>");
			out.println("<table width='100%' border='1'>");
			out.println("<thead><tr><th>Item</th><th>Description</th><th>Image</th><th>Price</th><th>Qty</th></tr></thead>");
			int counter = 0;
			
			for(FoodItem entry : entries)
			{
				counter++;
				out.println("<tr>" +
			                "<td>" + entry.getName() + " </td> " +
			                "<td>" + entry.getDescription() + " </td> " +
			                "<td> <img src='" + entry.getImgURL() + "' width='300px'/></td> " +
			                "<td>" + entry.getPrice() + " </td> " +
			                "<td> <input type='text' width='10px' name='fitem_id_" + counter + "' value='0' /> </td> " +
			                "<td> <input type='hidden' name='fid_"+ counter +"' value='"+ entry.getId() +"'></td> " +
			                "<tr>");
				
				
			}
			out.println("</table> <input type='hidden' name='totalCounter' value='"+ counter +"'>");
			out.println("<button>Add to Cart</button>   ");
			out.println("<a href='./shopping-cart'>My Cart</a></div>");
			out.println("</form>");
		}
	
	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		
		List<FoodItem> entries = (List<FoodItem>) getServletContext().getAttribute("entries");
		List<Order> orderEntries = new ArrayList<>();
	
		int counter = Integer.parseInt(request.getParameter("totalCounter"));
		
		
		
		
		for(int i = 1; i <= counter; i++)
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
		out.println("<a href='./shopping-cart'>View Your Order! </a>");
		
	
		
	}
}
