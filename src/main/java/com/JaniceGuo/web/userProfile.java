package com.JaniceGuo.web;

import java.io.IOException;
import java.util.LinkedList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.JaniceGuo.Dao.ForSites;
import com.JaniceGuo.Dao.ForUsers;
import com.JaniceGuo.model.Site;
import com.JaniceGuo.model.User;

/**
 * Servlet implementation class userProfile
 */
public class userProfile extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		ForUsers forUsers = new ForUsers();
		String username = session.getAttribute("username").toString();
		User user = forUsers.getUser(username);
		
		String userid=user.getUserid()+"";
		
		

		request.setAttribute("user", user);
		RequestDispatcher requestDispatcher = request.getRequestDispatcher("userProfile.jsp");
		requestDispatcher.forward(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
