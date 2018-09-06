package com.JaniceGuo.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;

import javax.servlet.RequestDispatcher;

import com.JaniceGuo.model.Site;
import com.JaniceGuo.model.User;
import com.sun.org.apache.xml.internal.resolver.helpers.PublicId;

public class ForUsers {
	public void setUser(String username, String passwd, String firstName, String lastName, String avatar,
			String adminCode, String email, String intro) {
		try {
			Connection conn = DB.getConn("test");
			System.out.println("DB connected");
			intro = intro.replaceAll("\n", "<br>");
			int userid = NameConversion.convertName(username);
			String sql = "insert into users values (?, ?, ?, ?, ?, ?, ?, ?,?)"; // create the table 'article' in advance
			PreparedStatement pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, username);
			pstmt.setString(2, passwd);
			pstmt.setString(3, firstName);
			pstmt.setString(4, lastName);
			pstmt.setString(5, avatar);
			pstmt.setString(6, adminCode);
			pstmt.setString(7, email);
			pstmt.setString(8, intro);
			pstmt.setInt(9, userid);
			pstmt.executeUpdate();
			pstmt.close();
			conn.close();
			System.out.println("create a new account!");
		} catch (Exception e) {
			System.out.println(e);
		}

	}

	private User read(ResultSet rs) throws SQLException {

		String name = rs.getString("username");
		String passwd = rs.getString("password");
		String firstName = rs.getString("firstName");
		String lastName = rs.getString("lastName");
		String avatar = rs.getString("avatar");
		String adminCode = rs.getString("adminCode");
		String email = rs.getString("email");
		String intro = rs.getString("intro");
		int userid=rs.getInt("userid");

		User user = new User();
		user.setAdminCode(adminCode);
		user.setAvatar(avatar);
		user.setEmail(email);
		user.setFirstName(firstName);
		user.setIntro(intro);
		user.setLastName(lastName);
		user.setName(name);
		user.setPasswd(passwd);
		user.setUserid(userid);
		return user;
	}

	public User getUser(String username, String password) {
		User user = new User();
		try {
			Connection connection = DB.getConn("test");
			Statement stmt = DB.getStmt(connection);
			String sql = "select * from users where username='" + username + "' and password= '" + password + "'";
			ResultSet rs = DB.executeQuery(stmt, sql);
			if (rs.next()) {
				System.out.println("welcome to user profile page!");
				user = read(rs);
			}
			stmt.close();
			connection.close();
			
		} catch (Exception e) {
			System.out.println(e);
		}
		return user;

	}
	
	public User getUser(String username) {
		User user = new User();
		try {
			Connection connection = DB.getConn("test");
			Statement stmt = DB.getStmt(connection);
			String sql = "select * from users where username='" + username + "'";
			ResultSet rs = DB.executeQuery(stmt, sql);
			if (rs.next()) {
				System.out.println("welcome to user profile page!");
				user = read(rs);
			}
			stmt.close();
			connection.close();
			
		} catch (Exception e) {
			System.out.println(e);
		}
		return user;

	}
	
	public void editUser(String username, String password, String avatar, String email, String intro) {
		try {
			Connection conn=DB.getConn("test");
			System.out.println("DB connected");
			Statement stmt = DB.getStmt(conn);
			System.out.println("YEAH CONNECTED!");
			String sql= "update users set password='"+password+"', avatar='"+avatar+"', email='"+email+"', intro='"+intro+"' where username='"+username+"'";
		    stmt.execute(sql);
		    stmt.close();
			conn.close();
			System.out.println("edit an existed user profile!");
			
		} catch (Exception e) {
			System.out.println(e);
		}
	}
	
	
	
}
