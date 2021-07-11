package org.testing.assertions;

public class Assert_1 {
	
	public static boolean assertion1(int actual,int expected)
	{
		if(actual==expected) {
			System.out.println("Assertion is passed");
			return true;
		}
		else {
			System.out.println("Assertion is failed");
			return false;
		}
	}
	
	

}
