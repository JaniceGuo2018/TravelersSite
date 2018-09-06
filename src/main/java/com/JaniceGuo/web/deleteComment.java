package com.JaniceGuo.web;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.JaniceGuo.Dao.ForComments;

/**
 * Servlet implementation class deleteComment
 */
public class deleteComment extends HttpServlet {
	private static final long serialVersionUID = 1L;
 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name=request.getParameter("name");
	
		HttpSession session=request.getSession();
		String username=session.getAttribute("username").toString();
		
		ForComments forComments=new ForComments();
		forComments.deleteComment(name, username);
		RequestDispatcher requestDispatcher=request.getRequestDispatcher("home");
		requestDispatcher.forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
