package com.ss.training.login;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private String username = "derrian";
	private String password = "smoothstack";
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");
	    PrintWriter pw = response.getWriter();  
	    String username =request.getParameter("username");  
	    String password =request.getParameter("password");  
	    
	    if(checkUserPass(username, password))
        {
	    	pw.println("Information is correct!");
        }
        else
        {
        	pw.println("Username or Password incorrect");
        }
	    RequestDispatcher rs = request.getRequestDispatcher("index.html");
        rs.include(request, response);
	}
	
	private boolean checkUserPass(String username, String password) {
		return this.username.equals(username) && this.password.equals(password);
	}

}
