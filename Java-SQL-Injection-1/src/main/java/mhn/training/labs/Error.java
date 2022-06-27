package mhn.training.labs;

import java.io.*;  
import javax.servlet.ServletException;  
import javax.servlet.http.*; 	 

public class Error extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
		      throws ServletException, IOException {
		request.getRequestDispatcher("error.jsp").forward(request, response);
	}
	
}
