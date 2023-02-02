<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE ht>
<html>
<head>
<link rel= "stylesheet" type= "text/css" href= "mystyle.css">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert events</title>
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
<br><h1>Insert new event</h1><br>
<img src= "abes.jpg"></img><br><br>
<h5>* fields are mandatory</h5>
<form action= "InsertEvent" method= "post" onsubmit= "return validaton()">
Event name* <input type= "text" name= "ename" required><br><br>
Date* <input type= "date" name="dt"   required><br><br>
Venue* <input type= "text" name= "venue" required><br><br>
Fees <input type= "text" name= "fees"><br><br>
About*(not more than 50 characters) <input type= "text" name= "abt" required><br><br>
<input type= "submit" value= "Insert event"><br><br>
</form>
<form action= "Logout" method= "post">
<input type= "submit" value= "Logout">
</form>
</body>
</html>