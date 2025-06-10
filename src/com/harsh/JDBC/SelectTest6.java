package com.harsh.JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;


public class SelectTest6 {

	public static void main(String[] args) {
		Scanner sc = null;
		Connection con = null;
		Statement st = null;
		ResultSet rs = null;
		String query = null;

		try {

			System.out.println("write a JDBC program thet give employees detail who having highest salary");

			Class.forName("oracle.jdbc.driver.OracleDriver");

			con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "harsh", "tiger");

			if (con != null) {
				st = con.createStatement();
			}

			query = "SELECT EMPNO, ENAME, JOB, SAL FROM EMP WHERE SAL=(SELECT MAX(SAL) FROM EMP)";
			System.out.println(query+"\n");

			if (st != null) {
				rs = st.executeQuery(query);
			}

			if (rs != null) {
				boolean flag = false;
				while (rs.next()) {
					flag = true;
					System.out.println(
							rs.getInt(1) + " " + rs.getString(2) + " " + rs.getString(3) + " " + rs.getFloat(4));
				}

				if (flag == false) {
					System.out.println("no record found");
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (con != null)
					con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

}
