//Java App to get Employee details based on given intial characters Employee name

package com.harsh.JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class SelectTest4 {

	public static void main(String[] args) {
		Scanner sc = null;
		Connection con = null;
		Statement st = null;
		ResultSet rs = null;
		String initCharString = null;

		try {

			System.out.println("Java App to get Employee details based on given intial characters Employee name");
			sc=new Scanner(System.in);
			System.out.print("Enter intial characters Employee name : ");
			initCharString = sc.next();

			initCharString = "" + initCharString + "%";

			Class.forName("oracle.jdbc.driver.OracleDriver");

			con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "harsh", "tiger");

			if (con != null)
				st = con.createStatement();

			String query = "SELECT EMPNO, ENAME, JOB, SAL FROM EMP WHERE ENAME LIKE '" + initCharString+"'" ;
			System.out.println(query);

			if (st != null)
				rs = st.executeQuery(query);

			if (rs != null) {
				boolean flag = false;
				while (rs.next()) {
					flag = true;
					System.out.println(rs.getInt(1) + "	" + rs.getString(2) + "	" + rs.getString(3) + "	"
							+ rs.getFloat(4) + "	");
				}
				if (flag == false) {
					System.out.println("no record found");
				}

			}

		} catch (SQLException se) {
			if (se.getErrorCode() >= 900 && se.getErrorCode() <= 999)
				System.out.println("invalid col name or table name or SQL keywords");
			se.printStackTrace();

		} catch (Exception e) {
			e.printStackTrace();
			;
		} finally {
			try {
				if (con != null)
					con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}

			try {
				if (st != null)
					st.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}

			try {
				if (rs != null)
					rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

	}

}
