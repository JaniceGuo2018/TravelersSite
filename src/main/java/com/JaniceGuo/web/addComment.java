package com.JaniceGuo.web;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.JaniceGuo.Dao.ForComments;

/**
 * Servlet implementation class addComment
 */
public class addComment extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name = request.getParameter("name");
		float rating=Float.valueOf(request.getParameter("rating"));
		String username = request.getParameter("username");
		String comment =request.getParameter("comment");
		
		ForComments forComments=new ForComments();
		forComments.setComment(name, rating, comment, username);
		RequestDispatcher requestDispatcher=request.getRequestDispatcher("site?sitename="+name);
		requestDispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
