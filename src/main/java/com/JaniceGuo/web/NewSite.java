package com.JaniceGuo.web;

import java.io.IOException;
import java.sql.Connection;

import javax.servlet.*;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.omg.CORBA.Request;

import com.JaniceGuo.Dao.DB;
import com.JaniceGuo.Dao.ForSites;
import com.JaniceGuo.model.User;

/**
 * Servlet implementation class New
 */
public class NewSite extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Connection conn=DB.getConn("test");
		System.out.println("DB connected");
		String name=request.getParameter("name");
		String price = request.getParameter("price");
		String image = request.getParameter("image");
		float rating=Float.valueOf(request.getParameter("rating"));
		String description=request.getParameter("description");
		String location=request.getParameter("location");
		String username=request.getParameter("username");
		String cat=request.getParameter("cat");
		
		ForSites fs=new ForSites();
		fs.setSite(name, price, image, rating, description, location, username, cat);
		
		RequestDispatcher rd= request.getRequestDispatcher("home.jsp");
		rd.forward(request,response);
		
		
		
	}


	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(req, resp);
	}
	



}
