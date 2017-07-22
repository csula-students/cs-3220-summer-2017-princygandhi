package csnslab3;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class CartServlet
 */
@WebServlet("/shopping-cart")
public class CartServlet extends HttpServlet {
 
       
	public void doGet( HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		    
		response.setContentType("text/html");
			PrintWriter out = response.getWriter();
			List<Order> entries = (List<Order>) getServletContext().getAttribute("orderEntries");

			out.println("<div style='width:80%;margin: 0px auto'><h1> Hello Customer! </h1><hr/>");
			out.println("<h2> Your Cart! </h2>");
			out.println("<table width='100%' border='1'>");
			out.println("<thead><tr><th>Item</th><th>Qty</th><th>Total</th><th>Customer</th><th>Status</th></tr></thead>");
			int counter = 1;
			
			for(Order entry : entries)
			{
				out.println("<tr>" +
			                "<td>" + entry.foodItems.getName() + " </td> " +
			                "<td>" + entry.getQty()+ " </td> " +
			                "<td> " + entry.getTotal() + "</td> " +
			                "<td>" + entry.getCustomerName() + " </td> " +
			                "<td> "+ entry.getStatuses()+" </td> " +
			                "<tr>");
				
				counter++;
			}
			out.println("</table>");
			out.println("</div>");

		}

}
