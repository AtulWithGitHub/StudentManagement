package com.parth.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DatabaseConnector {
	
	/*Class.forName("com.mysql.jdbc.Driver");
	Connection con=DriverManager.getConnection("jdbc:mysql://localhost/student","root","");  
	 Statement stmt=con.createStatement();  
	 String sql = "insert into data(`email`,`username`,`password`) values('"+temail.getText()+"','"+tname.getText()+"','"+tpass.getText()+"')";
	 int i = stmt.executeUpdate(sql);
	     System.out.println("i = "+i); 
	     con.close();
	*/
	
	private String driverName;
	private String connectionString;
	private String dbUserName;
	private String dbPassword;
	private Connection dbConnection;
	
	public DatabaseConnector() {
		
		driverName = "com.mysql.jdbc.Driver";
		connectionString = "jdbc:mysql://localhost/student";
		dbUserName = "root";
		dbPassword = "";
		dbConnection = null;
	}
	
	public DatabaseConnector(String dbuName, String dbuPass) {
		
		driverName = "com.mysql.jdbc.Driver";
		connectionString = "jdbc:mysql://localhost/student";
		dbUserName = dbuName;
		dbPassword = dbuPass;
		dbConnection = null;
	}
	
	public Connection getConnection() {

		try {
			Class.forName(driverName);
			dbConnection = DriverManager.getConnection(connectionString, dbUserName, dbPassword);
		} catch (SQLException e) {
			e.printStackTrace();
		} catch(ClassNotFoundException cnfException) {
			cnfException.printStackTrace();
		}
		
		return dbConnection;
		
	}
	
	public void closeConnection() {
		
		try {
			dbConnection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
