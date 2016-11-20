<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="com.Eagle.vk.DataBaseConn"%>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%
String name=request.getParameter("name");
String password=request.getParameter("password");

out.print(password);
 DataBaseConn obj=new DataBaseConn();
 
Connection conn= obj.getconn();
out.print(obj);
/*Statement statement=conn.createStatement();
String query="select * from exam1";
ResultSet rs=statement.executeQuery(query);
int flag=0;
while(rs.next())
{
	if(name.equals(rs.getString(1)) && password.equals(rs.getString(2)))
	{
		RequestDispatcher rd=request.getRequestDispatcher("Process.jsp");
		rd.forward(request, response);
		flag=1;
	}
}
if(flag == 1)
{
	response.sendRedirect("password is wrong");
	response.sendRedirect("Login.jsp");
} */
%>
</body>
</html>