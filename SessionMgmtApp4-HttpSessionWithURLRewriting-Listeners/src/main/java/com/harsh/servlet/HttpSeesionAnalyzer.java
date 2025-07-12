package com.harsh.servlet;

import java.util.Date;

import jakarta.servlet.ServletContext;
import jakarta.servlet.annotation.WebListener;
import jakarta.servlet.http.HttpSessionEvent;
import jakarta.servlet.http.HttpSessionListener;

@WebListener
public class HttpSeesionAnalyzer implements HttpSessionListener {

	private long start, end;

	public HttpSeesionAnalyzer() {
		System.out.println("SeesionAnalyzer :: 0-parameter constructor");

	}
	
	@Override
	public void sessionCreated(HttpSessionEvent se) {
		start = System.currentTimeMillis();
		System.out.println("session stratted at :: "+new Date());
		//get Access to servletContext
		ServletContext sc = se.getSession().getServletContext();
		sc.log("session stratted at :: "+new Date());
	}
	
	@Override
	public void sessionDestroyed(HttpSessionEvent se) {
		end = System.currentTimeMillis();
		System.out.println("session ended at :: "+new Date());
		//get Access to servletContext
		ServletContext sc = se.getSession().getServletContext();
		sc.log("session ended at :: "+new Date());
		
		System.out.println("session duration :: "+(start-end)+"ms");
		sc.log("session duration :: "+(start-end)+"ms");
	}

}
