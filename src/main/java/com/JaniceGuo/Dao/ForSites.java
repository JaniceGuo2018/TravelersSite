package com.JaniceGuo.Dao;

import java.sql.*;
import java.util.LinkedList;

import com.JaniceGuo.model.Site;
import com.mysql.cj.exceptions.RSAException;
import com.mysql.cj.x.protobuf.MysqlxSql.StmtExecute;

public class ForSites {

	public void setSite(String name, String price, String image, float rating, String description, String location,
			String username, String cat) {
		try {
			Connection conn = DB.getConn("test");
			System.out.println("DB connected");
			int siteid = NameConversion.convertName(name);
			int userid = NameConversion.convertName(username);
			String sql = "insert into site values (?,?, ?, ?, ?, ?, ?,?,?,?)"; // create the table 'article' in advance
			PreparedStatement pstmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			Statement stmt = DB.getStmt(conn);

			pstmt.setInt(1, siteid);
			pstmt.setString(2, name);
			pstmt.setString(3, price);
			pstmt.setString(4, image);
			pstmt.setFloat(5, rating);
			pstmt.setString(6, description);
			pstmt.setString(7, location);
			pstmt.setInt(8, userid);
			pstmt.setString(9, username);
			pstmt.setString(10, cat);

			pstmt.executeUpdate();
			stmt.close();
			pstmt.close();
			conn.close();
			System.out.println("create a new item-site!");
		} catch (Exception e) {
			System.out.println(e);
		}

	}
	
	public void editSite(String site,String name, String price, String image, float rating, String description, String location,
			String cat) {
		try {
			Connection conn=DB.getConn("test");
			System.out.println("DB connected");
			Statement stmt = DB.getStmt(conn);
			System.out.println("YEAH CONNECTED!");
			String sql= "update site set name='"+name+"', price='"+price+"', image='"+image+"', rating='"+rating+"', description='"+description+"', location='"+location+"', cat='"+cat+"' where name='"+site+"'";
		    stmt.execute(sql);
		    stmt.close();
			conn.close();
			System.out.println("edit an existed item-site!");
			
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	private Site read(ResultSet rs) {
		Site site = new Site();
		try {
			String name = rs.getString("name");
			String price = rs.getString("price");
			String image = rs.getString("image");
			float rating = rs.getFloat("rating");
			String description = rs.getString("description");
			String location = rs.getString("location");
			String username = rs.getString("username");
			String cat = rs.getString("cat");
			
			site.setCat(cat);
			site.setDescription(description);
			site.setLocation(location);
			site.setName(name);
			site.setPrice(price);
			site.setUsername(username);
			site.setRating(rating);
			site.setImage(image);
			
			
		} catch (Exception e) {
			System.out.println(e);
		}
		return site;
		

		
	}

	public LinkedList<Site> getSearchSites(String keyword) {
		LinkedList<Site> searchSites = new LinkedList<Site>();
		try {
			Connection conn = DB.getConn("test");
			PreparedStatement pstmt = conn.prepareStatement("SELECT * FROM site where name LIKE ?");
			if (keyword == null) {
				keyword = "";
			}
			pstmt.setString(1, "%" + keyword + "%");
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				Site site = read(rs);
				searchSites.add(site);
			}
			conn.close();
			pstmt.close();
		} catch (Exception e) {
			System.out.println(e);
		}
		
		return searchSites;
	}

	public LinkedList<Site> getAllSites(){

		LinkedList<Site> allSites = new LinkedList<Site>();
		try {
			Connection conn = DB.getConn("test");
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery("select * from site");
			while (rs.next()) {
				Site site = read(rs);
				allSites.add(site);
			}
			stmt.close();
			rs.close();
			conn.close();
			
		} 
		
		catch (SQLException e) {
			System.out.println(e);
		}
		return allSites;
	}
	
	public Site getSite(String name){
		Site site=new Site();
		try {
			Connection connection=DB.getConn("test");
			Statement stmt=connection.createStatement();
			String sql="select * from site where name='"+name+"'";
			ResultSet rs=stmt.executeQuery(sql);
			if (rs.next()) {
				site=read(rs);
			}
			stmt.close();
			rs.close();
			connection.close();
		} catch (Exception e) {
			System.out.println(e);
		}
		
		return site;
	}

}
