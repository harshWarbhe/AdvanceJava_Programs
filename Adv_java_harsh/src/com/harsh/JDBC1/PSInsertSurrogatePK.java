package com.harsh.JDBC1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class PSInsertSurrogatePK {

	public static final String STUDENT1_INSERT_QUERY = "INSERT INTO STUDENT1 VALUES(SNO_SEQ1.NEXTVAL,?,?,?)";

	public static void main(String[] args) {

		Scanner sc = null;
		Connection con = null;
		PreparedStatement ps = null;

		try {
			sc = new Scanner(System.in);

			int count = 0;

			System.out.println("insert multiple values into db table in Student1 by using preparedStatement");

			System.out.print("Enter student count: ");
			count = sc.nextInt();
			sc.nextLine();

			Class.forName("oracle.jdbc.driver.OracleDriver");
			// register JDBC driver
			// Class.forName("com.mysql.cj.jdbc.Driver");

			con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "harsh", "tiger");
			// con=DriverManager.getConnection("jdbc:mysql:///harsh", "root", "Admin123"):

			if (con != null) {
				ps = con.prepareStatement(STUDENT1_INSERT_QUERY);

			}

			if (ps != null && sc != null) {
				for (int i = 1; i <= count; i++) {
					System.out.println("Enter " + i + " student detail: ");
//					System.out.print("Enter Student no : ");
//					int sno = sc.nextInt();
//					sc.nextLine();

					System.out.print("Enter Student name : ");
					String name = sc.nextLine();

					System.out.print("Enter Student address : ");
					String add = sc.nextLine();

					System.out.print("Enter Student average : ");
					float avg = sc.nextFloat();

					//ps.setInt(1, sno);
					ps.setString(1, name);
					ps.setString(2, add);
					ps.setFloat(3, avg);

					int k = ps.executeUpdate();

					if (k == 0) {
						System.out.println("Student " + i + " details not inserted.");
					} else {
						System.out.println("student " + i + " detail inserted successfully.");
					}
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
				// TODO: handle exception
			}
		}
	}

}
