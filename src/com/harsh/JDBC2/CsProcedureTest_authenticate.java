package com.harsh.JDBC2;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Types;
import java.util.Scanner;

public class CsProcedureTest_authenticate {
	private static final String CALL_PROCEDURE_QUERY = "{CALL P_AUTHENTICATE(?,?,?)}";

	public static void main(String[] args) {

		try (Scanner sc = new Scanner(System.in);) {
			String username = null, password = null;
			if (sc != null) {
				System.out.print("Enter username: ");
				username = sc.next();

				System.out.print("Enter password: ");
				password = sc.next();

			}
			
			try(Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","harsh","tiger");
					CallableStatement cs = con.prepareCall(CALL_PROCEDURE_QUERY);) {
				
				if (cs!=null) {
					cs.registerOutParameter(3, Types.VARCHAR);
				}
				
				if (cs!=null) {
					cs.setString(1, username);
					cs.setString(2, password);
				}
				
				if (cs!=null) {
					cs.execute();
				}
				
				String result = null;
				if (cs!=null) {
					result = cs.getString(3);
					System.out.println(result);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
