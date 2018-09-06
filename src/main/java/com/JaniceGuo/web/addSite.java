package com.JaniceGuo.web;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.JaniceGuo.Dao.ForSites;

/**
 * Servlet implementation class addSite
 */
public class addSite extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public addSite() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name = request.getParameter("name");
		String price = request.getParameter("price");
		String image = request.getParameter("image");
		float rating=Float.valueOf(request.getParameter("rating"));
		String description=request.getParameter("description");
		String location=request.getParameter("location");
		String username=request.getParameter("username");
		String cat=request.getParameter("cat");
		description = description.replaceAll("\n" , "<br>");
		
		ForSites forSites=new ForSites();
		forSites.setSite(name, price, image, rating, description, location, username, cat);
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
