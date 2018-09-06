<%@page import="com.sun.xml.internal.bind.v2.runtime.reflect.ListIterator"%>
<%@page import="java.util.LinkedList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.*,com.JaniceGuo.model.*"%>
<%
	Site site=new Site();
	site=(Site)request.getAttribute("site");
	
	LinkedList<MyComment> allComments=(LinkedList<MyComment>) request.getAttribute("allComments");
	
	
%>

<jsp:include page="header.jsp" flush="true"></jsp:include>

<body>


    <div class="container-fluid">
      <div class="row">
        <nav class="col-md-2 d-none d-md-block bg-light sidebar">
          <div class="sidebar-sticky">
            <ul class="nav flex-column">
              <li class="nav-item">
                <a class="nav-link active" href="home">
                  <span data-feather="home"></span>
                  Home <span class="sr-only">(current)</span>
                </a>
              </li>
              <li class="nav-item">
                <a class="nav-link" href="userProfile">
                  <span data-feather="file"></span>
                  UserProfile
                </a>
              </li>
              <li class="nav-item">
                <a class="nav-link" href="Mountains.jsp?info=Mountains">Mountains
                </a>
              </li>
              <li class="nav-item">
                <a class="nav-link" href="Mountains.jsp?info=Cities">Cities
                </a>
              </li>
              <li class="nav-item">
                <a class="nav-link" href="Mountains.jsp?info=Forests">
                  Forests
                </a>
              </li>
            </ul>
          </div>
        </nav>
        
        
    <div role="main" class="col-md-9 ml-sm-auto col-lg-10 px-4">  <%--key of the grid!! --%>
		<% if (site!=null){ %>
          <div class="d-flex justify-content-between flex-wrap flex-md-nowrap align-items-center pt-3 pb-2 mb-3 border-bottom">
            <h1 class="h2"><%= site.getName() %></h1>
            <div class="btn-toolbar mb-2 mb-md-0">
              <div class="btn-group mr-2">
                <button class="btn btn-sm btn-outline-secondary">Share</button>
               <%--  <%if(!rs1.getString(8).equals(session.getAttribute("username"))) {%>
                	<a href="/Travelers/fork.jsp?site=<% rs1.getString(2) %>"  class="btn btn-sm btn-outline-secondary">Fork</a>
                <%} %>--%>
                <a href="/TravelersSite/editSite.jsp?site=<%= site.getName() %>"  class="btn btn-sm btn-outline-secondary">Edit</a>
                <a href="createComment.jsp" class="btn btn-sm btn-outline-secondary">Add Comment</a>
                <a class="btn btn-sm btn-primary" href="home">Return</a>
              </div>
            </div>
          </div>
          
          <div class="row text-center" style="display:flex;flex-wrap:wrap;">
					<div class="thumbnail" id="showimg" style="margin:0 auto;" >
						<img  src="<%= site.getImage() %>">
							<div class="caption-full" style="margin-top:30px;">
								<h4 >Costs: $<%= site.getPrice() %><span style="margin-left: 15px">Rating: <%= site.getRating() %></span></h4>
								
								
								<p><%= site.getDescription() %></p>
								<p>Submitted By <a href="#"><em><%= site.getUsername() %></em></a></p>			
								
								
							</div>
						</div>
			</div>
			<% } %>

			

			
			
			<hr>
			<% for (MyComment comment : allComments){
				 %>
						
									<div class="row">
									<div class="col-md-9 mb-3"><strong><%= comment.getName() %> <span style="margin-left: 50px">Author: <%= comment.getUsername() %>  Rating:<%= comment.getRating() %></span></strong>
									<% System.out.println("User is"+session.getAttribute("username")); %>
									</div>
									
									</div>
										
									<div class="row">
									<div class="col-md-12 mb-3">	
									 <%= comment.getComment() %>
									 
									</div>
									
									<div class="col-md-6 mb-3">
										<% if (comment.getUsername().equals(session.getAttribute("username"))) { %>
										<a class="btn btn-warning btn-xs" href="editComment?site=<%= comment.getName() %>">Edit</a></div>
                               		<div class="col-md-6 mb-3"><a href="deleteComment?name=<%= comment.getName() %>" class="btn btn-danger btn-xs">Delete</a></div>

                               

                               			<% 
										}
			}
                               			%>
			
			</div>
			</div>

</body>
</html>