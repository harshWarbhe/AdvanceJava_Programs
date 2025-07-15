package com.harsh.servlet;

import java.util.Date;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletContextEvent;
import jakarta.servlet.ServletContextListener;
import jakarta.servlet.annotation.WebListener;

@WebListener
public class WebMonitorListener implements ServletContextListener {
	private long start, end;

	public WebMonitorListener() {
		System.out.println("WebMonitorListener :: 0-parameter constructor");
	}
	
	@Override
	public void contextInitialized(ServletContextEvent sce) {
		System.out.println("WebMonitorListener :: contextInitialized()");
		start = System.currentTimeMillis();
		System.out.println("ServletContext session stratted at :: "+new Date());
		//get Access to servletContext obj 
		ServletContext sc = sce.getServletContext();
		sc.log("web Application is destroyed/ reloaded/ redeployed at : "+new Date());
		System.out.println("web Application is destroyes/ reloaded/ redeployed at : "+new Date());
	}
	
	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		end = System.currentTimeMillis();
		System.out.println("ServletContext session ended at :: "+new Date());
		//get Access to servletContext
		ServletContext sc = sce.getServletContext();
		sc.log("web Application is undeployed/stoped at : "+new Date());
		System.out.println("web Application is undeployed/stoped at : "+new Date());
	}

}
