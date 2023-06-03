package com.Test.MySql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.testng.annotations.Test;

/*
 * 1. CREATE A CONNECTION
 * 2. CREATE A STATEMENT/QUERY
 * 3. EXECUTE THE STATEMENT/QUERY
 * 4. STRORE THE RESULTS IN RESULTS SET
 * 5. CLOSE CONNECTION
 */

public class MySQLDMLCommands {
	
	@Test
	public void insertData() throws SQLException {
		//Create Connection
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/hr","root","test1234");
		
		//Create a Statement
		Statement stmt = con.createStatement();
		String s = "INSERT INTO B VALUES(109,'JOYE','CHEMISTRY')";
				
		//Execute statement
		stmt.execute(s);
		
		//Close Connection
		con.close();
	}
	
	@Test
	public void updateData() throws SQLException {
		//Create Connection
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/hr","root","test1234");
		
		//Create Statement
		Statement stmt = con.createStatement();
		String s = "UPDATE B SET SNAME='VELS' WHERE SNO=107";
		
		//Execute Statement
		stmt.execute(s);
		
		//Close Connection
		con.close();
		
	}
	
	@Test
	public void deleteData() throws SQLException {
		//Create Connection
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/hr","root","test1234");
		
		//Create Statement
		Statement stmt = con.createStatement();
		String s = "DELETE FROM B WHERE SNO=101";
		
		//Execute Statement
		stmt.execute(s);
		
		//Close Connection
		con.close();
		
	}
	
	@Test
	public void selectData() throws SQLException {
		//Create Connection
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/hr","root","test1234");
		
		//Create statement
		Statement stmt = con.createStatement();
		String s = "SELECT * FROM B;";
		
		//Execute Statement & STORE RESULTS
		ResultSet rs = stmt.executeQuery(s);
		
		while(rs.next()) {
			int sno = rs.getInt("SNO");
			String sname = rs.getString("SNAME");
			String dname = rs.getString("DEPARTMENT_NAME");
			
			System.out.println(sno+"   "+sname+"      "+dname);
		}
		
		
	}
	
	
	

	

}
