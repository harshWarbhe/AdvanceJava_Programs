package com.harsh.dao;


import java.util.List;

import com.harsh.model.Employee;

public interface IEmployeeDao {

	public List<Employee> getEmpsByDesg(String desg);
}
