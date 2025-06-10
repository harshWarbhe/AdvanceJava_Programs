//write a JDBC App to delete student records based given city name (sadd)
package com.harsh.JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class DeleteTest7 {

	public static void main(String[] args) {
		Scanner sc = null;
		Connection con = null;
		Statement st = null;
		String city = null;
		String query = null;

		try {
			System.out.println("write a JDBC App to delete student records based given city name (sadd)\n");

			sc = new Scanner(System.in);
			System.out.print("Enter city name: ");
			city = sc.next().toLowerCase();

			Class.forName("oracle.jdbc.driver.OracleDriver");

			con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "harsh", "tiger");

			if (con != null) {
				st = con.createStatement();
			}

			query = "DELETE FROM STUDENT1 WHERE city= '" + city + "'";

			int k = 0;
			if (st != null) {
				k = st.executeUpdate(query);
			}

			if (k == 0) {
				System.out.println("No record found to delete.");
			} else {
				System.out.println("no. of record that are deleted " + k);
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (con != null)
					con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

}
