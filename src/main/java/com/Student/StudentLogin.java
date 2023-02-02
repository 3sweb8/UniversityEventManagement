package com.Student;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


/**
 * Servlet implementation class StudentLogin
 */
@WebServlet("/StudentLogin")
public class StudentLogin extends HttpServlet {
	String url= "jdbc:mysql://localhost:3306/university";
	String usrname= "root";
	String pass= "";
	String sql= "select * from std_rec where uname= ? and pwd= ?;";
	public boolean check(String uname, String pwd)
	{
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con= DriverManager.getConnection(url, usrname, pass);
			PreparedStatement st= con.prepareStatement(sql);
			st.setString(1, uname);
			st.setString(2, pwd);
			ResultSet rs= st.executeQuery();
			if(rs.next())
			{
				return true;
			}
		} catch (Exception e) {
						e.printStackTrace();
		}
		return false;
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String uname= request.getParameter("uname");
		String pwd= request.getParameter("pwd");
		if(check(uname, pwd))
		{
			HttpSession session= request.getSession();
			session.setAttribute("username", uname);
			response.sendRedirect("ShowEventDetails.jsp");
		}
		else
		{
			response.sendRedirect("StuLogin.jsp");
		}
	}

}
