package com.JaniceGuo.web;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.JaniceGuo.Dao.ForSites;
import com.JaniceGuo.Dao.ForUsers;
import com.mysql.cj.Session;
import com.mysql.cj.exceptions.RSAException;

/**
 * Servlet implementation class editSite
 */
public class editUserProfile extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session=request.getSession();
		String username=session.getAttribute("username").toString();
		
		String  password= request.getParameter("password");
		String avatar = request.getParameter("avatar");
		String email=request.getParameter("email");
		String intro=request.getParameter("intro");
	
		
		ForUsers forUsers=new ForUsers();
		forUsers.editUser(username,password, avatar, email, intro);
		
		response.sendRedirect("home");
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
