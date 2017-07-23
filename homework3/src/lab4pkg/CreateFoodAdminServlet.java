package lab4pkg;

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
@WebServlet("/admin/create")
public class CreateFoodAdminServlet extends HttpServlet {
	//executes on every page load
	
			public void doGet( HttpServletRequest request, HttpServletResponse response)
				throws ServletException, IOException {
				
			    request.getRequestDispatcher("../AddFoodItem.jsp").forward(request, response);
			 
				
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
				request.setAttribute("items", entries);
				response.sendRedirect("./foods");
			}

}
