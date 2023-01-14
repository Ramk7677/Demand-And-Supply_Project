package com.DemandAPI;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/login")
public class login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		
		String username=request.getParameter("admin_username");
		String password=request.getParameter("admin_password");
		
		if(LoginValidation.validate(username , password)) {
			RequestDispatcher rd=request.getRequestDispatcher("admin_page.html");
			try {
				rd.forward(request, response);
			}
			catch (ServletException | IOException e) {
	             e.printStackTrace();
			}
		}
		else {
			RequestDispatcher rd=request.getRequestDispatcher("index.html");
			try {
				rd.include(request, response);
			}
			catch (ServletException | IOException e) {
			e.printStackTrace();
			}
		}
		out.close();
	}

}
