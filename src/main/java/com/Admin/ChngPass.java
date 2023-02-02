package com.Admin;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ChngPass
 */
@WebServlet("/ChngPass")
public class ChngPass extends HttpServlet {
	String url= "jdbc:mysql://localhost:3306/university";
	String usrname= "root";
	String pass= "";
	String sql4= "update std_rec set pwd=? where uname=?;";
	public void updaterec(String uname, String pwd)
	{
		try {
		Class.forName("com.mysql.jdbc.Driver");
		Connection con= DriverManager.getConnection(url, usrname, pass);
		PreparedStatement st= con.prepareStatement(sql4);
		st.setString(2, uname);
		st.setString(1, pwd);
		st.executeUpdate();
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
		}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	String uname= request.getParameter("uname");
	String pwd= request.getParameter("pwd");
	updaterec(uname, pwd);
	response.sendRedirect("AdminOpt.jsp");
	}
	
}
