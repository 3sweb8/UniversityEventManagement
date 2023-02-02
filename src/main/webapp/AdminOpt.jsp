<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel= "stylesheet" type= "text/css" href= "mystyle.css">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Admin</title>
</head>
<body>
<%
response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");//http 1.1
response.setHeader("Pragma", "no-cache");//http 1.0
response.setHeader("Expires", "0");//proxies
if(session.getAttribute("username")==null)
{
	response.sendRedirect("ShowEventDetails.jsp");
	}
%>
<br>Welcome ${username}<br><br>
<img src= "abes.jpg"></img><br><br>
<a href= "InsertRec.jsp"> 
<br><input type= "button" value= "Insert new records"><br>
</a>
<a href= "InsertEvent.jsp"> 
<br><input type= "button" value= "Insert new Events"><br>
</a>
<a href= "UpdateEvent.jsp"> 
<br><input type= "button" value= "Update events"><br>
</a>
<a href= "ChngPass.jsp"> 
<br><input type= "button" value= "Change password"><br>
</a>
<a href= "DeleteEve.jsp"> 
<br><input type= "button" value= "Delete events"><br>
</a>
<form action= "DeletePast" method= "post">
<br><input type= "submit" value= "Delete past events"><br>
</form>
<a href= "DeleteRec.jsp"> 
<br><input type= "button" value= "Delete Record"><br>
</a>
<form action= "Logout" method= "post">
<br><input type= "submit" value= "Logout"><br>
</form>
</body>
</html>