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
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class InsertRec
 */
@WebServlet("/InsertRec")
public class InsertRec extends HttpServlet {
	String url= "jdbc:mysql://localhost:3306/university";
	String usrname= "root";
	String pass= "";
	String sql3= "insert into std_rec values (?,?);";
	public void insertrec(String uname, String pwd)
	{
		try {
		Class.forName("com.mysql.jdbc.Driver");
		Connection con= DriverManager.getConnection(url, usrname, pass);
		PreparedStatement st= con.prepareStatement(sql3);
		st.setString(1, uname);
		st.setString(2, pwd);
		int c=st.executeUpdate();
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
		}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	String uname= request.getParameter("uname");
	String pwd= request.getParameter("pwd");
	insertrec(uname, pwd);
	response.sendRedirect("ShowEventDetails.jsp");
	}
	}

