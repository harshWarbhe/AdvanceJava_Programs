package com.harsh.servlet;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletRequestWrapper;

public class CustomerRequest extends HttpServletRequestWrapper {

	private HttpServletRequest request ;

	public CustomerRequest(HttpServletRequest request) {
		super(request);
		System.out.println("CustomerRequest : 1-param constructor");
		this.request = request;
	}
	
	@Override
	public String getParameter(String name) {
		System.out.println("CustomerRequest.getParameter(-)");
		String paramValue =request.getParameter(name);
		if (name.equals("email")) {
			if (!paramValue.endsWith("@gmail.com")) {
				paramValue = paramValue+"@gmail.com";
			}
		}
		
		return paramValue;
	}

}
