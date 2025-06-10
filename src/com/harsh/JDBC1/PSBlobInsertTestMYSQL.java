package com.harsh.JDBC1;

import java.io.FileInputStream;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class PSBlobInsertTestMYSQL {

	private static final String INSERT_ACTRESS_QUERY = "INSERT INTO ACTRESS_INFO(NAME,MOVIE,PHOTO) VALUES(?,?,?)";

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		try (sc;) {
			String name = null, movie = null, photoLocation = null;
			if (sc != null) {
				System.out.print("Enter Actress name : ");
				name = sc.nextLine();
				System.out.print("Enter Actress movie : ");
				movie = sc.nextLine();
				System.out.print("Enter Actress photo : ");
				photoLocation = sc.nextLine();
			}

			try (InputStream is = new FileInputStream(photoLocation)) {

				try (Connection con = DriverManager.getConnection("jdbc:mysql:///harsh","root","Admin123");
						PreparedStatement ps = con.prepareStatement(INSERT_ACTRESS_QUERY);) {

					if (ps != null) {
						ps.setString(1, name);
						ps.setString(2, movie);
						ps.setBinaryStream(3, is);

					}

					int k = 0;
					if (ps != null) {
						k = ps.executeUpdate();

						if (k == 0) {
							System.out.println("record not inserted");
						} else {
							System.out.println("record inserted");
						}
					}
				}

			}

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
