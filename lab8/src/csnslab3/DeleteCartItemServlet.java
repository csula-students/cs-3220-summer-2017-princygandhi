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
 * Servlet implementation class DeleteFoodAdminServlet
 */
@WebServlet("/shopping-cart/delete")
public class DeleteCartItemServlet extends HttpServlet {
	public void doGet( HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
				int id = Integer.parseInt(request.getParameter("id"));
				List<Order> entries = (List<Order>) getServletContext().getAttribute("orderEntries");
				int index = -1;
				for (int i = 0; i < entries.size(); i ++) {
					if (entries.get(i).getId() == id) {
						index = i;
					}
				}
				entries.remove(index);
				getServletContext().setAttribute("orderEntries", entries);
		
				response.setContentType("text/html");
				PrintWriter out = response.getWriter();
				out.println("<a href='../shopping-cart'>Go back to order list </a>");
		}

}
