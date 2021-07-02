package org.testing.testcases;

import java.io.IOException;
import java.util.Properties;

import org.testing.teststeps.HTTPMethods;
import org.testing.utilities.PropertiesFile;
import org.testng.annotations.Test;

import io.restassured.response.Response;



public class TC02_GetReq {
	
	@Test
	public void secondTestCase() throws IOException
	{
		Properties pr= PropertiesFile.readProperties("../APIFramework/URI.properties");
		HTTPMethods hr=new HTTPMethods(pr);
		Response rs=hr.GetRequest("QA_URI", TC01_PostReq.responseIdValue);
		
		System.out.println("Status code of Get request ia: "+rs.statusCode());
		System.out.println("Body of Get req is: "+rs.asString());
		System.out.println("----------------------------------------------");
	}

}
