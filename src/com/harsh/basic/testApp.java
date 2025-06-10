package com.harsh.basic;

class test {
	static {
		System.out.println("test : static block ");
	}

	public test() {
		System.out.println("test : 0-para constructor");
	}
}

class demo {
	static {
		System.out.println("demo : static block ");
	}

	public demo() {
		System.out.println("demo : 0-para constructor");
	}
}

public class testApp {

	static {
		System.out.println("testApp : static block ");
	}

	public static void main(String[] args) throws Exception {
		System.out.println("start of main method...");
		// creating object for demo class
		demo d1 = new demo();
		demo d2 = new demo();
		demo d3 = new demo();

		// load test class
		Class.forName("basic.test");

		Class.forName("basic.test");
		Class.forName("basic.test");
		Class.forName("basic.demo");// demo class was already loaded earlier → static block does not run again.

		System.out.println("end of main method...");
	}

}
