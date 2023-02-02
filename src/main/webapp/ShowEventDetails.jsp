<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel= "stylesheet" type= "text/css" href= "mystyle.css">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Student</title>
</head>
<body>
<%
response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");//http 1.1
response.setHeader("Pragma", "no-cache");//http 1.0
response.setHeader("Expires", "0");//proxies
if(session.getAttribute("username")==null)
{
	response.sendRedirect("StuLogin.jsp");
	}
%>
<br>Welcome ${username}
<br><br><img src= "abes.jpg"></img><br><br>
<form action= "Showall" method= "post"> 
<br><input type= "submit" value= "Show all upcoming events">
</form>
<form action= "Showspec" method= "post"> 
<br>
<label for="cat">Search By:</label>
<select  name="ctg">
<option value="name">Name</option>
<option value="date">Date(yyyy-mm-dd)</option>
<option value="venue">Venue</option>
</select>
<br><br>
Value:<input type="text" name="val"><br>
<input type= "submit" value= "Search"><br>
</form>
<form action= "Logout" method="post">
<br><input type= "submit" value= "Logout">
</form>
</body>
</html>