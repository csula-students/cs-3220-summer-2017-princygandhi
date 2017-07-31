package homework4pkg;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class DeleteFoodItem
 */
@WebServlet("/hw4/DeleteFoodItem")
public class DeleteFoodItem extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 
		int id = Integer.parseInt(request.getParameter("id"));
		FoodItemsDAO dao = new FoodItemsDAO();
		dao.delete(id);
		
		request.getRequestDispatcher("/DeleteItem.jsp").forward(request, response);
	}

	 
}
