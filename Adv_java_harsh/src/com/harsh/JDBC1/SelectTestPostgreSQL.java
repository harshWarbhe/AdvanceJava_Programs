package com.harsh.JDBC1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class SelectTestPostgreSQL {
	private static final String SELECT_PRODUCT_POSTGRESQL = "SELECT PID,PNAME,PRICE,QUANTITY,STATUS FROM product";
	//private static final String SELECT_PRODUCT_POSTGRESQL = "SELECT \"PID\", \"PNAME\", \"PRICE\", \"QUANTITY\", \"STATUS\" FROM PRODUCT";

	public static void main(String[] args) {

		/*
		 * Class.forName("org.postgresql.driver"); Connection con=
		 * DriverManager.getConnection("jdbc:postgresql:harsh","postgres","Admin123");
		 */
		try (Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/harsh", "postgres","Admin123");
				Statement st = con.createStatement();
				ResultSet rs = st.executeQuery("SELECT pid, pname, price, qty, status FROM public.\"PRODUCT\"");) {

			if (rs != null) {
				boolean flag = false;
				while (rs.next()) {
					flag = true;
					System.out.println(rs.getInt(1) + "\t" + rs.getString(2) + "\t" + rs.getString(3) + "\t"
							+ rs.getFloat(4) + "\t" + rs.getString(5));
				}
				if (flag == false) {
					System.out.println("no record found.");
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
