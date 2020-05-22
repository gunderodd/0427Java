package com.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.stream.Collectors;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.controllers.LoginController;
import com.controllers.RequestHelper;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.models.ValidLogin;

public class MasterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public MasterServlet() {
        super();
    }

	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		PrintWriter pw = res.getWriter();
		
		pw.append("Served at: MasterServlet. ");
		//pw.append("email- " + email);
	}

	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		System.out.println("Posting inside MasterServlet");
		if ("POST".equalsIgnoreCase(req.getMethod())) 
		{
			
		    String test = req.getReader().lines().collect(Collectors.joining(System.lineSeparator()));
		    ObjectMapper mapper = new ObjectMapper();
			ValidLogin validLogin = mapper.readValue(test, ValidLogin.class);
		    LoginController.login(validLogin.getEmail(), validLogin.getPassword());
		}
		
		
		doGet(req, res);
	}
	
	protected void doPut(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
	}
	
	protected void doDelete(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
	}
	
	

}
