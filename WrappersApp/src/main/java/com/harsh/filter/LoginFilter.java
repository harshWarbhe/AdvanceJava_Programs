package com.harsh.filter;

import java.io.IOException;
import java.io.PrintWriter;

import com.harsh.servlet.CustomerRequest;
import com.harsh.servlet.CustomerResponse;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebFilter("/loginurl")
public class LoginFilter extends HttpFilter {

	@Override
	protected void doFilter(HttpServletRequest request, HttpServletResponse response, FilterChain chain)
			throws IOException, ServletException {

		// create customRequest obj
		CustomerRequest creq = new CustomerRequest(request);

		// create customResponse obj
		CustomerResponse cresp = new CustomerResponse(response);

		chain.doFilter(creq, cresp); // calls next filter or destination comp

		// collect the data form custom response obj
		String output = cresp.toString();

		// modify the content
		output = output + "<br> <b> H A R S H </b>";

		// get printWriter
		PrintWriter pw = response.getWriter();
		pw.println(output);//writes container created response obj -- > container -- > server --- > browser window

		pw.close();

	}
}
