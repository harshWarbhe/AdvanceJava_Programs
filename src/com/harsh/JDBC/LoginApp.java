package com.harsh.JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class LoginApp {

	public static void main(String[] args) {
		Scanner sc = null;
		Connection con = null;
		Statement st = null;
		ResultSet rs = null;

		try {
			sc = new Scanner(System.in);
			String username = null, password = null;

			System.out.println("login credencial check, db table using username and password \n");
			System.out.print("Enter username: ");
			username = sc.next();
			System.out.print("Enter password: ");
			password = sc.next();

			Class.forName("oracle.jdbc.driver.OracleDriver");

			con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "harsh", "tiger");

			if (con != null) {
				st = con.createStatement();
			}

			String query = "SELECT COUNT(*) FROM IRCTC_TAB WHERE UNAME='" + username + "' AND PWD= '" + password + "'";
			System.out.println(query + "\n");

			if (st != null) {
				rs = st.executeQuery(query);
			}

			if (rs != null) {
				rs.next();
				int count = rs.getInt(1);

				if (count == 0) {
					System.out.println("invalid credentials");
				} else {
					System.out.println("valid credentials");
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			try {if (con!=null) {
				con.close();
			}
				
			} catch (Exception e2) {
				// TODO: handle exception
			}
		}

	}

}
