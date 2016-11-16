
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.websocket.Session;

public class DataBaseServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException,
			NullPointerException {
		PrintWriter p = response.getWriter();

		String name = request.getParameter("name");
		String password = request.getParameter("password");
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/exam", "root", "root");

			String query = "select * from exam1";

			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(query);
			int flag = 0;

			while (rs.next()) {

				if (name.equals(rs.getString(1))
						&& password.equals(rs.getString(2))) {
                    System.out.println("in get method");
				    flag = 1;
					HttpSession ses = request.getSession(true);
					HttpSession bal = request.getSession(true);
					ses.setAttribute("name", name);
					bal.setAttribute("bal", rs.getInt(3));
					response.sendRedirect("MenuClass");
					}

			}
			if (flag == 0) {

				//response.sendRedirect("Home.html");
				p.print("username/password wrong");
				p.print("<a href='Home.html'> BACK</a>");
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}catch(NullPointerException e)
		{ 
			//p.print("session not set");
	    }
		 

	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String name = request.getParameter("name");
		String password = request.getParameter("password");
		String repassword = request.getParameter("repassword");
		
		if (password.equals(repassword)) {
			try {
				PrintWriter p = response.getWriter();

				Class.forName("com.mysql.jdbc.Driver");
				Connection conn = DriverManager.getConnection(
						"jdbc:mysql://localhost:3306/exam", "root", "root");
                   
				System.out.println(name);
				
				
				
				
				PrintWriter p1;
				p1 = response.getWriter();
				HttpSession ses = request.getSession();
				ses.setAttribute("name", name);
				p.print("welcome " + " " + ses.getAttribute("name"));

				p1.print("<a href='BussinessLogic'>withdraw</a>");
				p1.print("<a href='BussinessLogic'>Deposit</a>");
				

				
                 Statement stmt = conn.createStatement();
				String query = "INSERT INTO exam1 VALUES (?,?)";
				//stmt.execute(query);
				   PreparedStatement preparedStmt = conn.prepareStatement(query);
				      preparedStmt.setString (1, name);
				      preparedStmt.setString (2, password);
				     
				      preparedStmt.execute();
				      
			

			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}else{
		response.sendRedirect("Home.html");
	}

}
}
