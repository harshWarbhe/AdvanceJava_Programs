package com.harsh.service;

import java.util.List;

import com.harsh.model.Employee;

public interface IEmployeeMgmtService {

	public List<Employee> fetchEmpsDesg(String desg) throws Exception;
}
