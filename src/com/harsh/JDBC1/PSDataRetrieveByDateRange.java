package com.harsh.JDBC1;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.Scanner;

public class PSDataRetrieveByDateRange {
	private static final String RETRIEVE_PERSON_INFO_DATE = "SELECT PID,PNAME,DOB,CITY FROM PERSON_INFO_DATES WHERE DOB>=? AND DOB <=?";

	public static void main(String[] args) {

		Scanner sc = null;
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;

		try {
			sc = new Scanner(System.in);

			String startdob = null, enddob = null;

			if (sc != null) {
				System.out.print("Enter starting range of DOB(dd-mm-yyyy) : ");
				startdob = sc.nextLine();
				System.out.print("Enter ending range of DOB(dd-mm-yyyy) : ");
				enddob = sc.nextLine();

			}

			/*
			 * // convert String date value to java.util.Date class ob 
			 * SimpleDateFormat spf1 = new SimpleDateFormat("dd-MM-yyyy"); 
			 * java.util.Date udob = spf1.parse(dob);
			 * 
			 * // converting java.util.Date class obi to java.sql.Date class obj 
			 * long ms = udob.getTime(); 
			 * java.sql.Date sqdob = new java.sql.Date(ms);
			 */

			// convert String date value to java.util.Date class ob
			SimpleDateFormat spf1 = new SimpleDateFormat("dd-MM-yyyy");
			java.sql.Date ssqldob = new java.sql.Date(spf1.parse(startdob).getTime());
			java.sql.Date esqldob = new java.sql.Date(spf1.parse(enddob).getTime());

			Class.forName("oracle.jdbc.driver.OracleDriver");

			con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "harsh", "tiger");

			if (con != null) {
				ps = con.prepareStatement(RETRIEVE_PERSON_INFO_DATE);
			}

			if (ps != null) {
				ps.setDate(1, ssqldob);
				ps.setDate(2, esqldob);
			}

			if (ps != null) {
				rs = ps.executeQuery();
			}

			if (rs != null) {
				boolean flag = false;
				while (rs.next()) {
					flag = true;
					int pid = rs.getInt(1);
					String pname = rs.getString(2);
					java.sql.Date sqldob = rs.getDate(3);
					String city = rs.getString(4);

					// convert java.sql.Date class obj to String date value
					SimpleDateFormat sdf2 = new SimpleDateFormat("dd-mm-yyyy");
					String dob = sdf2.format(sqldob);

					System.out.println(pid + "\t" + pname + "\t" + dob + "\t" + city);

				}
				if (flag==false) {
					System.out.println("no record are found");
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

	}

}
