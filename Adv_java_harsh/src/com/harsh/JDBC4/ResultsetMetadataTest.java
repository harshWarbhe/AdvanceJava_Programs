package com.harsh.JDBC4;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;

public class ResultsetMetadataTest {

	public static void main(String[] args) {
		try (Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "harsh", "tiger");
				Statement st = con.createStatement();
				ResultSet rs = st.executeQuery("select * from student1")) {

			ResultSetMetaData rsmd = null;
			if (rs != null) {
				rsmd = rs.getMetaData();

				if (rsmd != null) {
					int colcound = rsmd.getColumnCount();
					for (int i = 1; i <= colcound; i++) {
						System.out.println("\n" + rsmd.getColumnClassName(i));
					}

					for (int i = 1; i <= colcound; i++) {
						System.out.println("\n" + rsmd.getColumnTypeName(i));
					}

					while (rs.next()) {
						for (int i = 1; i <= colcound; i++) {
							System.out.println("\n" + rs.getString(i));
						}
					}

				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
