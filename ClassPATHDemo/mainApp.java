//mainApp.java

//import basic.WishMessageGeneretor

public class mainApp
{
	public static void main(String args[])
	{
		WishMessageGeneretor wmg = new WishMessageGeneretor();
		String result = wmg.sayHello("harsh");
		System.out.println("Result::"+result);
	}
}