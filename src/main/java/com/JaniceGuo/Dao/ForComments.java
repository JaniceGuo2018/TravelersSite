package com.JaniceGuo.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;

import com.JaniceGuo.model.MyComment;
import com.JaniceGuo.model.Site;

public class ForComments {
	public void setComment(String name,float rating,
			String comment,String username) {
		try {
			Connection conn=DB.getConn("test");
			System.out.println("DB connected");
			int site= NameConversion.convertName(name);
			int user=NameConversion.convertName(username);
			comment = comment.replaceAll("\n" , "<br>");//将回车符换为html重的换行符
			
			
			String sql = "insert into comment values (?, ?, ?, ?)"; //create the table 'comment' in advance
			PreparedStatement pstmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
				
			pstmt.setString(1, name);
			pstmt.setFloat(2, rating);
			pstmt.setString(3, username);
			pstmt.setString(4, comment);
			pstmt.executeUpdate();

			pstmt.close();
			conn.close();
			System.out.println("create a new comment");
		} catch (Exception e) {
			System.out.println(e);
		}
		
	}
	

	private MyComment read(ResultSet rs) throws SQLException {

		String name = rs.getString("name");
		float rating = rs.getFloat("rating");
		String username = rs.getString("username");
		String com = rs.getString("comment");

		MyComment myComment=new MyComment();
		myComment.setComment(com);
		myComment.setName(name);
		myComment.setRating(rating);
		myComment.setUsername(username);
		return myComment;
	}


	public LinkedList<MyComment> getAllComments(String name) {

		LinkedList<MyComment> allComments = new LinkedList<MyComment>();
		
		try {
			Connection conn = DB.getConn("test");
			Statement stmt = DB.getStmt(conn);
			ResultSet rs = stmt.executeQuery("select * from comment where name='"+name+"'");
			while (rs.next()) {
				MyComment myComment = read(rs);
				allComments.add(myComment);
			}
			stmt.close();
			rs.close();
			conn.close();
		} catch (Exception e) {
			System.out.println(e);
		}
	
		return allComments;

	}
	
	public MyComment getComment() throws SQLException{
		MyComment myComment=new MyComment();
		Connection connection=DB.getConn("test");
		Statement stmt=connection.createStatement();
		ResultSet rs=stmt.executeQuery("select * from comment where name="+"");
		if (rs.next()) {
			myComment=read(rs);
		}
		stmt.close();
		rs.close();
		connection.close();
		return myComment;
	}
	
	public void deleteComment(String name,String username) {
		try {
			Connection conn=DB.getConn("test");
			Statement stmt=DB.getStmt(conn);
			stmt.execute("delete from comment where name='"+name+"' and username= '"+username+"'");
			stmt.close();
			conn.close();
			
		} catch (Exception e) {
			System.out.println(e);
		}
		
		
	}
}
