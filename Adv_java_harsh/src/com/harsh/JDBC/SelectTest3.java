//Write a JDBC App to get Employee Details from EMP DB table based on the given 3 desgs

package com.harsh.JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class SelectTest3 {

	public static void main(String[] args) {
		
		Scanner sc= null;
		String desgs1 = null, desgs2 = null, desgs3=null;
		Connection con = null;
		Statement st= null;
		ResultSet rs = null;
		
		try {
			sc = new Scanner(System.in);
			
			System.out.print("Enter desgs1: ");
			desgs1 = sc.next().toUpperCase();
			
			System.out.print("Enter desgs2: ");
			desgs2 = sc.next().toUpperCase();
			
			System.out.print("Enter desgs3: ");
			desgs3 = sc.next().toUpperCase();
			
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","harsh", "tiger");
			
			if(con !=null)
			{
				st = con.createStatement();
			}
			
			String query= "select empno, ename, job, sal, deptno from emp where JOB in ('"+desgs1+"','"+desgs2+"','"+desgs3+"') order by JOB";
			
			if (st != null) {
				rs= st.executeQuery(query);
			}
			
			while(rs.next() != false)
			{
				System.out.println(rs.getInt(1) + "   " + rs.getString(2) + "   " + rs.getString(3) + "   " + rs.getFloat(4)+"   " + rs.getInt(5));
			}
			
			
			
		} 
		catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		catch (Exception e) {
			System.out.println(e.getMessage());
		}
		finally {
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
	}

}
