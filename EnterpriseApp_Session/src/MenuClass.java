import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class MenuClass extends HttpServlet {

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		BussinessLogic obj = new BussinessLogic();
		PrintWriter out = response.getWriter();
		HttpSession bal = request.getSession(false);
		HttpSession ses = request.getSession(false);
		out.print(bal.getAttribute("bal"));
		if (request.getParameter("event") != null) {
			int amount = Integer.parseInt(request.getParameter("amount"));
			String name = (String) ses.getAttribute("name");
			String choice = request.getParameter("event");
			obj.process(choice, amount, name);
			out.print(" successfully done");
		}
		out.print("<html>" + "<head>" + "<meta charset='ISO-8859-1'>"
				+ "<title>Insert title here</title>" + "</head>" + "<body>"
				+ "<form action='MenuClass' method='get'>" + "<h1>welcome</h1>"
				+ "<h5>enter the amount to be deposit/withdraw</h5>"
				+ "<input type='text' name='amount'/>"
				+ "<input type='submit' value='withdraw' name='event'>"
				+ "<input type='submit' value='deposit' name='event'>"
				+ "</form>" + "</body>" + "</html>");

	}

}
