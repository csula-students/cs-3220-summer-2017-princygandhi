package midterm1;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

 

@WebServlet("/suggest/restaurants/")
public class RestaurantHome extends HttpServlet {
	
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		ServletContext context = getServletContext();
		PrintWriter out = response.getWriter();
		List<RestaurantList> entries = ( List<RestaurantList>) getServletContext().getAttribute("entries");
		RestaurantList rendomRestaurent = getRandomRestaurant(entries);
		
		out.println("<div style='width:80%;margin: 0px auto;'>");
		out.println("<table width='100%' style='text-align:center'>");
		out.println("<tr><td colspan='3' style='height:200px'><h1>What's for lunch? </h1></td></tr>");
		out.println("<tr><td style='text-align:right;padding-right:10%;'><input type='button' onclick=\"location.href='./RandomRestaurantServlet';\" value='Feeling Lucky' /></td>"); 
		out.println("<td style='text-align:center;padding-left:10%;padding-right:10%;'><input type='button' onclick=\"location.href='./suggest/restaurants/random?id="+rendomRestaurent.getId()+"';\" value='Select Random Restaurant' /></td>"); 
		out.println("<td style='text-align:left;padding-left:10%;'><input type='button' onclick=\"location.href='./suggest/restaurants/random/list';\" value='See all list' /></td></tr>"); 
		out.println("</table></div>"); 
	}
	
	public RestaurantList getRandomRestaurant(List<RestaurantList> list) {
		return list.get(new Random().nextInt(list.size()));
	}
 
}
