package com.DemandAPI;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.http.HttpServlet;

public class LoginValidation extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public static boolean validate(String username, String password) {
       boolean status= false;
		
       Connection con=null;
       PreparedStatement pstmt=null;
       ResultSet rs=null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/demand_supply", "root" , "Ram123@");
			pstmt=con.prepareStatement("select admin_username , admin_password from user where admin_username=? and  admin_password=? ");
			
			pstmt.setString(1, username);
			pstmt.setString(2, password);
			
			rs=pstmt.executeQuery();
			status=rs.next();
		}
		catch(Exception e){
			System.out.println(e);
		}
		return status;
	}

}
