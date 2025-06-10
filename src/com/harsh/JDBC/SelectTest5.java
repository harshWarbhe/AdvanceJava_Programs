package com.harsh.JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class SelectTest5 {

	public static void main(String[] args) {
		Scanner sc= null;
		Connection con=null;
		Statement st= null;
		ResultSet rs = null;
		String query = null;
		
		try {
			sc=new Scanner(System.in);
			
			System.out.println("Write a JDBC program to get count of record from emp db table");
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","harsh","tiger");
			
			if (con != null) {
				st= con.createStatement();
			}
			
			query = "SELECT COUNT(*) FROM EMP";
			
			if (st!=null) {
				rs=st.executeQuery(query);
			}
			
			if (rs!= null) {
				rs.next();
				int count = rs.getInt("count(*)");
				System.out.println("Record count in emp db table : "+count);
			}
			
			
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			try {
				if(rs!=null)
					rs.close();
				
			} catch (Exception e) {
				e.printStackTrace();
			}
			try {
				if(st!=null)
					st.close();
				
			} catch (Exception e) {
				e.printStackTrace();
			}
			try {
				if(con!=null)
					con.close();
				
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

}
