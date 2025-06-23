//CREATE TABLE TEMP_STUDENT(SNO NUMBER(5) PRIMARY KEY ,SNAME VARCHAR2(15))
package com.harsh.JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class CreateTableTest10 {

	public static void main(String[] args) {
		Scanner sc = null;
		Connection con = null;
		Statement st = null;

		try {

			Class.forName("oracle.jdbc.driver.OracleDriver");

			con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "harsh", "tiger");

			if (con != null) {
				st = con.createStatement();
			}

			String query = "CREATE TABLE TEMP_STUDENT(SNO NUMBER(3) PRIMARY KEY, SNAME VARCHAR2(20))";
			String query2 = "DROP TABLE TEMP_STUDENT PURGE";
			System.out.println(query + "\n");

			int count = 0;
			if (st != null) {
				count = st.executeUpdate(query);

				System.out.println(count + "\n"); // count = 0
			}

			if (count == 0) {
				System.out.println("Table is created "); //
			} else {
				System.out.println("Table is not created. ");
			}

		} catch (SQLException e) {
			e.printStackTrace();
			if (e.getErrorCode() == 955)
				System.out.println("DB table already created");
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
