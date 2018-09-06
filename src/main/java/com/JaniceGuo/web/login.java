package com.JaniceGuo.web;

import java.io.IOException;
import java.util.LinkedList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.JaniceGuo.Dao.ForRecom;
import com.JaniceGuo.Dao.ForUsers;
import com.JaniceGuo.model.User;
import com.JaniceGuo.model.UserRecom;

import javafx.scene.control.Alert;

/**
 * Servlet implementation class login
 */
public class login extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username=request.getParameter("username");
		String password=request.getParameter("password");
		
		ForUsers forUsers=new ForUsers();
		User user=forUsers.getUser(username, password);
		if (user.getAvatar() != null) {
			HttpSession session = request.getSession();
			session.setAttribute("username", username);
			request.setAttribute("user", user);
			ForRecom forRecom=new ForRecom();
			LinkedList<UserRecom> userRecoms=forRecom.readCSV("d://writers.csv");
			request.setAttribute("userRecom", userRecoms);
			RequestDispatcher requestDispatcher=request.getRequestDispatcher("userProfile.jsp");
			requestDispatcher.forward(request, response);
		}else {
			request.setAttribute("alert", "true");
			RequestDispatcher requestDispatcher=request.getRequestDispatcher("login.jsp");
			requestDispatcher.forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
