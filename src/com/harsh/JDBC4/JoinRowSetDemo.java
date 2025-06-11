package com.harsh.JDBC4;

import oracle.jdbc.rowset.OracleCachedRowSet;
import oracle.jdbc.rowset.OracleJoinRowSet;

public class JoinRowSetDemo {

	public static void main(String[] args) {

		try (OracleCachedRowSet crs1 = new OracleCachedRowSet();
				OracleCachedRowSet crs2 = new OracleCachedRowSet();
				OracleJoinRowSet jnRowSet = new OracleJoinRowSet();) {

			crs1.setUrl("jdbc:oracle:thin:@localhost:1521:orcl");
			crs1.setUsername("harsh");
			crs1.setPassword("tiger");
			crs1.setCommand("select empno,ename, job,sal,deptno from emp");
			crs1.setMatchColumn("deptno");
			crs1.execute();

			crs2.setUrl("jdbc:oracle:thin:@localhost:1521:orcl");
			crs2.setUsername("harsh");
			crs2.setPassword("tiger");
			crs2.setCommand("select deptno, dname, loc from dept");
			crs2.setMatchColumn("deptno");
		
			crs2.execute();

			jnRowSet.addRowSet(crs2);
			jnRowSet.addRowSet(crs1);

			while (jnRowSet.next()) {
				System.out.println(
					    jnRowSet.getInt(1) + "\t\t" +     // deptno
					    jnRowSet.getString(2) + "\t\t" +  // dname
					    jnRowSet.getString(3) + "\t\t" +  // loc
					    jnRowSet.getString(4) + "\t\t" +     // empno
					    jnRowSet.getString(5) + "\t\t" +  // ename
					    jnRowSet.getString(6) + "\t\t" +  // job
					    jnRowSet.getString(7)            // sal
					);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
