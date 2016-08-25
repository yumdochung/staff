package com.project001.common;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;


public class Dbcp {
	
	public Connection getConnection () {
		Connection conn = null;
		
		try{
			Context initContext = new InitialContext();
			Context envContext = (Context) initContext.lookup("java:/comp/env");
			DataSource ds = (DataSource) envContext.lookup("jdbc/staff");
			
			conn = ds.getConnection();
		} catch ( Exception e) {
			e.printStackTrace();
		}
		return conn;
		
	}
	
	public void close (ResultSet rs, PreparedStatement pstmt, Connection conn) {
		
		try {
			if(rs != null) rs.close();
			if(pstmt != null) pstmt.close();
			if(conn != null) conn.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
}
