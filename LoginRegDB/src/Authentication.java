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

/**
 * Servlet implementation class AuthenticationUser
 */
public class Authentication extends HttpServlet {

	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Authentication() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

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
					p.print("welcome "+ " "+name);

					flag = 1;
				}
			}
			if (flag == 0) {
				p.print("username/password wrong");

			}

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
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
		}
	}

}
