package com.harsh.JDBC1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

public class PSAgaCalulatorMYSQL {
	private static final String AGECALULATOR_PERSON_INFO_DATES = "SELECT TIMESTAMPDIFF(DAY,DOB,CURDATE())/365.25 FROM PERSON_INFO_DATES WHERE PID = ?";

	public static void main(String[] args) {

		Scanner sc = null;
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;

		try {

			sc = new Scanner(System.in);

			int pid = 0;
			System.out.println("MYSQL app to findout the age of person based on pid (use dob col in sql query)\n");
			System.out.print("Enter pid : ");
			pid = sc.nextInt();

			Class.forName("com.mysql.cj.jdbc.Driver");

			con = DriverManager.getConnection("jdbc:mysql:///harsh1","root","Admin123");
			// con = DriverManager.getConnection("jdbc:mysql://@localhost:3360/harsh:root:Admin123");

			if (con != null) {
				ps = con.prepareStatement(AGECALULATOR_PERSON_INFO_DATES);
			}

			if (ps != null) {
				ps.setInt(1, pid);
			}
			
			if (ps!=null) {
				rs = ps.executeQuery();
			}

			if (rs != null) {
				if (rs.next()) {
					float age = rs.getFloat(1);
					System.out.println("person age: " + age);
				} else {
					System.out.println("person not found");
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (con != null) {
					con.close();
				}

			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		{
			try {
				if (sc != null) {
					sc.close();
				}

			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
	}

}
