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
 
@WebServlet(loadOnStartup=1, urlPatterns={"/suggest/restaurants/random/list"})
public class RandomRestaurantListServlet extends HttpServlet {

	public void init() 
	{
		   List<RestaurantList> entries = new ArrayList<>();
		   ArrayList<Integer> desRat = new ArrayList<Integer>();
		   ArrayList<Integer> tstRate = new ArrayList<Integer>();
		   for(int i = 1 ; i <= 22 ; i++)
		   {  
			   String num = "";
			   num = (i < 10 ? "0" : "") + i;
			   entries.add(new RestaurantList(i, 
							   "cs3220xstu" + num,
							   "http://cs3.calstatela.edu:8080/cs3220xstu"+ num +"/menu",
							   desRat,
							   tstRate,
							   0)
					   	   );
		   } 
		   getServletContext().setAttribute("entries", entries);  
	}
	
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		   ServletContext context = getServletContext();
		    PrintWriter out = response.getWriter();
			List<RestaurantList> entries = ( List<RestaurantList>) getServletContext().getAttribute("entries");
			out.println("<div style='width:80%;margin: 0px auto'><h1> List of Restaurants </h1> <hr/>");
			out.println("<table width='100%' cell-padding='5' style='text-align:center;'>");
			out.println("<thead><tr><th>Name</th><th>URL</th><th>Design</th><th>Taste</th><th>Reviewer</th></tr></thead>");
			for(RestaurantList entry : entries)
			{
				out.println("<tr>" +
			                "<td>" + entry.getName() + " </td> " +
			                "<td>" + entry.getURL() + " </td> " +
			                "<td>" + getAvgRating(entry.getDesignRatings()) + " </td> " +
			                "<td>" + getAvgRating(entry.getTasteRatings()) + " </td> " +
			                "<td>" + entry.getTotalReviews() + " </td> " +
						    "<tr>");
				
			
			}
			
			out.println("</table>");
			context.setAttribute("entries", entries);
	}
	
	public double getAvgRating(ArrayList<Integer> list)
	{
		double result = 0;
		for(int i = 0; i <list.size() ; i++)
		{
			result += list.get(i);
		}
		
		if(result > 0)
		{
			return result = (result / 5);
		}
		else
		{
			return 0;
		}
	}


}
