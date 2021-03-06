package com.Yatra.dblayer;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import org.testng.annotations.Test;
public class SQLserver {
	static final String JDBC_Droiver="com.mysql.jdbc.Driver";
	static final String DB_URL="jdbc:mysql://localhost:3306";
	static final String USER="root";
	static final String PSSS="tiger";
	Connection conn = null;
	Statement stmt = null;
	@Test
	public void StartDataBase(){
		try{
			//STEP 2: Register JDBC driver
			Class.forName("com.mysql.jdbc.Driver");
			//STEP 3: Open a connection
			conn = DriverManager.getConnection(DB_URL, USER, PSSS);
			System.out.println("Creating database...");
			stmt = conn.createStatement();
			String sql = "CREATE DATABASE DEMODATABASE";
			stmt.executeUpdate(sql);
		}
		catch(SQLException se)
		{
			//Handle errors for JDBC
			se.printStackTrace();
		}catch(Exception e)
		{
			//Handle errors for Class.forName
			e.printStackTrace();
		}finally{
			//finally block used to close resources
			try{
				if(stmt!=null)
					stmt.close();
			}catch(SQLException se2){
			}// nothing we can do
			try{
				if(conn!=null)
					conn.close();
			}catch(SQLException se){
				se.printStackTrace();
			}//end finally try
		}//end try
		System.out.println("Goodbye!");
	}//end main
}//end JDBCExample

