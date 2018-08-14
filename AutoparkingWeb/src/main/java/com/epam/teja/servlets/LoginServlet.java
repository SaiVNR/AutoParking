package com.epam.teja.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.epam.teja.validators.AdminLogin;

/**
 * Servlet implementation class LoginServlet
 */
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	    response.sendRedirect("login.jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    PrintWriter out = response.getWriter();
	    out.println("<script>\r\n" + 
                "function myFunction(x) {\r\n" + 
                "    alert(x);\r\n" + 
                "}\r\n" + 
                "</script>");
		
		response.setContentType("text/html");
		
		
		
		String userName = request.getParameter("userName");
		String password = request.getParameter("password");
		AdminLogin adminLogin = new AdminLogin();
		if(adminLogin.validateAdmin(userName, password)) {
		    Cookie cookie = new Cookie("loginStatus","true");
            response.addCookie(cookie);
			response.sendRedirect("home.html");
			
		} else{
		    out.println("<script type=\"text/javascript\">");  
		    out.println("alert('Invalid Credentials');");  
		    out.println("</script>");
		    request.getRequestDispatcher("login.jsp").include(request, response);
		}
	}

}


