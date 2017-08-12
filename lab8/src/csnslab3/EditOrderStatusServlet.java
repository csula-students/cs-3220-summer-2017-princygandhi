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
 * Servlet implementation class EditOrderStatusServlet
 */
@WebServlet("/admin/order/edit")
public class EditOrderStatusServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	public void doGet( HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
			int id = Integer.parseInt(request.getParameter("id"));
			List<Order> entries = (List<Order>) getServletContext().getAttribute("orderEntries");
			
			Order leEntry = null;
			for (Order entry: entries) {
				if (entry.getId() == id) {
					leEntry = entry;
				}
			}

			response.setContentType("text/html");
			PrintWriter out = response.getWriter();
			out.println("<h1>Update Order</h1>");
			out.println("<form method=\"post\">");
			out.println("Food Item:<br/> "+ leEntry.foodItems.getName()+"</br></br>");
			out.println("Qty: <br/>" + leEntry.getQty() + "</br></br>");
			out.println("Total: <br/>$" + leEntry.getTotal() + "</br></br>");
			out.println("Customer Name: <br/>" + leEntry.getCustomerName()+ "</br></br>");
			out.println("Order Status: <br/>" + leEntry.getStatuses()+ "</br></br>");
			out.println("<button>Update order status to In Progress</button>");
			out.println("</form>");
		}
	
	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int id = Integer.parseInt(request.getParameter("id"));
		List<Order> entries = (List<Order>) getServletContext().getAttribute("orderEntries");
		Order leEntry = null;
		for (Order entry: entries) {
			if (entry.getId() == id) {
				leEntry = entry;
			}
		}
		
		entries.remove(id);
		entries.add(new Order(id,leEntry.foodItems,leEntry.getCustomerName(),
				              Statuses.IN_PROGRESS,leEntry.getCreated(),leEntry.getQty(),leEntry.getTotal()));
		
		
		getServletContext().setAttribute("orderEntries", entries);

		PrintWriter out = response.getWriter();
		out.println("<a href='../orders'>Order Status Updated. Go back to the orders list. </a>");
	}
}
