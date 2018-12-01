package main;

import java.sql.Connection;
<<<<<<< HEAD
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class MYSQLAccess {
	static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";  
	   static final String DB_URL = "jdbc:mysql://localhost/distribuidos";

	   //  Database credentials
	   static final String USER = "root";
	   static final String PASS = "root";
	   static Connection conn = null;
	   static Statement stmt = null;
	   public static void iniciar() {
	   
	   try{
	      //STEP 2: Register JDBC driver
	      Class.forName("com.mysql.jdbc.Driver");

	      //STEP 3: Open a connection
	      System.out.println("Connecting to a selected database...");
	      conn = DriverManager.getConnection(DB_URL, USER, PASS);
	      System.out.println("Connected database successfully...");
	      
	      

	   }catch(SQLException se){
	      //Handle errors for JDBC
	      se.printStackTrace();
	   }catch(Exception e){
	      //Handle errors for Class.forName
	      e.printStackTrace();
	   }finally{
	      //finally block used to close resources
	      try{
	         if(stmt!=null)
	            conn.close();
	      }catch(SQLException se){
	      }// do nothing
	      try{
	         if(conn!=null)
	            conn.close();
	      }catch(SQLException se){
	         se.printStackTrace();
	      }//end finally try
	   }//end try
	   System.out.println("Goodbye!");
	}//end main
	   
	   public static void insert(int id, String lat, String longi) {
		 //STEP 4: Execute a query
		     try {
		    	 System.out.println("Inserting records into the table...");
			      stmt = conn.createStatement();
			      
			      String sql = "INSERT INTO ubicacions (`user_id`,`latitud`,`longitud`)" +
			                   "VALUES ("+id+","+lat+","+longi+")";
			      stmt.executeUpdate(sql);
			      
			      System.out.println("Inserted records into the table...");
			} catch (Exception e) {
				// TODO: handle exception
			}
	   }
=======
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
>>>>>>> branch 'origin' of https://github.com/vakajose/SocketMultihilos.git
	}//end JDBCExample

