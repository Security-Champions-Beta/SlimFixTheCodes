package mhn.training.labs;

import java.io.*;  
import java.sql.*;  
import javax.servlet.ServletException;  
import javax.servlet.http.*; 	 

public class SQLi extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
		      throws ServletException, IOException {
		request.getRequestDispatcher("index.jsp").forward(request, response);
	}
	public void doPost(HttpServletRequest request, HttpServletResponse response)  
            throws ServletException, IOException {  
		String fname = request.getParameter("fname");  
		String lname = request.getParameter("lname");  
		String email = request.getParameter("email");  
		String dbDriver = "com.mysql.jdbc.Driver"; 
        String dbURL = System.getenv("JDBC_URL");

        String dbUsername = System.getenv("DB_USER");
        String dbPassword = System.getenv("DB_PASSWORD");
  
        try {
        	Class.forName(dbDriver); 
        	Connection con = DriverManager.getConnection(dbURL, dbUsername,  dbPassword);
			String query = "insert into users(fname,lname,email) values(?,?,?)";
        	PreparedStatement ps=con.prepareStatement(query);    
			ps.setString(1,fname);  
			ps.setString(2,lname);  
			ps.setString(3,email);    
						
			int i=ps.executeUpdate();  
			if(i>0) {
				System.out.println("Data has been saved successfully");
				response.sendRedirect("/SQLInjection/insecure");
			}
			else {
				response.sendRedirect("/SQLInjection/sqli");
			}		
        }
        catch (Exception e2) {
        	System.out.println(e2);
        	response.sendRedirect("/SQLInjection/sqli");
        }
	}
}
