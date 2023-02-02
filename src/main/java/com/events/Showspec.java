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
 * Servlet implementation class Showspec
 */
@WebServlet("/Showspec")
public class Showspec extends HttpServlet {
	String url= "jdbc:mysql://localhost:3306/university";
	String usrname= "root";
	String pass= "";
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String cat= request.getParameter("ctg");
		String val= request.getParameter("val").toLowerCase();
		val="'%"+val+"%'";
		PrintWriter out= response.getWriter();
		String sql6= "select * from event_details where"+" LOWER(CONVERT("+cat+",CHAR)) like "+val+" ;";
	try {
		Class.forName("com.mysql.jdbc.Driver");
		Connection con= DriverManager.getConnection(url, usrname, pass);
		Statement st= con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE);
		//st.setString(1, "%"+val+"%");
//		st.setString(2, ser);
//		st.setString(3, ser);
		ResultSet rs= st.executeQuery(sql6);
		out.print("<html>");
		out.print("<body bgcolor= yellow>");
		out.print("<center>");
		if(rs.next()) {
			rs.beforeFirst();
		
		out.print("<table width=50% border=1>"); 
		out.print("<caption><h1>Your result</h1></caption>");
		ResultSetMetaData col= rs.getMetaData();
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
		}
		out.print("</table>");
		}
		else
			out.println("<h1> No  such Events Found!!</h1>");
		out.print("</center>");
		out.print("</body>");
		out.print("</html>"); 
		} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}	
	

	}

}
