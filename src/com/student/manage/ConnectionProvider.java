package com.student.manage;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionProvider {
	static Connection con;
	
	public static Connection createC(){
		
		try {
			Class.forName("oracle.jdbc.OracleDriver");
			con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","c##user1","rahul");
			
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		return con;
	}
}
