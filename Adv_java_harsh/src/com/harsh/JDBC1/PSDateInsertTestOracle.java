package com.harsh.JDBC1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.text.SimpleDateFormat;
import java.util.Scanner;

public class PSDateInsertTestOracle {
	public static final String INSERT_PERSON_INFO_DATES = "INSERT INTO PERSON_INFO_DATES VALUES(PID_SEQ.NEXTVAL,?,?,?)";

	public static void main(String[] args) {
		Scanner sc = null;
		Connection con = null;
		PreparedStatement ps = null;

		try {
			sc = new Scanner(System.in);

			String name = null, dob = null, city = null;

			if (sc != null) {
				System.out.print("Enter name : ");
				name = sc.nextLine();
				System.out.print("Enter DOB : ");
				dob = sc.nextLine();
				System.out.print("Enter city : ");
				city = sc.nextLine();
			}

			// convert String date value to java.util.Date class ob
			SimpleDateFormat spf1 = new SimpleDateFormat("dd-MM-yyyy");
			java.util.Date udob = spf1.parse(dob);

			// converting java.util.Date class obi to java.sql.Date class obj
			long ms = udob.getTime();
			java.sql.Date sqdob = new java.sql.Date(ms);

			/*
			 * //for DOJ (yyyy-MM-dd -Direct conversion ) //converting String date value to
			 * java.sql.Date class ob String sdoj = null; java.sql.Date sqdoj =
			 * java.sql.Date.valueOf(sdoj);
			 * 
			 * ------------------------------------------------------------------- //for
			 * DOM(MMM-dd-yyyy) //convert String date value to java.util.Date cla
			 * SimpleDateFormat sdf2=new SimpleDateFormat("MMM-dd-yyyy"); String sdom =
			 * null; java.util.Date udom = sdf2.parse(sdom);
			 * 
			 * // converting java.util.Date class obj to java.sql.Date class obi
			 * ms=udom.getTime(); java.sql.Date sqdom=new java.sql.Date(ms);
			 * 
			 */

			Class.forName("oracle.jdbc.driver.OracleDriver");

			con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "harsh", "tiger");

			if (con != null) {
				ps = con.prepareStatement(INSERT_PERSON_INFO_DATES);
			}

			if (ps != null) {
				ps.setString(1, name);
				ps.setDate(2, sqdob);
				ps.setString(3, city);
			}

			int k = 0;
			if (ps != null) {
				k = ps.executeUpdate();
			}

			if (k == 0) {
				System.out.println("record not Inserted");
			} else {
				System.out.println("record Inserted");
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
	}

}
