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
 * Servlet implementation class EditFoodAdminServlet
 */
@WebServlet("/admin/foods/edit")
public class EditFoodAdminServlet extends HttpServlet {
	 
	/**
	 * 
	 */

	public void doGet( HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
			int id = Integer.parseInt(request.getParameter("id"));
			List<FoodItem> entries = (List<FoodItem>) getServletContext().getAttribute("entries");
			FoodItem leEntry = null;
			for (FoodItem entry: entries) {
				if (entry.getId() == id) {
					leEntry = entry;
				}
			}

			response.setContentType("text/html");
			PrintWriter out = response.getWriter();
			out.println("<h1>Editing Food Item</h1>");
			out.println("<form method=\"post\">");
			out.println("Food Item:<br/> <input name='name' type='text' value='" + leEntry.getName() + "'/></br></br>");
			out.println("Description: <br/><textarea name='description'>" + leEntry.getDescription() + "</textarea></br></br>");
			out.println("Image URL: <br/><input type='text' name='imgURL'  value='" + leEntry.getImgURL() + "'/></br></br>");
			out.println("Price: <br/><input type='text' name='price' value='" + leEntry.getPrice() + "'/></br></br>");
			out.println("<button>Update</button>");
			out.println("</form>");
		}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		List<FoodItem> entries = (List<FoodItem>) getServletContext().getAttribute("entries");
		FoodItem leEntry = null;
		int index = -1;
		for (int i = 0; i < entries.size(); i ++) {
			if (entries.get(i).getId() == id) {
				leEntry = entries.get(i);
				index = i;
			}
		}
		entries.set(index, new FoodItem(
			leEntry.getId(),
            request.getParameter("name"),
            request.getParameter("description"),
            request.getParameter("imgURL"),
            Double.parseDouble(request.getParameter("price"))
            ));
		getServletContext().setAttribute("entries", entries);

		PrintWriter out = response.getWriter();
		out.println("<a href='../foods'>Go back to restaurant item list </a>");
	}
}
