package org.testing.utilities;

import java.util.Random;

public class RandomNumber {
	
	public static Integer generateRandomNo()
	{
		Random r=new Random();
		Integer i= r.nextInt();
		return i;
	}

}
