package com.harsh.JDBC1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.DecimalFormat;
import java.util.Scanner;

public class PSAgeCalculatorGeneric {
	private static final String AGECALULATORGENERIC_PERSON_INFO_DATES = "SELECT DOB FROM PERSON_INFO_DATES WHERE PID = ?";

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
				ps = con.prepareStatement(AGECALULATORGENERIC_PERSON_INFO_DATES);
			}

			if (ps != null) {
				ps.setInt(1, pid);
			}

			if (ps != null) {
				rs = ps.executeQuery();
			}

			if (rs != null) {
				if (rs.next()) {
					java.sql.Date sqldob = rs.getDate(1);
					java.util.Date sysDate = new java.util.Date();
					float age = (sysDate.getTime()-sqldob.getTime())/(1000.0f*60.0f*60.0f*24.0f*365.25f);
					
					DecimalFormat df= new DecimalFormat("#.##");
					System.out.println("person age : "+df.format(age));
					
				}
				else {
					System.out.println("person not found");
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
