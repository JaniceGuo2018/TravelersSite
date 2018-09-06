<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<jsp:include page="header.jsp" flush="true"></jsp:include>
</head>
<body>

<div class="container">
	
	<div class="py-5 text-center">
        <%-- <img class="d-block mx-auto mb-4" src="" alt="" width="72" height="72"> logo--%>
        <h2>Sign Up</h2>
       
     </div>
     
     <% if(request.getAttribute("alert")=="true"){ %>
     	<script language="javascript">alert("Username already existed, please try another one!")</script>
     <%} %>
     
       <div class="row">
        
      
        <div class="col-md-8 order-md-1" style="width: 30%; margin: 0 auto">
       
          <form class="needs-validation"   action="signup" method="post">
            <div class="row">
              <div class="col-md-6 mb-3">
                <label for="firstName">First name</label>
                <input type="text" class="form-control" id="firstName" name="firstName" placeholde="Ken" required>
                <div class="invalid-feedback">
                  Valid first name is required.
                </div>
              </div>
              <div class="col-md-6 mb-3">
                <label for="lastName">Last name</label>
                <input type="text" class="form-control" id="lastName" name="lastName" placeholder="Scotts"required>
                <div class="invalid-feedback">
                  Valid last name is required.
                </div>
              </div>
            </div>

           <div class="row">
              <div class="col-md-6 mb-3">
                <label for="username">Username</label>
                <input type="text" class="form-control" id="username" name="username" placeholder="Ken" required>
                <div class="invalid-feedback">
                  Your username is required.
                </div>
              </div>
              <div class="col-md-6 mb-3">
                <label for="password">Password</label>
                <input type="password" class="form-control" id="password" name="password" required>
                <div class="invalid-feedback">
                  Valid password is required.
                </div>
              </div>
            </div>

            <div class="mb-3">
              <label for="email">Email <span class="text-muted">(Optional)</span></label>
              <input type="email" class="form-control" id="email" placeholder="you@example.com" name="email" required>
              <div class="invalid-feedback">
                Please enter a valid email address for page updates.
              </div>
            </div>

            <div class="mb-3">
              <label for="avatar">Avatar</label>
              <input type="text" class="form-control" id="avatar" placeholder="image url" required name="avatar">
              <div class="invalid-feedback">
                Please enter an image url for your avatar.
              </div>
            </div>

            <div class="mb-3">
              <label for="adminCode">Admin Code</label>
              <input type="password" class="form-control" id="adminCode" name="adminCode">
            </div>
            
            <div class="mb-3">
              <label for="intro">Intro</label>
              <input type="text" class="form-control" id="intro" name="intro" placeholder="Hi, I am ..." required>
            </div>

         	<hr class="mb-4">
            <button class="btn btn-primary btn-lg btn-block" type="submit">Continue to checkout</button>
          </form>
        </div>
      </div>
     

</body>
</html>