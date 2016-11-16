

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class LoginServlet extends HttpServlet {

protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	 

    	PrintWriter out;
		
			out = response.getWriter();
			out.print("<html>"+
	    			"<head>"+
	    			"<meta charset='ISO-8859-1'>"+
	    			"<title>Insert title here</title>"+
	    			"</head>"+
	    			"<body>"+
	    			"<form action='DataBaseServlet' method='get'>"+
	    			"<h1>welcome vishal</h1>"+
	    			"<h5>NAME:</h5>"+
	    		    "<input type='text' name='name'/>"+
	    			"<h5>PASSWORD</h5>"+
	    			"<input type='password' name='password'/>"+
	    			"<input type='submit' name='BtnSubmit'>"+
	    			"</form>"+
	    			"</body>"+
	    			"</html>");
			RequestDispatcher rd=request.getRequestDispatcher("DataBaseServlet");
			
				rd.include(request, response);
		
	
    	
    	
	
	}

	
}
