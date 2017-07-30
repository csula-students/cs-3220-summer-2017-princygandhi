package lab4pkg;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import lab4pkg.Order.Statuses;

/**
 * Servlet implementation class AdminOrderStatus
 */
@WebServlet("/admin/AdminOrderStatus")
public class AdminOrderStatus extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Order> orderEntries = (List<Order>) getServletContext().getAttribute("orderEntries");
		request.setAttribute("orderEntries", orderEntries);
		request.getRequestDispatcher("../OrderStatus.jsp").forward(request, response);
	}

	 
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	        
		List<Order> orderEntries = (List<Order>) getServletContext().getAttribute("orderEntries");
		for (int i = 0; i < orderEntries.size(); i ++) {
		
			int id = Integer.parseInt(request.getParameter("itemId"));
			String OrderStatus =  request.getParameter("ostatus_"+id);
			
			if(OrderStatus.toLowerCase() == "in progress")
				OrderStatus = Statuses.IN_PROGRESS.toString();
			else if(OrderStatus.toLowerCase() == "in queue")
				OrderStatus = Statuses.IN_QUEUE.toString();
			else
				OrderStatus = Statuses.COMPLETED.toString();

			Order leEntry = null;
			leEntry = orderEntries.get(i);
	
			 orderEntries.set(leEntry.getId(), new Order(
				leEntry.getId(),
	            leEntry.getItems(),
	            leEntry.getCustomerName(),
	            OrderStatus,
	            leEntry.getCreated(),
	            leEntry.getQty(),
	            leEntry.getTotal()
	            ));
		}
		 getServletContext().setAttribute("orderEntries", orderEntries);
		 response.sendRedirect("./foods");
	}
}
