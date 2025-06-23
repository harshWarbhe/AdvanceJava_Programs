package com.harsh.JDBC2;

/*
CREATE OR REPLACE PROCEDURE P_GET_EMPS_BYNAME_INITIAL
(INITIALCHARS IN VARCHAR2
DETAILS OUT SYS_REFCURSOR
)as
BEGIN

OPEN DETAIILS FOR
SELECT EMPNO,ENAME, JOB,SAL,DEPTNO FROM EMP WHERE ENAME LIKE INITIALCHARS

END P_GET_EMPS_BYNAME_INITIAL;
*/

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.util.Scanner;

import oracle.jdbc.OracleTypes;

public class CsProcedureCursorTest {
	private static final String PROCEDURE_CALL_QUERY = "{CALL P_GET_EMPS_BYNAME_INITIAL(?,?)}";

	public static void main(String[] args) {
		try (Scanner sc = new Scanner(System.in);) {
			String initChar = null;
			if (sc != null) {
				System.out.print("Enter initial character of employee name: ");
				initChar = sc.next() + "%";

			}
			try (Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "harsh",
					"tiger"); CallableStatement cs = con.prepareCall(PROCEDURE_CALL_QUERY);) {

				if (cs != null) {
					cs.registerOutParameter(2, OracleTypes.CURSOR);
				}

				if (cs != null) {
					cs.setString(1, initChar);
				}

				if (cs != null) {
					cs.execute();
				}

				Boolean flag = false;
				if (cs != null) {
					ResultSet rs = (ResultSet) cs.getObject(2);
					
					System.out.println("the output is -");
					while (rs.next()) {
						flag = true;
						System.out.println(rs.getInt(1) + " " + rs.getString(2) + " " + rs.getString(3) + " "
								+ rs.getFloat(4) + " " + rs.getInt(5));
					}
				}
				if (flag == false) {
					System.out.println("record not found");
				}

			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
