package com.harsh.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.naming.InitialContext;
import javax.sql.DataSource;

import com.harsh.model.Employee;

public class EmployeeDAOImpl implements IEmployeeDao {

	private static final String GET_EMPS_BY_DESGS = "SELECT ENMPNO, ENAME, JOB, SAL, FROM EMP WHERE JOB = ?";

	@Override
	public List<Employee> getEmpsByDesg(String desg) {
		
		List<Employee> list = null;
		
		try (Connection con = getPooledConnection()) {
			PreparedStatement ps = con.prepareStatement(GET_EMPS_BY_DESGS);

			//set query param value
			ps.setString(1, desg);
			
			try(ResultSet rs = ps.executeQuery();) {
				//convert RS object record list of employee obj
				
				 list = new ArrayList<>();
				 
				 while (rs.next()) {
					Employee e = new Employee();
					e.setEno(rs.getInt(1));
					e.setEname(rs.getString(2));
					e.setDesg(rs.getString(3));
					e.setSalary(rs.getFloat(4));
					list.add(e);
				}
				 
				 
			} catch (Exception e) {
				// TODO: handle exception
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	//private are taken as helper method
	private Connection getPooledConnection() throws Exception {
		InitialContext ic = new InitialContext();
		DataSource ds = (DataSource) ic.lookup("java:/comp/env/DsJndi");
		return ds.getConnection();
	}

}
