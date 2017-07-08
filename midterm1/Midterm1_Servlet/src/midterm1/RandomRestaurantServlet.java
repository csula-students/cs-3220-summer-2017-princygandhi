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

import csnslab3.FoodItem;

 
 
/**
 * Servlet implementation class RandomRestaurantServlet
 */
@WebServlet("/suggest/restaurants/random")
public class RandomRestaurantServlet extends HttpServlet {
 
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int id = Integer.parseInt(request.getParameter("id"));
		List<RestaurantList> entries = ( List<RestaurantList>) getServletContext().getAttribute("entries");
		RestaurantList rendomRestaurent = null;
		for (RestaurantList entry: entries) {
			if (entry.getId() == id) {
				rendomRestaurent = entry;
			}
		}
	 
		PrintWriter out = response.getWriter();
		out.println("<div style='width:80%;margin: 0px auto;'>");
		out.println("<form method=\"post\">");
		out.println("<table width='100%' style='text-align:center'>");
		out.println("<tr><td colspan='2' style='height:100px'><h1>What's for lunch? </h1></td></tr>");
		out.println("<tr><td> <img src ='http://logofury.com/wp-content/uploads/11241/eat_and_more.jpg' width='200px' height='200px' /> <br/>");
		out.println("<a href='"+rendomRestaurent.getURL()+"' target='_blank'>"+rendomRestaurent.getName()+"</a></td>");
		
		out.println("<td>");
		
				out.println("<table width='100%' style='text-align:center'>");
					out.println("<thead><tr><th>Design Rating</th><th>Taste Rating</th>");
					out.println("<tr>");
						out.println("<td>");
						 //create Radio Buttons
						  for(int j = 1 ; j <= 5 ; j++)
						  {
							out.println("<input name='designRate' id=\"design_rate_"+j+"\" type=\"radio\" value=\""+j+"\"");
							if(getAvgRating(rendomRestaurent.getDesignRatings()) == j)
								out.println(" checked>");
							else
								out.println(" >");

							out.println("<label for=\"design_rate_"+j+"\">"+j+"</label> <br/>");
						  }
						out.println("</td>");
						out.println("<td>");
						   //create Radio Buttons
						 for(int k = 1 ; k <= 5 ; k++)
						  {
							out.println("<input name='tasteRate' id=\"taste_rate_"+k+"\" type=\"radio\" value=\""+k+"\"");
							if(getAvgRating(rendomRestaurent.getTasteRatings()) == k)
								out.println(" checked>");
							else
								out.println(" >");

							out.println("<label for=\"taste_rate_"+k+"\">"+k+"</label><br/>");
						  }
						
						out.println("</td>");
					out.println("</tr>");
					 
				out.println("</table>");
			
			
		out.println("</td>");
		out.println("<tr>");
		out.println("<td colspan='2' style='text-align:right;'>");
		out.println("<button>Submit Rating</button>");
		out.println("<input type='button' onclick=\"location.href='./';\" value='Back' />");
		out.println(" <input type=\"hidden\" name=\"ResID\" value=\""+ rendomRestaurent.getId()+"\">");
		out.println("</td>");
		out.println("</tr>");
		out.println("</table>");
		out.println("</form>");
		out.println("</div>");
	
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		 
		int id = Integer.parseInt(request.getParameter("id"));
		List<RestaurantList> entries = ( List<RestaurantList>) getServletContext().getAttribute("entries");
		RestaurantList rendomRestaurent = null;
		int index = -1;
		for (int i = 0; i < entries.size(); i ++) {
			if (entries.get(i).getId() == id) {
				rendomRestaurent = entries.get(i);
				index = i;
			}
		}
		
		getServletContext().setAttribute("entries", entries);
		
	}
	
	public RestaurantList getRandomRestaurant(List<RestaurantList> list) {
		return list.get(new Random().nextInt(list.size()));
	}

	public int getAvgRating(ArrayList<Integer> list)
	{
		double result = 0;
		for(int i = 0; i <list.size() ; i++)
		{
			result += list.get(i);
		}
		
		if(result > 0)
		{
			return (int) (result = (result / list.size()));
		}
		else
		{
			return 0;
		}
	}
}
