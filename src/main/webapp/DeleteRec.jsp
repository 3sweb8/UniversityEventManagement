<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel= "stylesheet" type= "text/css" href= "mystyle.css">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Delete records</title>
</head>
<body>
<%
response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");//http 1.1
response.setHeader("Pragma", "no-cache");//http 1.0
response.setHeader("Expires", "0");//proxies
if(session.getAttribute("username")=="admin")
{
	response.sendRedirect("AdminLogin.jsp");
	}
%>
<br><h1>Delete records</h1><br>
<img src= "abes.jpg"></img><br><br>
<form action= "DeleteRec" method= "post">
Enter username: <input type= "text" name= "uname" required>
<input type= "submit" value= "Delete"><br>
</form>
<form action= "Logout" method= "post">
<br><input type= "submit" value= "Logout">
</form>
</body>
</html>