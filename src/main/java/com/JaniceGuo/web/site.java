package com.JaniceGuo.web;

import java.io.IOException;
import java.util.LinkedList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.JaniceGuo.Dao.ForComments;
import com.JaniceGuo.Dao.ForSites;
import com.JaniceGuo.model.MyComment;
import com.JaniceGuo.model.Site;

/**
 * Servlet implementation class site
 */
public class site extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name=request.getParameter("sitename");
		ForComments forComments=new ForComments();
		LinkedList<MyComment> allComments=forComments.getAllComments(name);
		Site site=new Site();
		ForSites forSites=new ForSites();
		site=forSites.getSite(name);
		request.setAttribute("site", site);
		request.setAttribute("allComments", allComments);
		RequestDispatcher requestDispatcher=request.getRequestDispatcher("site.jsp");
		requestDispatcher.forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
