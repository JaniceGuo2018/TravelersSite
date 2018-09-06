<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>

<title>Travelers</title>
<link rel="stylesheet" href="https://cdn.bootcss.com/bootstrap/4.1.0/css/bootstrap.min.css">
  <script src="https://cdn.bootcss.com/jquery/3.2.1/jquery.min.js"></script>
  <script src="https://cdn.bootcss.com/popper.js/1.12.5/umd/popper.min.js"></script>
  <script src="https://cdn.bootcss.com/bootstrap/4.1.0/js/bootstrap.min.js"></script>
<%-- <link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css"
	integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u"
	crossorigin="anonymous">--%>
	
	  <style>
	  /* Make the image fully responsive */
	  .carousel-inner img {
	      width: 100%;
	      height: 100%;
	  }
	  </style>
</head>
<body>


<header>
      <nav class="navbar navbar-expand-md navbar-dark bg-dark">
        <a class="navbar-brand" href="home">Travelers</a>
        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarCollapse" aria-controls="navbarCollapse" aria-expanded="false" aria-label="Toggle navigation">
          <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarCollapse">
          <ul class="navbar-nav mr-auto">
            <% if (session.getAttribute("username")!=null) {%>
            <li class="nav-item active">
              <a class="nav-link" href="logout">Logout</a>      
            </li>
            <%}else { %>
            <li class="nav-item">
              <a class="nav-link" href="SignUp.jsp">Sign Up</a>
            </li>
             <% } %>
			<% if (session.getAttribute("username")!=null) {%>
            <li class="nav-item">
              <a class="nav-link" href="userProfile"><%= session.getAttribute("username").toString() %></a>
            </li>
            <%}else { %>
			  <li class="nav-item"><a class="nav-link" href="login.jsp">Login</a></li>
			<% } %>
            
          </ul>
          <form class="form-inline mt-2 mt-md-0" action="searchSite" method="get">
            <input class="form-control mr-sm-2" type="text" name="keyword" placeholder="Search For A Travel Site" aria-label="keyword">
            <button class="btn btn-outline-success my-2 my-sm-0" type="submit">Search</button>
          </form>
        </div>
      </nav>
 </header> 

