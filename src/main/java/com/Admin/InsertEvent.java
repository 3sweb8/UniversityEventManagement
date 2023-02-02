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
 * Servlet implementation class InsertEvent
 */
@WebServlet("/InsertEvent")
public class InsertEvent extends HttpServlet {
	String url= "jdbc:mysql://localhost:3306/university";
	String usrname= "root";
	String pass= "";
	String sql3= "insert into event_details values (?, ?, ?, ?, ?);";
	public void inserteve(String ename, String dt, String venue, String fees, String abt)
	{
		try {
		Class.forName("com.mysql.jdbc.Driver");
		Connection con= DriverManager.getConnection(url, usrname, pass);
		PreparedStatement st= con.prepareStatement(sql3);
		st.setString(1, ename);
		st.setString(2, dt);
		st.setString(3, venue);
		st.setString(4, fees);
		st.setString(5, abt);
		st.executeUpdate();
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
		}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String ename= request.getParameter("ename");
		String dt= request.getParameter("dt");
		String venue= request.getParameter("venue");
		String fees= request.getParameter("fees");
		String abt= request.getParameter("abt");
		inserteve(ename, dt, venue, fees, abt);
		response.sendRedirect("AdminOpt.jsp");

	}

}
