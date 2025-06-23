package com.harsh.JDBC4;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class TransferMoneyTxMgmtTest {

	
	public static void main(String[] args) {

		long srcAccno = 0, desAccno = 0;
		double amount = 0.0;

		try (Scanner sc = new Scanner(System.in);) {
			System.out.print("enter source account no:: ");
			srcAccno = sc.nextLong();
			System.out.print("enter destination account no:: ");
			desAccno = sc.nextLong();
			System.out.print("enter account to transfer:: ");
			amount = sc.nextDouble();

		} catch (Exception e) {
			e.printStackTrace();
		}

		try (Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "harsh", "tiger");
				Statement st = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
				Statement st1 = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
				ResultSet rs1 = st1.executeQuery("SELECT ACCNO, HOLDER, BALANCE FROM JDBC_ACCOUNT")
				) {

			con.setAutoCommit(false);
			
			if (st != null) {

				// add query to batch
				// for withdraw operation
				st.addBatch("update JDBC_ACCOUNT SET BALANCE = BALANCE - " + amount + "WHERE ACCNO = " + srcAccno);

				// for deposite operation
				st.addBatch("update JDBC_ACCOUNT SET BALANCE = BALANCE + " + amount + "WHERE ACCNO = " + desAccno);

				int result[] = st.executeBatch();

				//process for results from TxMgmt
				boolean flag = true;
				for (int i = 0; i < result.length; i++) {
					if (result[i]==0) {
						flag = false;
						break;
					}
				}
				
				if (flag==true) {
					con.commit();
					System.out.println("transtion commit");
				}
				else {
					con.rollback();
					System.out.println("transtion rollback");
				}
				
			}
			
			if (rs1!=null) {
				while (rs1.next()) {
					System.out.println(rs1.getInt(1)+"\t\t"+rs1.getString(2)+"\t\t"+rs1.getFloat(3));
				}
			}
			

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
