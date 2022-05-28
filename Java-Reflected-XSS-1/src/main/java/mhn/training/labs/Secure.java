package mhn.training.labs;

import java.io.*;  
import java.sql.*;  
import javax.servlet.ServletException;  
import javax.servlet.http.*; 
import org.apache.commons.lang.StringEscapeUtils;	 

public class Secure extends HttpServlet {
	
	private static final long serialVersionUID = 102831973239L;
	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
		      throws ServletException, IOException {
		String name = request.getParameter("name");
		System.out.println("Unescaped : "+ name);
		System.out.println("Escaped   : "+ StringEscapeUtils.escapeHtml(name));		
		request.getRequestDispatcher("secure.jsp").forward(request, response);
	}	
}
