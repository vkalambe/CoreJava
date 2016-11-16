import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class BussinessLogic {

	public void process(String str, int amount, String name) {
		String query;
		System.out.println(str);
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/exam", "root", "root");
            Statement stmt = conn.createStatement();
			int flag = 0;
			switch (str) {
			case "withdraw":
				query = "update exam1 set balance=balance-" + amount
						+ " where name='" + name + "'";
				stmt.executeUpdate(query);
				break;
			case "deposit":
				query = "update exam1 set balance=balance+" + amount
						+ " where name='" + name + "'";
				stmt.executeUpdate(query);
				break;
			default:
				break;
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
