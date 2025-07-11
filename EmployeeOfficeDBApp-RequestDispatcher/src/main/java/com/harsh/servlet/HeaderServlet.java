package com.harsh.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/headerurl")
public class HeaderServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// get printWriter
		PrintWriter pw = resp.getWriter();

		// set context type
		resp.setContentType("text/html");

		// write header content
		//pw.println("<header><marquee><h1 style='color: blue; text-align: center'>H A R S H Technologies</h1></marquee></header>");
		pw.println("<header><div style='color: blue; font-size: 24px; font-weight: bold; text-align: center; animation: scroll-left 10s linear infinite; white-space: nowrap; overflow: hidden; display: block;'>H A R S H Technologies</div><style>@keyframes scroll-left {0% {transform: translateX(100%);}100% {transform: translateX(-100%);}}</style></header>");

		
		// dont close pw stream

	}
}
