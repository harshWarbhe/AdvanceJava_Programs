package com.harsh.JDBC1;

import java.io.FileInputStream;
import java.io.FileReader;
import java.io.InputStream;
import java.io.Reader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class PsCLOBInsertMySQL {
	private static final String INSERT_CLOB_DATA_JOBSEEKER_INFO = "INSERT INTO JOBSEEKER_INFO(JSNAME,JSADDRESS,JSRESUME,JSPHOTO) VALUES(?,?,?,?)";

	public static void main(String[] args) {

		try (Scanner sc = new Scanner(System.in);) {
			String name = null, add = null, resumeLocation = null, photoLocation = null;

			if (sc != null) {
				System.out.print("Enter jobseeker name : ");
				name = sc.nextLine();
				System.out.print("Enter jobseeker address : ");
				add = sc.nextLine();
				System.out.print("Enter jobseeker resume location : ");
				resumeLocation = sc.nextLine().replace("?", "").replace("\"", "");
				System.out.print("Enter jobseeker photo location : ");
				photoLocation = sc.nextLine().replace("?", "").replace("\"", "");
			}
			try (Reader reader = new FileReader(resumeLocation);
					InputStream is = new FileInputStream(photoLocation);) {

				try (Connection con = DriverManager.getConnection("jdbc:mysql:///harsh1", "root","Admin123"); 
						PreparedStatement ps = con.prepareStatement(INSERT_CLOB_DATA_JOBSEEKER_INFO);) {

					if (ps != null) {
						ps.setString(1, name);
						ps.setString(2, add);
						ps.setCharacterStream(3, reader);
						ps.setBinaryStream(4, is);
					}

					int k = 0;
					if (ps != null) {
						k = ps.executeUpdate();
					}

					if (k == 0) {
						System.out.println("record not inseerted");
					} else
						System.out.println("record inserted");
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}


}
