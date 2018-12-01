package main;

import java.sql.Connection;
import java.sql.DriverAction;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

public class MYSQLAccess implements DriverAction {
//	static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";  
//	   static final String DB_URL = "jdbc:mysql://localhost/distri";

	   //  Database credentials
	   static final String USER = "root";
	   static final String PASS = "root";
	   public static Connection conn = null;
	   public static Statement stmt = null;
	   public static void iniciar() {
	   
	   try{
		   // Creating driver instance  
           Driver driver = new com.mysql.jdbc.Driver();  
           // Creating Action Driver  
           DriverAction da = new MYSQLAccess();  
           // Registering driver by passing driver and driverAction  
           DriverManager.registerDriver(driver, da);  
           conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/distri?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC","root","root");  
	      

	   }catch(SQLException se){
	      //Handle errors for JDBC
	      se.printStackTrace();
	   }
	   System.out.println("Coneccion hecha");
	}//end main
	   
	   public static void insert(int id, String lat, String longi) {
		 //STEP 4: Execute a query
		     try {
		    	 System.out.println("Inserting records into the table...");
			      stmt = conn.createStatement();
			      
			      String sql = "INSERT INTO ubicacions (`user_id`,`latitud`,`longitud`)" +
			                   "VALUES ("+id+","+lat+","+longi+")";
			      ResultSet rs=stmt.executeQuery(sql);
			      
			      System.out.println("Inserted records into the table...");
			} catch (Exception e) {
				// TODO: handle exception
			}
	   }

	@Override
	public void deregister() {
		// TODO Auto-generated method stub
		
	}
	}//end JDBCExample

