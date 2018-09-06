<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    

<jsp:include page="header.jsp" flush="true"></jsp:include>

<div class="container" style="margin-top:50px;">

	<div class="py-5 text-center">
        <%-- <img class="d-block mx-auto mb-4" src="" alt="" width="72" height="72"> logo--%>
        <h2>Log in</h2>
        <% if(request.getAttribute("alert")=="true"){ %>
        	<script type="text/javascript">alert("Wrong username or password... Please try again!")</script>
        <% } %>
       
     </div>
	<div style="width: 30%; margin: 0 auto">

		<form  action="login" method="post">
			<div class="form-group">
				<input class="form-control" type="text" name="username" placeholder="username">
			</div>

			<div class="form-group">
				<input class="form-control" type="password" name="password" placeholder="password">
			</div>

			<div class="form-group">
				<button class="btn btn-lg btn-primary btn-block">Submit!</button>
			</div>
		</form>	
	</div>


</div>


	
</body>
</html>