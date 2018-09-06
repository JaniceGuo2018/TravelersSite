<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ page import="java.util.*,com.JaniceGuo.model.*"%>
<%
	LinkedList<Site> searchSites = (LinkedList<Site>) request.getAttribute("searchSites");
	ListIterator<Site> search = searchSites.listIterator();
	Site site = new Site();
%>

<jsp:include page="header.jsp" flush="true"></jsp:include>

<section class="jumbotron text-center">
	<div class="container">
		<h1 class="jumbotron-heading">Search Results</h1>
		<p class="lead text-muted">Something short and leading about the
			collection below—its contents, the creator, etc. Make it short and
			sweet, but not too short so folks don't simply skip over it entirely.</p>
		<p>
			<a class="btn btn-lg btn-primary" href="createSite.jsp" role="button">Share
				a new site</a>
		</p>
	</div>
</section>
<div class="container" style="margin-top: 40px;">


	<%
		if (session.getAttribute("username") != null) {
			while (search.hasNext()) {
				site = search.next();
	%>

	<div class="album py-5 bg-light" style="margin-top: 40px;">
		<div class="container">

			<div class="row">

				<div class="col-md-4">
					<div class="card mb-4 shadow-sm">
						<img class="card-img-top" src=<%=site.getImage()%>
							alt="Card image cap">
						<div class="card-body">
							<p
								style="text-overflow: ellipsis; overflow: hidden; white-space: nowrap; width: 300px"
								class="card-text"><%=site.getDescription()%></p>
							<div class="d-flex justify-content-between align-items-center">

								<h4><%=site.getName()%></h4>
								<div class="btn-group">
									<a href="site?sitename=<%=site.getName()%>" class="btn btn-sm btn-info">More Info</a>							   	
                      				<a  class="btn btn-sm btn-outline-secondary" href="editSite.jsp?site=<%=site.getName()%>">Edit</a>
								</div>

							</div>
						</div>
					</div>
				</div>

				<%----------------------------------------------------------------------------------- --%>

				<%
					}
					}
				%>


			</div>
		</div>
	</div>
</div>


</body>
</html>



</body>
</html>