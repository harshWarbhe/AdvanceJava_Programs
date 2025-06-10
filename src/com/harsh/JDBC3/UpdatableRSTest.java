package com.harsh.JDBC3;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class UpdatableRSTest {

	private static final String EMP_SELECT_QUERY_INSENSITIVE = "SELECT SNO, SNAME, SADD, AVG FROM STUDENT1 order by sno";

	public static void main(String[] args) {

		try (Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "harsh", "tiger");
				PreparedStatement ps = con.prepareStatement(EMP_SELECT_QUERY_INSENSITIVE,
						ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
				ResultSet rs = ps.executeQuery();) {

			if (rs != null) {
				System.out.println("RS recprdd from top to bottom");
				while (rs.next()) {
					System.out.println(rs.getRow() + "---->" + rs.getInt(1) + "\t" + rs.getString(2) + "\t"
							+ rs.getString(3) + "\t" + rs.getFloat(4));

					Thread.sleep(300);
//					// insert operation
//					rs.moveToInsertRow();
//					rs.updateInt(1, 107);
//					rs.updateString(2, "max");
//					rs.updateString(3, "hyd");
//					rs.updateFloat(4, 84.55f);
//					rs.insertRow();
//					System.out.println("Record inserted ");

//							//update operation
//							rs.absolute(4);
//							rs.updateFloat(4,99.9f);
//							rs.updateRow() ;
//							
//							//delete operation
//							rs.absolute(3);
//							rs.deleteRow();

				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
