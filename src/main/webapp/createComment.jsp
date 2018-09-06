<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<jsp:include page="header.jsp" flush="true"></jsp:include>
</head>
<body>
<div class="container">
	
	<div class="py-5 text-center">
        <%-- <img class="d-block mx-auto mb-4" src="" alt="" width="72" height="72"> logo--%>
        <h2>Add A Comment</h2>
       
     </div>
     
       <div class="row">
        
      
        <div class="col-md-8 order-md-1" style="width: 30%; margin: 0 auto">
       
          <form class="needs-validation"  action="addComment" method="post">
            <div class="row">
              <div class="col-md-6 mb-3">
                <label for="name">Name</label>
                <input type="text" class="form-control" id="name" name="name" placeholder="Niagra Falls" required>
                <div class="invalid-feedback">
                  Valid site name is required.
                </div>
              </div>

           
              <div class="col-md-6 mb-3">
                <label for="rating">Rating</label>
                <input type="number" class="form-control" id="rating" name="rating" placeholder="1-10 scale" min="1" step="0.5" required>
                <div class="invalid-feedback">
                  Your rating of the site is required.
                </div>
              </div>
              </div>


            <div class="mb-3">
              <label for="username">Submitted By </label>
              <input type="text" class="form-control" id="username" name="username" placeholder="Please enter your username as loggedin">
            </div>
            
            <div class="mb-3">
              <label for="comment">Description</label>
              <textarea class="form-control" name="comment" placeholder="For me, this is a ..." cols=30 rows=10></textarea>
            </div>
            

         	<hr class="mb-4">
            <button class="btn btn-primary btn-lg btn-block" type="submit">Continue to checkout</button>
          </form>
        </div>
      </div>
</div>

</body>
</html>