package com.harsh.JDBC1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class OracleToMySQLDataTransfer {
	private static final String ORACEL_SELECT_STUDENT = "SELECT SNO,SNAME,SADD,AVG FROM STUDENT1";
	private static final String MYSQL_INSERT_STUDENT = "INSERT INTO STUDENT1 VALUES(?,?,?,?)";

	public static void main(String[] args) {
		Scanner sc = null;
		Connection oracleCon = null, mysqlCon = null;
		Statement st = null;
		PreparedStatement ps = null;
		ResultSet rs = null;

		try {
			sc = new Scanner(System.in);

			Class.forName("oracle.jdbc.driver.OracleDriver");
			Class.forName("com.mysql.cj.jdbc.Driver");

			oracleCon = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "harsh", "tiger");
			mysqlCon = DriverManager.getConnection("jdbc:mysql:///harsh", "root", "Admin123");

			if (oracleCon != null) {
				st = oracleCon.createStatement();
			}

			if (mysqlCon != null) {
				ps = mysqlCon.prepareStatement(MYSQL_INSERT_STUDENT);
			}

			if (st != null) {
				;
				rs = st.executeQuery(ORACEL_SELECT_STUDENT);
			}

			int insertedCount = 0;
			if (rs != null && ps != null) {

				while (rs.next()) {
					int sno = rs.getInt(1);
					String sname = rs.getString(2);
					String sadd = rs.getString(3);
					float avg = rs.getFloat(4);

					ps.setInt(1, sno);
					ps.setString(2, sname);
					ps.setString(3, sadd);
					ps.setFloat(4, avg);

					int k = ps.executeUpdate();
					if (k > 0) {
						insertedCount++;
					}

				}
				System.out.println(
						insertedCount + " Records are copied from oracle db table to mysql Db table successfully");

			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null)
					rs.close();
			} catch (Exception e) {
			}
			try {
				if (st != null)
					st.close();
			} catch (Exception e) {
			}
			try {
				if (ps != null)
					ps.close();
			} catch (Exception e) {
			}
			try {
				if (oracleCon != null)
					oracleCon.close();
			} catch (Exception e) {
			}
			try {
				if (mysqlCon != null)
					mysqlCon.close();
			} catch (Exception e) {
			}
		}

	}

}
