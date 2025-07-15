package com.harsh.servlet;

import java.io.CharArrayWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Writer;

import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpServletResponseWrapper;

public class CustomerResponse extends HttpServletResponseWrapper {

	private HttpServletResponse response;
	private CharArrayWriter Writer;

	public CustomerResponse(HttpServletResponse response) {
		super(response);
		System.out.println("CustomerResponse : 1-param-constructor");
		this.response = response;
		Writer = new CharArrayWriter(); //internally creates bufffer and takes it as destination
	}

	@Override
	public PrintWriter getWriter() throws IOException {
		System.out.println("CustomerResponse.getWriter()");
		PrintWriter pw = new PrintWriter(Writer);	//Here indirectly PrintWriter stream is taking buffer as destination
		return pw;
	}
	
	@Override
	public String toString() {
		System.out.println("CustomerResponse.toString()");
		return Writer.toString();	//content collected from buffer is returned custom response obj content
	}

}
