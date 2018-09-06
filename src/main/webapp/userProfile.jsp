<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="com.JaniceGuo.model.*,java.util.*"%>
<%  
	
	User user=(User)request.getAttribute("user");
	LinkedList<UserRecom> userRecoms=(LinkedList<UserRecom>) request.getAttribute("userRecom");
	ListIterator<UserRecom> it=(ListIterator<UserRecom>) userRecoms.listIterator();
	while(it.hasNext()) {
		UserRecom userRecom=it.next();
		System.out.println(userRecom.getScore());
	
	}

%>

<jsp:include page="header.jsp" flush="true"></jsp:include>
</head>
<body>

	<div class="container">


		<div class="row" style="margin-top: 40px;">

			<div class="col-md-4">

				<div class="card mb-4 shadow-sm">
					<img class="card-img-top" src=<%= user.getAvatar() %> alt="user profile image">

					<div class="d-flex justify-content-between align-items-center">
						<div class="btn-group">
							<a class="btn" href="mailto:<%= user.getEmail() %>"><%= user.getEmail() %></a>							
                      		<a href="editUser.jsp" class="btn btn-sm btn-info">Edit Profile</a>
							   	
						</div>
					</div>
				</div>
			</div>


			<div class="col-md-8">
				<div class="blog-post">
					<h2 class="blog-post-title"><%= user.getFirstName() %>
						<%= user.getLastName() %>
					</h2>
					<p>
						<strong>Intro: </strong>
						<%= user.getIntro() %></p>
					
					
				</div>
			</div>
			
			<div>
				<h4>Recommended Sites for you: </h4>
			
			</div>
		</div>
		
		

	</div>
</body>
</html>