package lab4pkg;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.SimpleTagSupport;


public class CustomerHeader extends SimpleTagSupport {
	
	public void doTag() throws JspException, IOException {
		JspWriter out = getJspContext().getOut();
		out.print("<header>");
			out.print("<section class='container'>");
				out.print("<img class='img' src='https://static.pexels.com/photos/51115/restaurant-wine-glasses-served-51115.jpeg' />");
				out.print("<h1 class='hdFont'>Princy's Restaurant </h1>");
				out.print(" <span class='fill'></span>");
					out.print("<nav>");
						out.print("<a href='./restaurant'>Menu</a> |");
						out.print("<a href='./order'>Order</a> |");
						out.print("<a href='./OrderStatus'>Order Status</a> |");
						out.print("<a href='../admin/foods'>Admin View</a>");
					out.print("</nav>");
			out.print("</section>");
			out.print("<hr />");
		out.print("</header>");
		
		
	}

}
