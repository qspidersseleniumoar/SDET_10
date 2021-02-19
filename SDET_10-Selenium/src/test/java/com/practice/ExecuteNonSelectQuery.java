package com.practice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;


public class ExecuteNonSelectQuery {

	public static void main(String[] args) throws Throwable {
	
		 int result = 0;

				/*step-1  : load or register the data base*/
				 Driver driverRef = new Driver();
				DriverManager.registerDriver(driverRef);
				
				/*step-2  : connect to database*/
				 Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/projects", "root", "root");
				System.out.println("Done");
				
				/*step-3  : create/issue SQL statement*/
				Statement stat = conn.createStatement();
				String query = "insert into project values('TY_PROJ_180','deepak','02/11/2022','SDET35','Completed','20')";
				
				/*step-4  : execute query*/
				 result=  stat.executeUpdate(query);
				 System.out.println(result);
		
			if(result==0) {
				System.err.println("project not created==FAIL");
			}else {
				System.out.println("project succuessFully cretaed==PASS");
			}
			
			/*step-5  : close the Connection*/
			   conn.close();
		}
				   
		 		
				
			

	}


