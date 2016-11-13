import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.AbstractButton;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;


public class DemoMain extends JFrame implements ActionListener{
	 static Connection conn;
	 static Statement stmt;
	 static String query;
	 static ResultSet rs;
	   static
	  {try {
		Class.forName("com.mysql.jdbc.Driver");
		  conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/user", "root", "root");
		   stmt=conn.createStatement();
		   query="select * from emp";
		  rs=stmt.executeQuery(query);
	} catch (ClassNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	  }
	  
	JTextField txt;
	JButton btnNext;
	JButton btnPrev;
	JButton btnLast;
	JButton btnFirst;
	public DemoMain() {
        txt =new JTextField(20);
        btnFirst=new JButton("FIRST");
        btnLast=new JButton("LAST");
        btnNext=new JButton("NEXT");
        btnPrev=new JButton("PREV");
        
        setLayout(new FlowLayout());
        add(txt);
        add(btnFirst);
        add(btnLast);
        add(btnNext);
        add(btnPrev);
        
        btnFirst.addActionListener(this);
        btnLast.addActionListener(this);
        btnNext.addActionListener(this);
        btnPrev.addActionListener(this);
	}

	public static void main(String[] args) {
		DemoMain obj=new DemoMain();
		obj.setVisible(true);
		obj.setSize(600, 600);
	
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
  	String choice=((JButton) e.getSource()).getText();
  	
  	try {
		switch (choice) {
		case "FIRST":
			rs.first();
			txt.setText(rs.getString(2));
			break;
		case "LAST":
			rs.last();
			txt.setText(rs.getString(2));
			break;
		case "PREV":
			rs.previous();
			txt.setText(rs.getString(2));			
			break;
		case "NEXT":
			rs.next();
			txt.setText(rs.getString(2));
			break;
		default:
			break;
		}
	} catch (SQLException e1) {
		// TODO Auto-generated catch block
		e1.printStackTrace();
	}
		
		
	}

}
