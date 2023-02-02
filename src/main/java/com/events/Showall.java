package com.events;

import java.io.IOException;


import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.sql.Statement;

/**
 * Servlet implementation class Showall
 */
@WebServlet("/Showall")
public class Showall extends HttpServlet {
	String url= "jdbc:mysql://localhost:3306/university";
	String usrname= "root";
	String pass= "";
	String sql2= "select * from event_details where date>DATE(LOCALTIME()) ;";
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	response.setContentType("text/html");
		PrintWriter out= response.getWriter();
	try {
		Class.forName("com.mysql.jdbc.Driver");
		Connection con= DriverManager.getConnection(url, usrname, pass);
		Statement st= con.createStatement();
		ResultSet rs= st.executeQuery(sql2);
		out.print("<html>");
		out.print("<body bgcolor= yellow");
		out.print("<center>");
		if(rs.next()) {
		out.print("<caption><h1>Upcoming Events</h1></caption>");
		ResultSetMetaData col= rs.getMetaData();
		out.print("<table width='50%' border='1'>");  
		int t= col.getColumnCount();
		out.print("<tr>"); 
		
		for(int i=1; i<=t; ++i)
		{
			out.println("<th>"+col.getColumnName(i)+"</th>");
		}
		out.print("</tr>");
		while(rs.next())  
		{  
		out.print("<tr><td>"+rs.getString(1)+"</td><td>"+rs.getDate(2)+"</td><td>"+rs.getString(3)+"</td><td>"+rs.getInt(4)+"</td><td>"+rs.getString(5)+"</td></tr>");  
			//out.print(rs.getString(1)+" "+rs.getDate(2)+" "+rs.getString(3)+" "+rs.getInt(4)+" "+rs.getString(5)+" ");
		}
		out.print("</table>");
		}
		else
			out.println("<h1> NO UPCOMMING EVENTS TO SHOW!!</h1>");
		out.print("</center>");
		out.print("</body>");
		out.print("</html>");
		
		} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}	
	
	}

}
