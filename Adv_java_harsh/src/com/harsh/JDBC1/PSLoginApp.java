package com.harsh.JDBC1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

public class PSLoginApp {
	public static final String LOGIN_QUERY = "SELECT COUNT(*) FROM IRCTC_TAB WHERE UNAME = ? AND PWD = ? ";

	public static void main(String[] args) {

		Scanner sc = null;
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;

		try {

			sc = new Scanner(System.in);
			String username = null, password = null;

			System.out.println("login into irctc table with username and password by using prepared statement");

			System.out.print("Enter username : ");
			username = sc.nextLine();

			System.out.print("Enter password : ");
			password = sc.nextLine();

			Class.forName("oracle.jdbc.driver.OracleDriver");

			con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "harsh", "tiger");

			if (con != null) {
				ps = con.prepareStatement(LOGIN_QUERY);
			}

			if (ps != null) {
				ps.setString(1, username);
				ps.setString(2, password);
			}

			if (ps != null) {
				rs = ps.executeQuery();
			}

			if (rs != null) {
				rs.next();

				int count = rs.getInt(1);

				System.out.println(count);

				if (count == 0) {
					System.out.println("Invalid credentials");
				} else {
					System.out.println("valid credentials");
				}
			}

		} catch (Exception e) {
			// TODO: handle exception
		}

	}

}
