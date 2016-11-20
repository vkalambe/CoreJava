

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class FirstServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	
    	
    	
    	PrintWriter out=response.getWriter();
    	out.print("i am in first servlet");
	RequestDispatcher rd = request.getRequestDispatcher("BusinessLogic");
    rd.include(request, response);
    }

	
}
