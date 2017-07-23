package lab4pkg;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/admin/foods")
public class RestaurantAdminServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	public void doGet( HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
			
		ServletContext context = getServletContext();
		if(context == null)
		{
			   List<FoodItem> entries = new ArrayList<>();
			   entries.add(new FoodItem(entries.size(), "Chipotle","Mexican Food","https://blogs.hopkins-interactive.com/2019/files/Chipotle_Barbacoa_Bowl_2x.jpg",9.99));
			   entries.add(new FoodItem(entries.size(), "Hamburger","Americal Food","http://www.in-n-out.com/images/menu_v2/cheeseburger_meal.png",10.99));
			   entries.add(new FoodItem(entries.size(), "Pizza","Americal Food","https://s-media-cache-ak0.pinimg.com/originals/22/52/a9/2252a9064d6aa07990f9c8b8c5644b61.jpg",12.99));
			   getServletContext().setAttribute("entries", entries);
		}
		List<FoodItem> entries = ( List<FoodItem>) getServletContext().getAttribute("entries");

		String removeItem =request.getParameter("removeItem");
		if(removeItem!=null)
		{
			for(FoodItem entry : entries)
			{
				if(entry.getId() == Integer.parseInt(removeItem))
				{
					entries.remove(entry);
				}
			}
		}
		
		context.setAttribute("entries", entries);
		request.setAttribute("items", entries);
		request.getRequestDispatcher("../Inventory.jsp").forward(request, response);
	}

}
