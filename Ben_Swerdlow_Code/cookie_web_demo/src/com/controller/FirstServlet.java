package com.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class FirstServlet
 */
public class FirstServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FirstServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("In FirstServlet doPost");
		Cookie cookie1 = new Cookie("FirstName", request.getParameter("fname"));
		Cookie cookie2 = new Cookie("LastName", request.getParameter("lname"));
		Cookie cookie3 = new Cookie("Email", request.getParameter("email"));
		Cookie cookie4 = new Cookie("Contact", request.getParameter("contact"));
		
		cookie1.setMaxAge(900);
		cookie2.setMaxAge(900);
		cookie3.setMaxAge(900);
		cookie4.setMaxAge(900);
		
		response.addCookie(cookie1);
		response.addCookie(cookie2);
		response.addCookie(cookie3);
		response.addCookie(cookie4);
		
		response.sendRedirect("two.html");
	}

}
