//write a JDBC App insert record into Student Db table by collecting inputs from Enduser?

package com.harsh.JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class InsertTest9 {

	public static void main(String[] args) {
		Scanner sc = null;
		Connection con = null;
		Statement st = null;
		ResultSet rs = null;

		try {
			sc = new Scanner(System.in);
			int sno = 0;
			String name = null, add = null;
			float avg = 0.0f;

			System.out.println(
					"write a JDBC App insert record into Student Db table by collecting inputs from Enduser?\n");

			System.out.print("Enter sno: ");
			sno = sc.nextInt();
			sc.nextLine();// consume leftover newline
			System.out.print("Enter name: ");
			name = sc.nextLine();
			System.out.print("Enter address: ");
			add = sc.nextLine();
			System.out.print("Enter average: ");
			avg = sc.nextFloat();
			sc.nextLine();

			Class.forName("oracle.jdbc.driver.OracleDriver");

			con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "harsh", "tiger");

			if (con != null) {
				st = con.createStatement();
			}

			String query = "INSERT INTO STUDENT1 VALUES(" + sno + ", '" + name + "', '" + add + "', " + avg + ")";
			System.out.println(query);

			int count = 0;
			if (st != null) {
				count = st.executeUpdate(query);
			}

			if (count == 0) {
				System.out.println("record not inserted");
			} else {
				System.out.println("record inserted");
			}

			System.err.println("want to display table (Y/N): ");
			String choise = sc.nextLine().toUpperCase();

			if (choise.equalsIgnoreCase("Y")) {
				String query2 = "SELECT * FROM STUDENT1";
				System.out.println(query2 + "\n");

				if (st != null)
					rs = st.executeQuery(query2);

				if (rs != null) {
					while (rs.next()) {
						System.out.println(
								rs.getInt(1) + "\t" + rs.getString(2) + "\t" + rs.getString(3) + "\t" + rs.getFloat(4));
					}
				}
			} else {
				System.out.println("program completed...");
			}

		} catch (

		SQLException se) {
			if (se.getErrorCode() == 1)
				System.err.println("Duplicates can not inserted to PK column");
			if (se.getErrorCode() == 1400)
				System.out.println("NULL can not inserted to PK column");
			if (se.getErrorCode() >= 900 && se.getErrorCode() <= 999)
				System.err.println("invalid col name or table name or sql keyword");
			else if (se.getErrorCode() == 12899)
				System.out.println("Do not insert more than col size data to sname.sadd cols");

			System.out.println("Problem in record insertion ...... ");

			se.printStackTrace();
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
