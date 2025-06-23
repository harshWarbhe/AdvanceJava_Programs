//write a JDBC program to modify student name, avg & sadd based on the given student number(sno)
package com.harsh.JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class UpdateTest8 {
	public static void main(String[] args) {
		Scanner sc = null;
		Connection con = null;
		Statement st = null;
		String query = null;

		try {

			System.out.println(
					"write a JDBC program to modify student name, avg & sadd based on the given student number(sno)");

			sc = new Scanner(System.in);
			System.out.print("Enter name name: ");
			String sName = sc.nextLine();
			System.out.print("Enter address : ");
			String sAdd = sc.nextLine();
			System.out.print("Enter average : ");
			float sAvg = sc.nextFloat();
			System.out.print("Enter sno: ");
			int sNo = sc.nextInt();

			Class.forName("oracle.jdbc.driver.OracleDriver");

			con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "harsh", "tiger");

			if (con != null) {
				st = con.createStatement();
			}

			sName = "'" + sName + "'";
			sAdd = "'" + sAdd + "'";

			query = "UPDATE STUDENT1 SET SNAME=" + sName + ", AVG =" + sAvg + ", SADD=" + sAdd + " WHERE SNO=" + sNo;
			System.out.println(query + "\n");

			int k = 0;
			if (st != null) {
				k = st.executeUpdate(query);
			}

			if (k == 0) {
				System.out.println("No record is updated.");
			} else {
				System.out.println("no. of record that are Updated " + k);
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
