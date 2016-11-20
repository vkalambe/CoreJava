<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"  import="com.Eagle.vk.BusinessLogic"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form action="Process.jsp">
<input type="text" name="amount" >
<input type="submit" name="Event" value="Deposit">
<input type="submit" name="Event" value="Withdraw">
<input type="submit" name="Event" value="Details">
<input type="submit" name="Event" value="Logout">

</form>
<%
String name=request.getParameter("name");
BusinessLogic obj=new BusinessLogic();
String choise=request.getParameter("Event");
int amount=Integer.parseInt(request.getParameter("amount"));
out.print(choise);
switch(choise) 
{
case "Deposit":
	obj.Deposit(name,amount);
	break;
case "Withdraw":
	obj.Withdraw(name,amount);
	break;
case "Details":
	obj.Details(name);
	break;
case "Logout":
	
	break;
default:
	break;
}

%>
</body>
</html>