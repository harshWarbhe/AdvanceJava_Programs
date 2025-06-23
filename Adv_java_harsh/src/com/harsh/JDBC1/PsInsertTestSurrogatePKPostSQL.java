package com.harsh.JDBC1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class PsInsertTestSurrogatePKPostSQL {

	private static final String SELECT_PRODUCT_POSTGRESQL = "INSERT INTO public.\"PRODUCT\"(PID,PNAME,PRICE,QTY,STATUS) VALUES(NEXTVAL('PID_SEQ'),?,?,?,?)";


	public static void main(String[] args) {

		try (Scanner sc = new Scanner(System.in);) {
			int count = 0;
			if (sc != null) {
				System.out.print("Enter product item count : ");
				count = sc.nextInt();
				sc.nextLine();
			}

			/*
			 * Class.forName("org.postgresql.driver"); Connection con=
			 * DriverManager.getConnection("jdbc:postgresql:harsh","postgres","Admin123");
			 */
			try (Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/harsh", "postgres",
					"Admin123"); PreparedStatement ps = con.prepareStatement(SELECT_PRODUCT_POSTGRESQL);) {

				if (ps != null && sc != null) {
					for (int i = 1; i <= count; i++) {
						System.out.print("Enter " + i + " product name: ");
						String name = sc.nextLine();

						System.out.print("Enter " + i + " product price: ");
						float price = sc.nextFloat();

						System.out.print("Enter " + i + " product quantity: ");
						int qty = sc.nextInt();
						sc.nextLine(); // Consume leftover newline

						System.out.print("Enter " + i + " product status: ");
						String status = sc.nextLine();

						ps.setString(1, name);
						ps.setFloat(2, price);
						ps.setInt(3, qty);
						ps.setString(4, status);


						int k = ps.executeUpdate();
						if (k == 0) {
							System.out.println(i + " record not inserted");
						} else {
							System.out.println(i + " record inserted");

						}

					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
