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
			List<FoodItem> entries = ( List<FoodItem>) getServletContext().getAttribute("entries");
			out.println("<div style='width:80%;margin: 0px auto'><h1> Hello Customer! </h1><hr/>");
			out.println("<h2> Food Menu! </h2>");
			out.println("<table width='100%' border='1'>");
			out.println("<thead><tr><th>Item</th><th>Description</th><th>Image</th><th>Price</th></tr></thead>");
			for(FoodItem entry : entries)
			{
				out.println("<tr>" +
			                "<td>" + entry.getName() + " </td> " +
			                "<td>" + entry.getDescription() + " </td> " +
			                "<td> <img src='" + entry.getImgURL() + "' width='300px'/></td> " +
			                "<td>" + entry.getPrice() + " </td> " +
			                "<tr>");
			}
			out.println("</table></div>");
			
		}
}
