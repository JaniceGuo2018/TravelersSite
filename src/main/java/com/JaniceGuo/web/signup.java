package com.JaniceGuo.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.naming.ldap.Rdn;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.JaniceGuo.Dao.ForUsers;
import com.JaniceGuo.model.User;

/**
 * Servlet implementation class signup
 */
public class signup extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ForUsers forUsers=new ForUsers();
		String username = request.getParameter("username");
		String passwd = request.getParameter("password");
		String firstName = request.getParameter("firstName");
		String lastName=request.getParameter("lastName");
		String avatar=request.getParameter("avatar");
		String adminCode=request.getParameter("adminCode");
		String email=request.getParameter("email");
		String intro=request.getParameter("intro");
		
		User user=forUsers.getUser(username);
		System.out.println(user);
		if (user.getAvatar()!=null) {
			request.setAttribute("alert", "true");
			RequestDispatcher requestDispatcher=request.getRequestDispatcher("SignUp.jsp");
			requestDispatcher.forward(request, response);
		}else {
			forUsers.setUser(username, passwd, firstName, lastName, avatar, adminCode, email, intro);
			RequestDispatcher requestDispatcher=request.getRequestDispatcher("login.jsp");
			requestDispatcher.forward(request, response);
		}
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
