package com.harsh.JDBC1;

import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

import org.apache.commons.io.IOUtils;

public class PsBLOBPhotoRetrieveOracle {

	private static final String ACTRESS_RETRIEVE_QUERY = "SELECT AID,NAME,MOVIE,PHOTO FROM ACTRESS_INFO WHERE AID =? ";

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		try (sc;) {
			int aid = 0;
			System.out.print("Enter actress Id : ");
			aid = sc.nextInt();

			try (Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "harsh","tiger");
					PreparedStatement ps = con.prepareStatement(ACTRESS_RETRIEVE_QUERY);) {

			if(ps!=null){
				ps.setInt(1, aid);
			}
			
			try(ResultSet rs = ps.executeQuery()){
				if (rs!=null) {
					if (rs.next()) {
						aid = rs.getInt(1);
						String name= rs.getString(2);
						String movie= rs.getString(3);
						System.out.println(aid+"\t"+name+"\t"+movie+"\t");
						
						try(InputStream io = rs.getBinaryStream(4);
								OutputStream os= new FileOutputStream("retrieve_image.jpg")) {
							IOUtils.copy(io, os);
							System.out.println("Blob value is retrieve and store in the file.");
						}
					}else
						System.out.println("record not found.");
				}
				
			}
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
