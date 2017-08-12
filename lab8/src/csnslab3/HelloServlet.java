package csnslab3;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class HelloServlet
 */
@WebServlet("/HelloServlet")

public class HelloServlet extends HttpServlet {
	public void init() {
		getServletContext().setAttribute("counter", 0);
	}
	public void doGet( HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException {
		ServletContext context = getServletContext();
		int counter = (int) context.getAttribute("counter");
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println("<h1> Hello world! </h1> <p>Counter : " + counter + "</p>");
		counter ++;
		context.setAttribute("counter", counter);
	}
}
