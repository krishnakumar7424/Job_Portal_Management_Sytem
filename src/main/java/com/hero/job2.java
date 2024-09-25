package com.hero;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class job2 extends HttpServlet
{
	Connection con = null;
	PreparedStatement ps = null;
	
	
	@Override
	public void init() throws ServletException
	{
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			System.out.println("Drivers Loaded");
			
			con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","krishna","besant");

			System.out.println("Connection Established");
			
		} 
		catch (ClassNotFoundException | SQLException e) 
		{
			
			e.printStackTrace();
		}
		
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
	{
		try
		{
			ps = con.prepareStatement("insert into job values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
			String firstname = req.getParameter("fn");
			String lastname = req.getParameter("ln");
			String emailid = req.getParameter("email");
			String gender = req.getParameter("gender");
			String phoneno = req.getParameter("phone");
			String yearofpass = req.getParameter("yearofpasss");
			String dob = req.getParameter("dob");
			String state = req.getParameter("state1");
			String address = req.getParameter("address");
			String pgcollege = req.getParameter("pc");
			String pgdegree = req.getParameter("pd");
			String pgmarks = req.getParameter("pm");
			String pggrade = req.getParameter("pg");
			String ugcollege = req.getParameter("uc");
			String ugdegree = req.getParameter("ud");
			String ugmarks = req.getParameter("um");
			String uggrade = req.getParameter("ug");
			String pucollege = req.getParameter("puc");
			String pugroup = req.getParameter("pug");
			String pumarks = req.getParameter("pum");
			String pugrade = req.getParameter("pugg");
			String sscschool = req.getParameter("sss");
			String sscgroup = req.getParameter("ssg");
			String sscmarks = req.getParameter("ssm");
			String sscgrade = req.getParameter("ssg");
			String status = req.getParameter("bt");
			String resume = req.getParameter("resume");
			String currentsalary = req.getParameter("cs");
			String expectedsalary = req.getParameter("es");
			String preferredlocation = req.getParameter("pl");
			String skillset = req.getParameter("ss");
			
			
			
			ps.setString(1, firstname);
			ps.setString(2, lastname);
			ps.setString(3, emailid);
			ps.setString(4, gender);
			ps.setString(5, phoneno);
			ps.setString(6, yearofpass);
			ps.setString(7, dob);
			ps.setString(8, state);
			ps.setString(9, address);
			ps.setString(10, pgcollege);
			ps.setString(11, pgdegree);
			ps.setString(12, pgmarks);
			ps.setString(13, pggrade);
			ps.setString(14, ugcollege);
			ps.setString(15, ugdegree);
			ps.setString(16, ugmarks);
			ps.setString(17, uggrade);
			ps.setString(18, pucollege);
			ps.setString(19, pugroup);
			ps.setString(20, pumarks);
			ps.setString(21, pugrade);
			ps.setString(22, sscschool);
			ps.setString(23, sscgroup);
			ps.setString(24, sscmarks);
			ps.setString(25, sscgrade);
			ps.setString(26, status);
			ps.setString(27, resume);
			ps.setString(28, currentsalary);
			ps.setString(29, expectedsalary);
			ps.setString(30, preferredlocation);
			ps.setString(31, skillset);
			
			
			ps.executeUpdate();
			
			
			
			
			PrintWriter pw = resp.getWriter();
			pw.println(" <h1><center> REGISTRATION SUCCESSFULLY</center></h1> ");
		} 
		catch (SQLException e) 
		{
			
			e.printStackTrace();
		}

	}
}

