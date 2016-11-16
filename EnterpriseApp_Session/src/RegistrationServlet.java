

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class RegistrationServlet extends HttpServlet {

protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	 

    	PrintWriter out;
		
			out = response.getWriter();
			out.print("<html>"+
	    			"<head>"+
	    			"<meta charset='ISO-8859-1'>"+
	    			"<title>Insert title here</title>"+
	    			"</head>"+
	    			"<body>"+
	    			"<form action='DataBaseServlet' method='post'>"+
	    			"<h1>welcome vishal</h1>"+
	    			"<h5>NAME:</h5>"+
	    		    "<input type='text' name='name'/>"+
	    			"<h5>PASSWORD</h5>"+
	    			"<input type='password' name='password'/>"+
	    			"<h5>REPASSWORD</h5>"+
	    			"<input type='password' name='repassword'/>"+
	    			"<input type='submit'>"+
	    			"</form>"+
	    			"</body>"+
	    			"</html>");
			RequestDispatcher rd=request.getRequestDispatcher("DataBaseServlet");
			
				rd.include(request, response);
		
	
    	
    	
	
	}

	
}
