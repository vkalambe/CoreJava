

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class BusinessLogic extends HttpServlet {
	
  
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       String name=request.getParameter("name");
       String password=request.getParameter("password");
	if(name.equals("vishal")){
       
       
       PrintWriter out=response.getWriter();
	out.print(name);
	out.print(password);
	out.print("i am in second servlet");
	}
	
	}

	

}
