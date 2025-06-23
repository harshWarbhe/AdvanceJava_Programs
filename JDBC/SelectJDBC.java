//SelectJDBC.java
import java.sql.*;

public class SelectJDBC
{
	public static void main(String[] args) throws Exception
	{
		//load jdbc driver class
		Class.forName("oracle.jdbc.driver.OracleDriver");

		//establish the connection 
		Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","harsh","tiger");
		
		//create jdbc Statement object (vehicle)
		Statement st = con.createStatement();
		
		//send and execute sql select query and get jdbc ResultSet object 
		ResultSet rs = st.executeQuery("select * from student1");
 
		//process of ResultSet object
 		while(rs.next() != false)
		{
			//System.out.println(rs.getInt(1)+" "+rs.getString(2)+" "+rs.getString(3)+" "+rs.getFloat(4));
			System.out.println(rs.getInt(1)+" "+rs.getString(2)+" "+rs.getString(3)+" "+rs.getFloat(4));
		}

		/*
		note: while processing the ResultSet .. if u do not know col data types .. the we can get all the col values as String values using rs.getString(-) methods either passing col names or col indexes.
        //process the ResultSet object
			while(rs.next() != false){ //while(rs.next() == true)
				System.out.println(rs.getInt(1)+" "+rs.getString(2)+" "+rs.getString(3)+" "+rs.getFloat(4));
								(or)

				System.out.println(rs.getInt("SNO")+" "+rs.getString("SNAME")+" "+rs.getString("SADD")+" "+rs.getFloat("AVG"));
								(or)

				System.out.println(rs.getString("SNO")+" "+rs.getString("SNAME")+" "+rs.getString("SADD")+" "+rs.getString("AVG")
								(or)

				System.out.println(rs.getString(1)+" "+rs.getString(2)+" "+rs.getString(3)+" "+rs.getString(4));
		*/

		//close connection
		con.close();

	}
}
