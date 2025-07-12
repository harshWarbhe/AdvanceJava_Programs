package com.harsh.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/firsturl")
public class FirstServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		resp.setContentType("text/html");
		PrintWriter pw = resp.getWriter();
		
		//create cookies
		Cookie ck1 = new Cookie("MH","Mumbai");
		Cookie ck2 = new Cookie("TS","Hyd");
		
		Cookie ck3 = new Cookie("AP","NoCaptital");
		Cookie ck4 = new Cookie("MP","Bhopal");
		ck3.setMaxAge(2*60);
		ck4.setMaxAge(1*60);
		
		//add cookie to resp
		resp.addCookie(ck1); resp.addCookie(ck2); //inmemory cookies
		resp.addCookie(ck3); resp.addCookie(ck4); //persistence cookies
		
		pw.println("<h1 style='color: red; text-align: center;'>Coolies added successfully...</h1>");
		
		pw.close();

	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}
}
