package com.harsh.filter;

import java.io.IOException;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebFilter("/*")
public class PerformanceFilter extends HttpFilter{

	@Override
	protected void doFilter(HttpServletRequest request, HttpServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		long startTime = 0L, endTime = 0L;
		
		startTime = System.currentTimeMillis();
		chain.doFilter(request, response);
		endTime = System.currentTimeMillis();
		
		System.out.println(request.getRequestURI()+" Time Taken : "+(endTime- startTime)+"ms to process the request.");
		

	}
}
