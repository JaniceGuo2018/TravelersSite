package com.JaniceGuo.web;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.JaniceGuo.Dao.ForComments;
import com.JaniceGuo.Dao.ForSites;

/**
 * Servlet implementation class NewComment
 */
public class NewComment extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name = request.getParameter("name");
		float rating=Float.valueOf(request.getParameter("rating"));
		String username = request.getParameter("username");
		String comment =request.getParameter("comment");
		
		ForComments fc=new ForComments();
		fc.setComment(name, rating, comment, username);
		
		ForSites fSites=new ForSites();
		request.setAttribute("sites", fSites.getAllSites());
		RequestDispatcher rd= request.getRequestDispatcher("home.jsp");
		rd.forward(request,response);
		
	}


	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(req, resp);
	}
	



}
