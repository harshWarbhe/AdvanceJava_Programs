package com.harsh.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.Month;
import java.util.Arrays;

import org.apache.jasper.tagplugins.jstl.core.If;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/formurl")
public class FormCompsServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// get printWriter
		PrintWriter pw = resp.getWriter();

		// set context type
		resp.setContentType("text/html");

		// read form data
		String name = req.getParameter("pname");
		String addrs = req.getParameter("paddrs");
		int age = Integer.parseInt(req.getParameter("page"));
		String gender = req.getParameter("gender");

		String ms = req.getParameter("maritalStatus");
		ms = (ms == null) ? "single" : ms;

		String qlfy = req.getParameter("qlfy");

		String language[] = req.getParameterValues("language");
		if (language == null) {
			language = new String[] { "no language are selected" };
		}

		String hobies[] = req.getParameterValues("hb");
		if (hobies == null) {
			hobies = new String[] { "no hobbies are selected" };
		}

		String dob = req.getParameter("dob");
		String tob = req.getParameter("tob");
		String mob = req.getParameter("mob");
		String wdob = req.getParameter("wdob");
		int favNumber = Integer.parseInt(req.getParameter("favNumber"));
		long mobileNo = Long.parseLong(req.getParameter("mobileNo"));
		String mail = req.getParameter("mail");
		String favColor = req.getParameter("favColor");
		int income = Integer.parseInt(req.getParameter("income"));
		String fburl = req.getParameter("fburl");
		String favSearch = req.getParameter("favSearch");

		// b.logic
		if (gender.equalsIgnoreCase("M")) {
			if (age < 5) {
				pw.println("<h1 style='color:blue; text-align:center'>Master: " + name + " you are a baby boy </h1>");
			} else if (age < 13) {
				pw.println("<h1 style='color:blue; text-align:center'>Master: " + name + " you are a small boy </h1>");
			} else if (age < 19) {
				pw.println("<h1 style='color:blue; text-align:center'>Mr: " + name + " you are a teenage boy </h1>");
			} else if (age < 35) {
				pw.println("<h1 style='color:blue; text-align:center'>Mr: " + name + " you are a young man </h1>");
			} else if (age < 50) {
				pw.println(
						"<h1 style='color:blue; text-align:center'>Mr: " + name + " you are a middle aged man </h1>");
			} else {
				pw.println("<h1 style='color:blue; text-align:center'>Mr: " + name + ", you are a senior citizen </h1>");
			}
		} else {
			if (age < 5) {
				pw.println("<h1 style='color:blue; text-align:center'>Master: " + name + " you are a baby girl </h1>");
			} else if (age < 13) {
				pw.println("<h1 style='color:blue; text-align:center'>Master: " + name + " you are a small girl </h1>");
			} else if (age < 19) {
				if (ms.equalsIgnoreCase("married")) {
					pw.println(
							"<h1 style='color:blue; text-align:center'>Mrs: " + name + " you are a teenage girl </h1>");
				} else
					pw.println("<h1 style='color:blue; text-align:center'>Miss: " + name
							+ " you are a teenage girl </h1>");
			} else if (age < 35) {
				if (ms.equalsIgnoreCase("married")) {
					pw.println(
							"<h1 style='color:blue; text-align:center'>Mrs: " + name + " you are a young women</h1>");
				} else
					pw.println(
							"<h1 style='color:blue; text-align:center'>Miss: " + name + " you are a young women </h1>");
			} else if (age < 50) {
				if (ms.equalsIgnoreCase("married")) {
					pw.println("<h1 style='color:blue; text-align:center'>Mrs: " + name
							+ " you are a middle aged women </h1>");
				} else
					pw.println("<h1 style='color:blue; text-align:center'>Master: " + name
							+ " you are a middle aged women </h1>");
			} else {
				if (ms.equalsIgnoreCase("married")) {
					pw.println("<h1 style='color:blue; text-align:center'>Mrs: " + name + " you are a buddi</h1>");
				}
				pw.println("<h1 style='color:blue; text-align:center'>Mr: " + name + ", you are a senior citizen </h1>");
			}
		}

		// display form data
		pw.println("<br><br><b> from data ::</b><br>");
		pw.println("<br><b>Name :: </b>" + name);
		pw.println("<br><b>Addres :: </b>" + addrs);
		pw.println("<br><b>Age :: </b>" + age);
		pw.println("<br><b>Gender :: </b>" + gender);
		pw.println("<br><b>maritial Status :: </b>" + ms);
		pw.println("<br><b>Qualification :: </b>" + qlfy);
		pw.println("<br><b>Language :: </b>" + Arrays.toString(language));
		pw.println("<br><b>Hobbies :: </b>" + Arrays.toString(hobies));
		pw.println("<br><b>Date of Birth :: </b>" + dob);
		pw.println("<br><b>Time of birth :: </b>" + tob);
		pw.println("<br><b>Month of birth :: </b>" + mob);
		pw.println("<br><b>week number name of birth in DOB year :: </b>" + wdob);
		pw.println("<br><b>select fav number :: </b>" + favNumber);
		pw.println("<br><b>Phone number :: </b>" + mobileNo);
		pw.println("<br><b>Email id :: </b>" + mail);
		pw.println("<br><b>fav Color :: </b>" + favColor);
		pw.println("<br><b>personal Income :: </b>" + income);
		pw.println("<br><b>Fb url :: </b>" + fburl);
		pw.println("<br><b>Fav Google search :: </b>" + favSearch);

		pw.println("<br><a href='all_comps_form.html'>Home</a>");

		pw.close();

	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}
}
