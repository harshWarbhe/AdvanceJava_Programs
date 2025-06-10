package com.harsh.JDBC3;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class SensitiveRSTest {
	private static final String EMP_SELECT_QUERY_SENSITIVE = "SELECT SNO, SNAME, SADD, AVG FROM STUDENT1 order by sno";

	public static void main(String[] args) {

		try (Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "harsh", "tiger");
				PreparedStatement ps = con.prepareStatement(EMP_SELECT_QUERY_SENSITIVE, ResultSet.TYPE_SCROLL_SENSITIVE,
						ResultSet.CONCUR_UPDATABLE);
				ResultSet rs = ps.executeQuery();) {

			if (rs != null) {
				System.out.println("RS recprdd from top to bottom");
				int count = 0;
				while (rs.next()) {
					if (count == 0) {
						Thread.sleep(8000);

						rs.refreshRow();
						count++;
						System.out.println(rs.getRow() + "---->" + rs.getInt(1) + "\t" + rs.getString(2) + "\t"
								+ rs.getString(3) + "\t" + rs.getFloat(4));
					}
				}

			}

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
