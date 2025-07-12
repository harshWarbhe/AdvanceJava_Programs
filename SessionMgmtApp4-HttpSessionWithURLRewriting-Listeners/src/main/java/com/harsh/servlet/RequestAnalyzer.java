package com.harsh.servlet;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletRequestEvent;
import jakarta.servlet.ServletRequestListener;
import jakarta.servlet.annotation.WebListener;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSessionListener;

@WebListener
public class RequestAnalyzer implements ServletRequestListener {

	private long start, end;

	public RequestAnalyzer() {
		System.out.println("RequestAnalyzer :: 0-parameter constructor");
	}

	@Override
	public void requestInitialized(ServletRequestEvent sre) {
		System.out.println("RequestAnalyzerListener.requestInitialized()");
		start = System.currentTimeMillis();
	}
	
	@Override
	public void requestDestroyed(ServletRequestEvent sre) {
		System.out.println("RequestAnalyzerListener.requestDestroyed()");
		end = System.currentTimeMillis();
		
		//get HttpServletRequest object
		HttpServletRequest req = (HttpServletRequest) sre.getServletRequest();

		//get HttpServletContext object
		ServletContext sc = sre.getServletContext();
		
		sc.log(req.getRequestURL()+"has taken"+(end-start)+"ms time to process the request");
		System.out.println(req.getRequestURI()+" has taken "+(end-start)+"ms time to process the request.");
	}

}
