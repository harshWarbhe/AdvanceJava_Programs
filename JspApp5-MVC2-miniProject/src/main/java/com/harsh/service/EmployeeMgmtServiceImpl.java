package com.harsh.service;

import java.util.List;

import com.harsh.dao.EmployeeDAOImpl;
import com.harsh.dao.IEmployeeDao;
import com.harsh.model.Employee;

public class EmployeeMgmtServiceImpl implements IEmployeeMgmtService {

	private  IEmployeeDao empDAO;
	
	
	public EmployeeMgmtServiceImpl() {
		empDAO = new EmployeeDAOImpl();
	}


	@Override
	public List<Employee> fetchEmpsDesg(String desg) throws Exception {
		//use DAO
		List<Employee> list = empDAO.getEmpsByDesg(desg);
		list.forEach(emp->{
			emp.setGrosssalary(emp.getSalary()+(emp.getSalary()*0.3f));
			emp.setNetsalary(emp.getGrosssalary()-(emp.getGrosssalary()*0.2f));
		});
		return null;
	}

}
