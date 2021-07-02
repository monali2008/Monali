package org.testing.utilities;
import org.apache.commons.lang3.RandomStringUtils;

public class RandomString {
	
	public static String generateRandomString(int n)
	 {
	   return RandomStringUtils.randomAlphanumeric(n);
	 }

}
