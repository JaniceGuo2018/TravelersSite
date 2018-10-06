<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.sql.*,com.JaniceGuo.Dao.*"%>

 
 
<jsp:include page="header.jsp" flush="true"></jsp:include>
</head>
<body>
	
<div class="container">	
	<div class="py-5 text-center">     
        <h2>Edit User Profile</h2>       
     </div>
     
       <div class="row">      
        <div class="col-md-8 order-md-1" style="width: 30%; margin: 0 auto">
                 <form class="needs-validation"   action="editUserProfile" method="post">
           <div class="row">
             
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
              <input type="text" class="form-control" id="avatar" placeholder="image url" name="avatar" required >
              <div class="invalid-feedback">
                Please enter an image url for your avatar.
              </div>
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
