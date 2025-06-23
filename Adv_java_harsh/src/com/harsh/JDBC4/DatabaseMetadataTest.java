package com.harsh.JDBC4;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;

public class DatabaseMetadataTest {

	public static void main(String[] args) {
		try (Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "harsh", "tiger");) {

			DatabaseMetaData dbmd = con.getMetaData();
			
			if (dbmd!=null) {
				System.out.println("db s/w name:: "+dbmd.getDatabaseProductName());
				System.out.println("\ndb s/w version:: "+dbmd.getDatabaseProductVersion());
				System.out.println("\ndb driver name:: "+dbmd.getDriverName());
				System.out.println("\njdbc driver version:: "+dbmd.getDriverVersion());
				System.out.println("\njdbc driver version:: "+dbmd.getDriverVersion());
				System.out.println("\nAll sql keywords:: "+dbmd.getSQLKeywords());
				System.out.println("\nAll numeric function:: "+dbmd.getNumericFunctions());
				System.out.println("\nAll string function:: "+dbmd.getStringFunctions());
				System.out.println("\nMAX char in table name:: "+dbmd.getMaxTableNameLength());
				System.out.println("\nMAX table in select query:: "+dbmd.getMaxTablesInSelect());
				System.out.println("\nmax row size:: "+dbmd.getMaxRowSize());
				System.out.println("\nsupport pl/sql procedure?:: "+dbmd.supportsStoredProcedures());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}


}
