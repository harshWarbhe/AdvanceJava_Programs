package com.harsh.JDBC2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class PSScolaableRSTest {
	private static final String EMP_SELECT_QUERY_SCROLLABLE = "SELECT EMPNO, ENAME, JOB, SAL FROM EMP";

	public static void main(String[] args) {
		
		try(Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","harsh","tiger");
				PreparedStatement ps =con.prepareStatement(EMP_SELECT_QUERY_SCROLLABLE,ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
				ResultSet rs = ps.executeQuery(EMP_SELECT_QUERY_SCROLLABLE);) {
			
			if (rs!=null) {
				System.out.println("RS record top to bottom");
				while (rs.next()) {
					System.out.println(rs.getRow()+"---->"+rs.getInt(1)+"\t"+rs.getString(2)+"\t"+rs.getString(3)+"\t"+rs.getString(4));
				}
				System.out.println("---------------------------------------");
				System.err.println("RS record bottom to top");
				
				rs.afterLast();
				while (rs.previous()) {
					System.out.println(rs.getRow()+"---->"+rs.getInt(1)+"\t"+rs.getString(2)+"\t"+rs.getString(3)+"\t"+rs.getString(4));
				}
				
				System.out.println("---------------------------------------");
				rs.first();
				System.out.println(rs.getRow()+"---->"+rs.getInt(1)+"\t"+rs.getString(2)+"\t"+rs.getString(3)+"\t"+rs.getString(4));

				System.out.println("---------------------------------------");
				rs.last();
				System.out.println(rs.getRow()+"---->"+rs.getInt(1)+"\t"+rs.getString(2)+"\t"+rs.getString(3)+"\t"+rs.getString(4));
				
				System.out.println("---------------------------------------");
				rs.absolute(3);
				System.out.println(rs.getRow()+"---->"+rs.getInt(1)+"\t"+rs.getString(2)+"\t"+rs.getString(3)+"\t"+rs.getString(4));

				System.out.println("---------------------------------------");
				rs.absolute(-5);
				System.out.println(rs.getRow()+"---->"+rs.getInt(1)+"\t"+rs.getString(2)+"\t"+rs.getString(3)+"\t"+rs.getString(4));

				System.out.println("---------------------------------------");
				rs.relative(3);
				System.out.println(rs.getRow()+"---->"+rs.getInt(1)+"\t"+rs.getString(2)+"\t"+rs.getString(3)+"\t"+rs.getString(4));
				
				System.out.println("---------------------------------------");
				rs.relative(-6);
				System.out.println(rs.getRow()+"---->"+rs.getInt(1)+"\t"+rs.getString(2)+"\t"+rs.getString(3)+"\t"+rs.getString(4));
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
