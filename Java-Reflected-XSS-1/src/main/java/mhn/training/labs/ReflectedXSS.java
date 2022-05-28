package mhn.training.labs;

import java.io.*;  
import java.sql.*;  
import javax.servlet.ServletException;  
import javax.servlet.http.*; 	 

public class ReflectedXSS extends HttpServlet {
	
	private static final long serialVersionUID = 102831973239L;
	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
		      throws ServletException, IOException {		
		request.getRequestDispatcher("index.jsp").forward(request, response);
	}	
}
