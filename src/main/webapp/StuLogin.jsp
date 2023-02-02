<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel= "stylesheet" type= "text/css" href= "mystyle.css">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Student login</title>
</head>
<body>
<br><h1>Student login</h1><br>
<img src= "abes.jpg"></img><br><br>
Not a member?<a href="InsertRec.jsp">Sign Up</a>
<form action= "StudentLogin" method= "post"> 
<br>User name: <input type= "text" name= "uname" required><br>
<br>Password: <input type= "password" name= "pwd" required><br>
<br><input type= "submit" value= "Login">
</form>
</body>
</html>