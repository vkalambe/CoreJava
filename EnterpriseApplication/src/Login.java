import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Login extends HttpServlet {

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String str = "<html>" + "<head>" + "<title>Edit</title>" + "</head>"
				+ "<body>" + "<form action='FirstServlet' method=''>"
				+ "<input type='text' name='name'  /><br />"
				+ "<input type='password' name='password'  /><br />"
				+ "<input type='submit' />" + "</form>" + "</body>" + "</html>";
		PrintWriter out = response.getWriter();
		out.println(str);
		
	}

}
