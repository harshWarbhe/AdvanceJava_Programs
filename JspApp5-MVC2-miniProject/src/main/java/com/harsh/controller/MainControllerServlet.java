package com.harsh.controller;

import java.util.*;

import javax.swing.text.html.HTML;

import java.io.IOException;
import java.io.PrintWriter;

import com.harsh.model.Employee;
import com.harsh.service.EmployeeMgmtServiceImpl;
import com.harsh.service.IEmployeeMgmtService;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class MainControllerServlet
 */
@WebServlet(urlPatterns = "/Controllerurl", loadOnStartup = 1)
public class MainControllerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public MainControllerServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	public IEmployeeMgmtService service;
	
	@Override
	public void init() throws ServletException {
		service = new EmployeeMgmtServiceImpl();
	}
	
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		//get printWriter
		PrintWriter pw = response.getWriter();
		
		//read data 
		String desg =request.getParameter("job");
		String action= request.getParameter("s1");
		
		//involve b.method on service class obj
		try {
			List<Employee> list = service.fetchEmpsDesg(desg);
			
			//keep the result in request scope to send to view comps
			request.setAttribute("empDetails", list);
			
			//forward the request to result page base on  the button is clicked
			String resultPage = null;
			if (action.equalsIgnoreCase("HTML Output")) {
				resultPage = "/html_Screen.jsp";
			}
			else {
				resultPage = "/Excel_Screen.jsp";
			}
			
			//forward  the reques to result page 
			RequestDispatcher rd = request.getRequestDispatcher(resultPage);
			rd.forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
			RequestDispatcher rd =request.getRequestDispatcher("/error.jsp");
			rd.forward(request, response);
		}
		
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
