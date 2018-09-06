<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    
<%@ page import="java.sql.*,com.JaniceGuo.model.*,com.JaniceGuo.Dao.*"%>
<% 
	String name=request.getParameter("info");
	Connection conn=DB.getConn("test");
	Statement stmt=DB.getStmt(conn);
	String sql="select * from site where cat='"+name+"'";
	ResultSet rs=DB.executeQuery(stmt, sql);
	


%>
<jsp:include page="header.jsp" flush="true"></jsp:include>
</head>
<body>



   

      <section class="jumbotron text-center">
        <div class="container">
          <h1 class="jumbotron-heading"><%= request.getParameter("info") %></h1>
          <p class="lead text-muted">Something short and leading about the collection below—its contents, the creator, etc. Make it short and sweet, but not too short so folks don't simply skip over it entirely.</p>
		  <p><a class="btn btn-lg btn-primary" href="createSite.jsp" role="button">Share a new site</a></p>
        </div>
      </section>

     		
		<% if(session.getAttribute("username")!=null){ %>
		<div class="row text-center" style="display:flex;flex-wrap:wrap;">
			<% while(rs.next()){ 
				try{%>
				<div class="col-md-4 col-sm-6">
				
						<div class="thumbnail">
							<img src=<%= rs.getString(4)%>>
							<h4><%= rs.getString(2) %></h4>
							<form action="site.jsp" method="get" >
								
							   <a href="site?sitename=<%=rs.getString(2)%>" class="btn btn-info">More Info</a>
							   	<% System.out.println(rs.getString(2)); %>
							</form>
						</div>
						
				</div>
			<% 		
			}catch(SQLException e){e.printStackTrace();}
			}
		}
			%>
			
			

		
		</div>
		
</div>
<%
	stmt.close();
	conn.close();
%>
  </body>
</html>
