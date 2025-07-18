package com.harsh.beans;

import java.io.Serializable;

public class StrudentInfo implements Serializable {
	// bean properties
	private int sno;
	private String sname;
	private String sadd;
	private float avg;

	public int getSno() {
		return sno;
	}

	public void setSno(int sno) {
		this.sno = sno;
	}

	public String getSname() {
		return sname;
	}

	public void setSname(String sname) {
		this.sname = sname;
	}

	public String getSadd() {
		return sadd;
	}

	public void setSadd(String sadd) {
		this.sadd = sadd;
	}

	public float getAvg() {
		return avg;
	}

	public void setAvg(float avg) {
		this.avg = avg;
	}

	public StrudentInfo() {
		System.out.println("StrudentInfo :: 0-param constructor");
	}

}
