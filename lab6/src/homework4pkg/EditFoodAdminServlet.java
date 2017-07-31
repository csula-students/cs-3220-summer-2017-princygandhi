package homework4pkg;

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
 * Servlet implementation class EditFoodAdminServlet
 */
@WebServlet("/hw4/AdminFoodEdit")
public class EditFoodAdminServlet extends HttpServlet {
	 
	/**
	 * 
	 */

	public void doGet( HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		
			int id = Integer.parseInt(request.getParameter("id"));
			
			List<FoodItem> entries = new ArrayList<>();
			FoodItemsDAO dao = new FoodItemsDAO();
			entries.addAll(dao.list());

			FoodItem leEntry = null;
			for (FoodItem entry: entries) {
				if (entry.getId() == id) {
					leEntry = entry;
				}
			}

			 request.setAttribute("item", leEntry);
		     request.getRequestDispatcher("/EditFoodItem.jsp").forward(request, response);
 
		}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int id = Integer.parseInt(request.getParameter("id"));
		FoodItem leEntry = null;
		leEntry = new FoodItem(id,
            request.getParameter("name"),
            request.getParameter("description"),
            request.getParameter("imgurl"),
            Double.parseDouble(request.getParameter("price"))
            );
		FoodItemsDAO dao = new FoodItemsDAO();
		dao.update(leEntry);
		
	    response.sendRedirect("./adminfoods");
	}
}
