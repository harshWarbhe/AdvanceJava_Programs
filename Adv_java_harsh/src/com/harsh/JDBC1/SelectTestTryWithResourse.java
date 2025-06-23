package com.harsh.JDBC1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class SelectTestTryWithResourse {
	private static final String SELECT_STUDENT1 = "SELECT SNO,SNAME,SADD,AVG FROM STUDENT1 	ORDER BY SNO";
	

	public static void main(String[] args) {
		System.out.println("SelectTestTryWithResourse.main()\n");
		try (
				Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "harsh", "tiger");

				Statement st = con.createStatement();

				ResultSet rs = st.executeQuery(SELECT_STUDENT1);) {
			if (rs != null) {
				boolean flag = false;
				while (rs.next()) {
					flag = true;
					System.out.println(
							rs.getInt(1) + "\t" + rs.getString(2) + "\t" + rs.getString(2) + "\t" + rs.getFloat(4));

				}
				if (flag == false) {
					System.out.println("No Records found");
					
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
