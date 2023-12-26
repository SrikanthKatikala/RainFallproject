package com.zettamine.rain.config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.ResourceBundle;

public class ConnectionFactory {

	private static Connection con = null;

	public static Connection getDBConne() {
		
		try
		{
			if(con==null) {
				ResourceBundle bundle = ResourceBundle.getBundle("dbresource");
				String dc = bundle.getString("jdbc.driverclass");
				Class.forName(dc);
				String url = bundle.getString("jdbc.url")+bundle.getString("jdbc.database");
				String username = bundle.getString("jdbc.username");
				String password = bundle.getString("jdbc.password");
				
				con = DriverManager.getConnection(url,username,password);
			}
			return con;
		}
		catch(Exception e) {
			
			e.printStackTrace();
			return null;
		}

	}
}
