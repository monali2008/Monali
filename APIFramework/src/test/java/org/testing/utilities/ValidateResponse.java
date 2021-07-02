package org.testing.utilities;

import org.testing.assertions.Assert_1;
import org.testng.Assert;

import io.restassured.response.Response;

public class ValidateResponse {
	
	public static void statusCodeValidate(Response rs,int expectedStatusCode)
	{
		int actualStatusCode=rs.statusCode();
		Assert_1.assertion1(actualStatusCode, expectedStatusCode);
	}
	
	public static void dataValidate(Response rs,String jsonPath,String expectedData)
	{
		String actualData=rs.jsonPath().getString(jsonPath);
		Assert.assertEquals(actualData, expectedData,"Data is not matching");
	}

}
