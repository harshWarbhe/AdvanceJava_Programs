package com.harsh.JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class SelectTest1 {

	public static void main(String[] args) throws Exception
	{
		Scanner sc = new Scanner(System.in);
		System.out.println("To find employee detail between range based on salary...");
		
		System.out.print("Enter start range of employee: ");
		float startSalary = sc.nextFloat();
		
		System.out.print("Enter end range of employee: ");
		float endSalary = sc.nextFloat();
		
		
		Class.forName("oracle.jdbc.driver.OracleDriver");
		
		Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","harsh","tiger");
		
		Statement st = con.createStatement();
		
		String query = "select empno,ename,job,sal from emp where sal>="+startSalary+" and sal<="+endSalary;
		
		ResultSet rs= st.executeQuery(query);
		
		System.out.println("Emp details having salary range "+startSalary+" to "+endSalary);
		
		while(rs.next() != false)
		{
			System.out.println(rs.getInt(1)+"   "+
								rs.getString(2)+"   "+
								rs.getString(3)+"   "+
								rs.getFloat(4));
		}
		
		con.close();

	}

}
