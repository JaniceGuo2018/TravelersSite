package com.JaniceGuo.Dao;
import com.mysql.*;

import com.mysql.cj.*;
import java.sql.*;

public class DB {
	public static Connection getConn(String db) {
		Connection conn=null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			String url="jdbc:mysql://localhost:3306/"+db+"?user=root&password=";
			conn=DriverManager.getConnection(url);
			System.out.println("connected!");
		} catch (ClassNotFoundException exception) {
			exception.printStackTrace();
		}catch (SQLException e) {
			e.printStackTrace();
		}
		
		return conn;
	}
	
	public static Statement getStmt(Connection conn) {
		Statement stmt=null;
		try {
			stmt=conn.createStatement();
		} catch (SQLException e) {
			System.out.println("Statement unable to be created....");
			e.printStackTrace();
		}
		return stmt;
	}
	
	public static ResultSet executeQuery(Statement stmt,String sql) {
		ResultSet rs=null;
		try {
			rs=stmt.executeQuery(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return rs;
	}
	
	public static void close(Connection conn) {
		if (conn != null) {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		conn=null;
		}
	}
	
	public static void close(ResultSet rs) {
		if (rs != null) {
			try {
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		rs=null;
		}
	}
	
	
	public static void close(Statement stmt) {
		if (stmt != null) {
			try {
				stmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			stmt=null;
		}
	}
}
