package com.harsh.JDBC2;

/*
 * CREATE OR REPLACE FUNCTION FX_GET_STUDENT_DETAILS_BY_SNO
NO IN NUMBER
,NAME OUT VARCHAR
, ADDRS OUT VARCHAR
) RETURN FLOAT 
AS
PERCENTAGE FLOAT;
BEGIN
SELECT SNAME,SADD,AVG INTO NAME,ADDRS,PERCENTAGE FROM STUDENT1 WHERE SNO=NO;
RETURN PERCENTAGE.
END FX_GET_STUDENT_DETAILS_BY_NO;*/
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Types;
import java.util.Scanner;

public class CsFunctionTest {
	//private static final String CALL_FX_QUERY = "{? = CALL FX_GET_STUDENT_DETAIL_BY_SNO (?,?,?)}";
	  private static final String CALL_FX_QUERY = "{? = call FX_GET_STUDENT_DETAIL_BY_SNO(?, ?, ?) }";

	public static void main(String[] args) {
		try (Scanner sc = new Scanner(System.in);) {
			int sno = 0;
			if (sc != null) {
				System.out.print("Enter student number: ");
				sno = sc.nextInt();

			}
			try (Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "harsh",
					"tiger"); CallableStatement cs = con.prepareCall(CALL_FX_QUERY);) {

				if (cs != null) {
					cs.registerOutParameter(1, Types.FLOAT);
					cs.registerOutParameter(3, Types.VARCHAR);
					cs.registerOutParameter(4, Types.VARCHAR);
				}

				if (cs != null) {
					cs.setInt(2, sno);
				}

				if (cs != null) {
					cs.execute();
				}

				if (cs != null) {
					System.out.println("Student name: " + cs.getString(3));
					System.out.println("Student address: " + cs.getString(4));
					System.out.println("Student percentage: " + cs.getFloat(1));
				}

			} catch (Exception e) {
				e.printStackTrace();
			}
		}

	}
}
