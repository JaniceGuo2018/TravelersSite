package com.JaniceGuo.Dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.*;

public class TestDB {
	public static void main(String[] args) throws SQLException{
		Connection conn=DB.getConn("test");
		Statement stmt=DB.getStmt(conn);
		String name="Alice";
		String sql="select * from users where username='"+name+"'";
		ResultSet rs=DB.executeQuery(stmt, sql);
		while (rs.next()) {
			
			String username = rs.getString(2);
			String price = rs.getString(3);
			String image = rs.getString(4);
			String rating=rs.getString(5);
			String description=rs.getString(6);
			String location=rs.getString(7);
			
			System.out.println(username);
			System.out.println(rating);
			
		}
		
	}
}
