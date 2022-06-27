package mhn.training.labs;

import java.io.*;  
import java.sql.*;  
import java.util.*;
import javax.servlet.ServletException;  
import javax.servlet.http.*; 


public class Secure extends HttpServlet {
	
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
		request.getRequestDispatcher("secure.jsp").forward(request, response);
	}
	
	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
		      throws ServletException, IOException {
		 
      	List<User> users = new ArrayList<User>();
      	try {
			Connection con = getConnection();
			if (con != null) {
				Statement stmt = con.createStatement();
      
				String fname = request.getParameter("fname"); 				     

				String sql = "select * from users where fname = ?";
				PreparedStatement ps=con.prepareStatement(sql);
				ps.setString(1,fname.toString()); 
				ResultSet rs = ps.executeQuery();
       
				users = processUsers(rs);
			    rs.close ();
			    stmt.close ();
			}
      	}
      	catch (Exception e) {
    	  	e.printStackTrace();
      	}
      	request.setAttribute("users", users);
      	request.getRequestDispatcher("secure.jsp").forward(request, response);
	}
}
