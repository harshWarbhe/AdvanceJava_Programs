package com.harsh.JDBC1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

public class PSAgaCalulatorOracle {
	private static final String AGECALULATOR_PERSON_INFO_DATES = "SELECT ROUND((SYSDATE-DOB)/365.25,2) FROM PERSON_INFO_DATES WHERE PID =? ";

	public static void main(String[] args) {
		Scanner sc = null;
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;

		try {

			sc = new Scanner(System.in);

			int pid = 0;
			System.out.println("JDBC app to findout the age of person based on pid (use dob col in sql query)\n");
			System.out.print("Enter pid : ");
			pid = sc.nextInt();

			Class.forName("oracle.jdbc.driver.OracleDriver");

			con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "harsh", "tiger");

			if (con != null) {
				ps = con.prepareStatement(AGECALULATOR_PERSON_INFO_DATES);
			}

			if (ps != null) {
				ps.setInt(1, pid);
			}

			if (ps != null) {
				rs = ps.executeQuery();
			}

			if (rs != null) {
				if (rs.next()) {
					float age = rs.getFloat(1);
					System.out.println("person age: "+age);	
				}
				else {
					System.out.println("person not Fount");
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (con != null)
					con.close();

			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}

	}

}
