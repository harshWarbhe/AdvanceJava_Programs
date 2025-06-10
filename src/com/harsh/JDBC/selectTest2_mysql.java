package com.harsh.JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class selectTest2_mysql {

	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		

		Class.forName("com.mysql.cj.jdbc.Driver");

		//Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "harsh", "tiger");
		
		Connection con = DriverManager.getConnection("jdbc:mysql:///harsh", "root", "Admin123");
		
		//Connection con = DriverManager.getConnection("jdbc:mysql://@localhost:3360/harsh", "root", "Admin123");

		Statement st = con.createStatement();

		//String query = "select empno,ename,job,sal from emp where sal>=" + startSalary + " and sal<=" + endSalary;
		String query = "select * from student1";

		ResultSet rs = st.executeQuery(query);

		while (rs.next() != false) {
			System.out
					.println(rs.getInt(1) + "   " + rs.getString(2) + "   " + rs.getString(3) + "   " + rs.getFloat(4));
		}

		con.close();

	}

}
