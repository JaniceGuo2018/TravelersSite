<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.sql.*,com.JaniceGuo.Dao.*"%>
<%  
	
	String name=request.getParameter("site");
	System.out.println("??Edit"+name);
	Connection conn=DB.getConn("test");
	Statement stmt1=DB.getStmt(conn);
	String sql1= "select * from site where name='"+name+"'";
	ResultSet rs1=DB.executeQuery(stmt1, sql1);
	while(rs1.next()){ 
%> 
 
 
 
<jsp:include page="header.jsp" flush="true"></jsp:include>
</head>
<body>
<div class="container">
	
	<div class="py-5 text-center">
        <%-- <img class="d-block mx-auto mb-4" src="" alt="" width="72" height="72"> logo--%>
        <h2>Edit An Existed Site</h2>
       
     </div>
     
       <div class="row">
        
      
        <div class="col-md-8 order-md-1" style="width: 30%; margin: 0 auto">
       
          <form class="needs-validation"  action="editSite?site=<%= name %>" method="post">
            <div class="row">
              <div class="col-md-6 mb-3">
                <label for="name">Name</label>
                <input type="text" class="form-control" id="name" name="name" placeholder=<%= rs1.getString(2) %> required>
                <div class="invalid-feedback">
                  Valid site name is required.
                </div>
              </div>
              <div class="col-md-6 mb-3">
                <label for="price">Costs</label>
                <input type="number" class="form-control" name="price" placeholder=<%= rs1.getString(3) %> min="0.01" step="0.01"required>
                <div class="invalid-feedback">
                  The traveling costs of the site is required.
                </div>
              </div>
            </div>

           <div class="row">
              <div class="col-md-6 mb-3">
                <label for="rating">Rating</label>
                <input type="text" class="form-control" id="rating" name="rating" placeholder=<%= rs1.getString(5) %> min="1" step="0.5" required>
                <div class="invalid-feedback">
                  Your rating of the site is required.
                </div>
              </div>
              <div class="col-md-6 mb-3">
                <label for="location">Location</label>
                <input type="text" class="form-control" id="location" name="location" placeholder=<%= rs1.getString(7) %> required>
                <div class="invalid-feedback">
                  Valid location is required.
                </div>
              </div>
            </div>



            <div class="mb-3">
              <label for="image">Image</label>
              <input type="text" class="form-control" id="image" name="image" placeholder=<%= rs1.getString(4) %> required>
              <div class="invalid-feedback">
                Please enter an image url for the site.
              </div>
            </div>

            <div class="mb-3">
              <label for="description">Description</label>
              <input type="text" class="form-control" id="description" name="description" placeholder=<%= rs1.getString(6) %>>
            </div>
            <% } %>
            
            <div class="mb-3">
				<label for="cat">Category</label>
				<select name="cat">
					<option value="Mountains">Mountains</option>
					<option value="Cities">Cities</option>
					<option value="Forests">Forests</option>
				</select>
			
			</div>

         	<hr class="mb-4">
            <button class="btn btn-primary btn-lg btn-block" type="submit">Continue to checkout</button>
          </form>
        </div>
      </div>
</div>



</body>
</html>