package com.harsh.JDBC4;

import oracle.jdbc.rowset.OracleJDBCRowSet;

public class JDBCRowSetDemo {

	public static void main(String[] args) {
		try(OracleJDBCRowSet jrowset = new OracleJDBCRowSet()) {
			
			jrowset.setUrl("jdbc:oracle:thin:@localhost:1521:orcl");
			jrowset.setUsername("harsh");
			jrowset.setPassword("tiger");
			jrowset.setCommand("select * from student1");
			jrowset.execute();
			
			while (jrowset.next()) {
				System.out.println(jrowset.getInt(1)+"\t"+jrowset.getString(2)+"\t"+jrowset.getString(3)+"\t"+jrowset.getFloat(4));
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
