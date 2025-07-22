package com.harsh.service;

import com.harsh.beans.Employee;

public class PaySlipGeneratorService {

	public void GeneratedPaySlip(Employee emp) {

		float grossSalary = emp.getBasicSalary() + emp.getBasicSalary() * 0.4f;

		float netSalary = grossSalary - (grossSalary * 0.2F);

		// set the generate grossSalary,netSalary back to java bean class obj

		emp.setGrossSalary(grossSalary);
		emp.setNetSalary(netSalary);

	}
}
