package org.testing.testcases;

import java.io.IOException;
import java.util.Properties;

import org.testing.teststeps.HTTPMethods;
import org.testing.utilities.PropertiesFile;
import org.testng.annotations.Test;

import io.restassured.response.Response;

public class TC08_GetAllReq_Req {
	
	@Test
	public void eightTestCase() throws IOException
	{
		Properties pr= PropertiesFile.readProperties("../APIFramework/URI.properties");
		HTTPMethods hr=new HTTPMethods(pr);
		Response rs=hr.GetRequestQueryParameter("REQ_URI", "page=2");
		
		System.out.println("Status code of Get all req request ia: "+rs.statusCode());
		System.out.println("Body of Get all req is: "+rs.asString());
		System.out.println("----------------------------------------------");
	}

}