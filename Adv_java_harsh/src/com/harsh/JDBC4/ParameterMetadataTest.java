package com.harsh.JDBC4;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ParameterMetaData;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;

public class ParameterMetadataTest {

	public static void main(String[] args) {
		try (Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "harsh", "tiger");
				PreparedStatement ps = con.prepareStatement("Insert into student1 values(?,?,?,?)");) {

			ParameterMetaData pmmd = ps.getParameterMetaData();
			if (pmmd!=null) {
				int paramCount = pmmd.getParameterCount();
				for (int i = 1; i < paramCount; i++) {
					System.out.println("\nparameter count:: "+i);
					System.out.println("\nparameter mode name:: "+pmmd.getParameterMode(i));
					System.out.println("\nparameter type name:: "+pmmd.getParameterTypeName(i));
					System.out.println("\nparameter is signed:: "+pmmd.isSigned(i));
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
