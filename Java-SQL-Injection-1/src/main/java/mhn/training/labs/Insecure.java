package mhn.training.labs;

import java.io.*;  
import java.sql.*;  
import java.util.*;
import javax.servlet.ServletException;  
import javax.servlet.http.*; 
import org.apache.log4j.Logger;
import org.apache.log4j.BasicConfigurator;



public class Insecure extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	public Connection getConnection() {
		String dbDriver = "com.mysql.jdbc.Driver"; 
        String dbURL = System.getenv("JDBC_URL");

        String dbUsername = System.getenv("DB_USER");
        String dbPassword = System.getenv("DB_PASSWORD");
        
        try {
	        Class.forName(dbDriver); 
	        Connection con = DriverManager.getConnection(dbURL, dbUsername,  dbPassword);
	        return con;
        }
        catch (Exception e) {
        	System.out.println(e);
        	e.printStackTrace();
        	return null;
        }	
	}
	
	public List<User> processUsers(ResultSet rs) {
		List<User> users = new ArrayList<User>();
		try {
			while (rs.next ()){
	        	User u = new User();
	        	u.setFname(rs.getString("fname"));
	        	u.setLname(rs.getString("lname"));
	        	u.setEmail(rs.getString("email"));
	        	users.add(u);
	        }
		}
		catch (Exception e) {        	
        	e.printStackTrace();        	
        }
		return users;
	}
	
	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
		      throws ServletException, IOException {
		List<User> users = new ArrayList<User>();
		
		try {
			Connection con = getConnection();
			if (con != null) {
				Statement stmt = con.createStatement();
		        String sql;
		        sql = "SELECT * FROM users";
		        ResultSet rs = stmt.executeQuery(sql);
		        users = processUsers(rs);
		        rs.close ();
		        stmt.close ();
			}
		}
		catch (Exception e) {        	
        	e.printStackTrace();        	
        }	
        
        request.setAttribute("users", users);
		request.getRequestDispatcher("insecure.jsp").forward(request, response);
	}
	
	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
		      throws ServletException, IOException {
		 
      	List<User> users = new ArrayList<User>();
      	try {
			Connection con = getConnection();
			if (con != null) {
				Statement stmt = con.createStatement();
      
				String fname = request.getParameter("fname"); 
      
				String sql = "select * from users where fname = '"+fname+"'";
				ResultSet rs = stmt.executeQuery(sql);      
       
				users = processUsers(rs);
			    rs.close ();
			    stmt.close ();
			}
      	}
		catch (SQLException se){
			BasicConfigurator.configure(); 
			Logger log = Logger.getLogger(request.getRequestURI());
			log.error("\u001b[0;31m"+ se.getMessage()+ "\u001b[m ");
			// System.out.println("******************************");
			// se.printStackTrace();
			// System.out.println("******************************");
			request.getRequestDispatcher("error.jsp").forward(request, response);
		}
      	catch (Exception e) {
    	  	e.printStackTrace();
      	}
      	request.setAttribute("users", users);
      	request.getRequestDispatcher("insecure.jsp").forward(request, response);
	}
}
