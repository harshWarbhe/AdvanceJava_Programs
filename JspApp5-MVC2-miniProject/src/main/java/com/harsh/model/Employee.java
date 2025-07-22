package com.harsh.model;

public class Employee {

	private int eno;
	private String ename;
	private String desg;
	private float salary;
	private float grosssalary;
	private float netsalary;

	public int getEno() {
		return eno;
	}

	public void setEno(int eno) {
		this.eno = eno;
	}

	public String getEname() {
		return ename;
	}

	public void setEname(String ename) {
		this.ename = ename;
	}

	public String getDesg() {
		return desg;
	}

	public void setDesg(String desg) {
		this.desg = desg;
	}

	public float getSalary() {
		return salary;
	}

	public void setSalary(float salary) {
		this.salary = salary;
	}

	public float getGrosssalary() {
		return grosssalary;
	}

	public void setGrosssalary(float grosssalary) {
		this.grosssalary = grosssalary;
	}

	public float getNetsalary() {
		return netsalary;
	}

	public void setNetsalary(float netsalary) {
		this.netsalary = netsalary;
	}

	public Employee() {
		super();
	}

	
}
