package com.harsh.JDBC4;

import java.io.FileOutputStream;
import java.io.OutputStream;

import oracle.jdbc.rowset.OracleWebRowSet;

public class WebRowSetDemo {

	public static void main(String[] args) {

		try (OracleWebRowSet wRowSet = new OracleWebRowSet()) {

			wRowSet.setUrl("jdbc:oracle:thin:@localhost:1521:orcl");
			wRowSet.setUsername("harsh");
			wRowSet.setPassword("tiger");
			wRowSet.setCommand("select * from student1");
			wRowSet.execute();

			while (wRowSet.next()) {
				System.out.println(wRowSet.getInt(1) + "\t" + wRowSet.getString(2) + "\t" + wRowSet.getString(3) + "\t"
						+ wRowSet.getFloat(4));
			}
			System.err.println("--------------------------------------------------");

			// writing Db table records as xml content to file
			OutputStream os = new FileOutputStream("student1.xml");
			wRowSet.writeXml(os);

			System.err.println("--------------------------------------------------");

			// writing Db table records as xml content to console
			wRowSet.writeXml(System.out);

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
