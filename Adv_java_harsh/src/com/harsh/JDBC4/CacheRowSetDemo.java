package com.harsh.JDBC4;

import oracle.jdbc.rowset.OracleCachedRowSet;

public class CacheRowSetDemo {

	public static void main(String[] args) {
		
		try(OracleCachedRowSet cRowSet = new OracleCachedRowSet()) {
			
			cRowSet.setUrl("jdbc:oracle:thin:@localhost:1521:orcl");
			cRowSet.setUsername("harsh");
			cRowSet.setPassword("tiger");
			cRowSet.setCommand("select * from student1");
			cRowSet.execute();
			
			while (cRowSet.next()) {
				System.out.println(cRowSet.getInt(1)+"\t"+cRowSet.getString(2)+"\t"+cRowSet.getString(3)+"\t"+cRowSet.getFloat(4));
			}
			
			System.err.println("stop DB s/w from services.msc");
			Thread.sleep(4000);
			cRowSet.absolute(3);
			cRowSet.updateFloat(4, 92.9f);
			cRowSet.updateRow();
			
			System.out.println("offline modification done");
			System.err.println("start DB s/w from services.msc");
			
			Thread.sleep(3000);
			cRowSet.acceptChanges();
			
			//cRowSet.beforeFirst();
			
			while (cRowSet.next()) {
				System.out.println(cRowSet.getInt(1)+"\t"+cRowSet.getString(2)+"\t"+cRowSet.getString(3)+"\t"+cRowSet.getFloat(4));
			}
			
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
