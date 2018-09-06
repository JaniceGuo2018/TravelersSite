package com.JaniceGuo.web;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.JaniceGuo.Dao.ForSites;
import com.mysql.cj.exceptions.RSAException;

/**
 * Servlet implementation class editSite
 */
public class editSite extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String site=request.getParameter("site");
		System.out.println(site);
		String name = request.getParameter("name");
		String price = request.getParameter("price");
		String image = request.getParameter("image");
		float rating=Float.valueOf(request.getParameter("rating"));
		
		String description=request.getParameter("description");
		String location=request.getParameter("location");
		String cat=request.getParameter("cat");
		
		ForSites forSites=new ForSites();
		forSites.editSite(site, name, price, image, rating, description, location, cat);
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
