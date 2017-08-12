package csnslab3;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import csnslab3.Order.Statuses;


/**
 * Servlet implementation class OrderStatusesAdminServlet
 */
@WebServlet("/admin/orders")
public class OrderStatusesAdminServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	public void doGet( HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		    
		response.setContentType("text/html");
			PrintWriter out = response.getWriter();
			List<Order> entries = (List<Order>) getServletContext().getAttribute("orderEntries");
			out.println("<form method=\"post\">");
			out.println("<div style='width:80%;margin: 0px auto'><h1> Customer Orders! </h1><hr/>");
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
			                "<td> <select name='ostatus_" + entry.getId() +"'>" +
			                " <option>In Progress</option>  <option>Completed</option>  </select>"
			                + "<input type='hidden' name='itemId' value="+entry.getId() +"></td>"+
			                "<tr>");
				
				counter++;
			}
			out.println("</table>");
			out.println("<button>Update Status</button>");
			out.println("<a href='../admin/foods'>Go back to Home page.</a>");
			out.println("</div>");
			out.println("</form>");
		}
	
	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();

		
		List<Order> orderEntries = (List<Order>) getServletContext().getAttribute("orderEntries");
		for (int i = 0; i < orderEntries.size(); i ++) {
		
			int id = Integer.parseInt(request.getParameter("itemId"));
			String OrderStatus =  request.getParameter("ostatus_"+id);
			

			Order leEntry = null;
			leEntry = orderEntries.get(i);
	
			 orderEntries.set(leEntry.getId(), new Order(
				leEntry.getId(),
	            leEntry.getItems(),
	            leEntry.getCustomerName(),
	            OrderStatus.toLowerCase() == "in progress" ? Statuses.IN_PROGRESS : ( OrderStatus.toLowerCase() == "complete" ? Statuses.COMPLETED : Statuses.IN_QUEUE),
	            leEntry.getCreated(),
	            leEntry.getQty(),
	            leEntry.getTotal()
	            ));
		}
		 getServletContext().setAttribute("orderEntries", orderEntries);
		 response.sendRedirect("./foods");
		
		 
 
		
	}

}
