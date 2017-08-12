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
 * Servlet implementation class CreateFoodAdminServlet
 */
@WebServlet("/admin/foods/create")
public class CreateFoodAdminServlet extends HttpServlet {
	//executes on every page load
	
			public void doGet( HttpServletRequest request, HttpServletResponse response)
				throws ServletException, IOException {
				response.setContentType("text/html");
				PrintWriter out = response.getWriter();
				
				out.println("<form method=\"post\">");
				out.println("Item Name: <br/><input type='text' name='name' /><br/>");
				out.println("Description: <br/><textarea name='description'></textarea/><br/>");
				out.println("Image URL: <br/><input type='text' name='imgURL' /><br/>");
				out.println("Price: <br/><input type='text' name='price' /><br/>");
				out.println("<button>Add</button>");
				out.println("</form>");
				out.println("<a href='../foods'>Go back to restaurant item list </a>");
				
			}
			
			@Override
			public void doPost( HttpServletRequest request, HttpServletResponse response)
					throws ServletException, IOException {
				
				List<FoodItem> entries = ( List<FoodItem>) getServletContext().getAttribute("entries");
				entries.add(new FoodItem(entries.size(), 
						                 request.getParameter("name"),
						                 request.getParameter("description"),
						                 request.getParameter("imgURL"),
						                 Double.parseDouble(request.getParameter("price"))
						                 ));
				getServletContext().setAttribute("entries", entries);
				//System.out.println(request.getParameter("name"));
				//System.out.println(request.getParameter("comment"));
				PrintWriter out = response.getWriter();
				out.println("<a href='../foods'>Go back to restaurant item list </a>");
			}

}
