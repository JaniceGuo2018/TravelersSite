<%@page import="java.util.Iterator"%>
<%@page import="java.util.LinkedList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ page import="java.sql.*,com.JaniceGuo.Dao.*,com.JaniceGuo.model.*,java.util.*"%>



<jsp:include page="header.jsp" flush="true"></jsp:include>


<div id="demo" class="carousel slide" data-ride="carousel">
 
  <!-- 指示符 -->
  <ul class="carousel-indicators">
    <li data-target="#demo" data-slide-to="0" class="active"></li>
    <li data-target="#demo" data-slide-to="1"></li>
    <li data-target="#demo" data-slide-to="2"></li>
  </ul>
 
  <!-- 轮播图片 -->
  <div class="carousel-inner">
    <div class="carousel-item active">
      <img src="http://static.runoob.com/images/mix/img_fjords_wide.jpg">
      <div class="container">
              <div class="carousel-caption text-left">
                <h1>Cities</h1>
                <p>Cras justo odio, dapibus ac facilisis in, egestas eget quam. Donec id elit non mi porta gravida at eget metus. Nullam id dolor id nibh ultricies vehicula ut id elit.</p>
                <p><a class="btn btn-lg btn-primary" href="/TravelersSite/Mountains.jsp?info=Cities" role="button">Learn More</a></p>
          	  </div>
     </div>
    </div>
    <div class="carousel-item">
      <img src="http://static.runoob.com/images/mix/img_nature_wide.jpg">
      <div class="container">
              <div class="carousel-caption text-left">
                <h1>Forests</h1>
                <p>Cras justo odio, dapibus ac facilisis in, egestas eget quam. Donec id elit non mi porta gravida at eget metus. Nullam id dolor id nibh ultricies vehicula ut id elit.</p>
                <p><a class="btn btn-lg btn-primary" href="/TravelersSite/Mountains.jsp?info=Forests" role="button">Learn More</a></p>
          	  </div>
     </div>
    </div>
    <div class="carousel-item">
      <img src="http://static.runoob.com/images/mix/img_mountains_wide.jpg">
      <div class="container">
              <div class="carousel-caption text-left">
                <h1>Mountains</h1>
                <p>Cras justo odio, dapibus ac facilisis in, egestas eget quam. Donec id elit non mi porta gravida at eget metus. Nullam id dolor id nibh ultricies vehicula ut id elit.</p>
                <p><a class="btn btn-lg btn-primary" href="/TravelersSite/Mountains.jsp?info=Mountains" role="button">Learn More</a></p>
          	  </div>
     </div>
     
    </div>
  </div>
 
  <!-- 左右切换按钮 -->
  <a class="carousel-control-prev" href="#demo" data-slide="prev">
    <span class="carousel-control-prev-icon"></span>
  </a>
  <a class="carousel-control-next" href="#demo" data-slide="next">
    <span class="carousel-control-next-icon"></span>
  </a>
 
</div>
		
<div class="container" style="margin-top:40px;">
		<h3>Our Most Popular Sites</h3>
		
		<% 
			LinkedList<Site> allSites=(LinkedList<Site>) request.getAttribute("sites");
			ListIterator<Site> it=allSites.listIterator();
			Site site=new Site();
			while(it.hasNext()){
				site=it.next();
			%>
			
		<div class="album py-5 bg-light"  style="margin-top:40px;">
        <div class="container">

          <div class="row"  >
         
				
            <div class="col-md-4">
              <div class="card mb-4 shadow-sm">
                <img class="card-img-top" src=<%= site.getImage()%> alt="Card image cap">
                <div class="card-body">
                  <p  style="text-overflow: ellipsis; overflow: hidden; white-space: nowrap; width: 300px" class="card-text"><%= site.getDescription() %></p>
                  <div class="d-flex justify-content-between align-items-center">
                    <h4><%= site.getName() %></h4>
                     <div class="btn-group">
                      <a href="site?sitename=<%= site.getName() %>" class="btn btn-sm btn-info">More Info</a>
							   	
                      <a  class="btn btn-sm btn-outline-secondary" href="/TravelersSite/editSite.jsp?site=<%= site.getName() %>">Edit</a>
                    </div>
                    
                  </div>
                </div>
              </div>
            </div>

			<% 		
          }
		%>
	
		
</div>
</div>
</div>
</div>
			



</body>
</html>