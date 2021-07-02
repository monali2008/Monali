package org.testing.testcases;

import java.io.IOException;
import java.util.Properties;

import org.testing.teststeps.HTTPMethods;
import org.testing.utilities.PropertiesFile;
import org.testng.annotations.Test;

import io.restassured.response.Response;

public class TC03_GetAllReq {
	
	@Test
	public void thirdTestCase() throws IOException
	{
		Properties pr= PropertiesFile.readProperties("../APIFramework/URI.properties");
		HTTPMethods hr=new HTTPMethods(pr);
		Response rs=hr.GetRequest("QA_URI");
		System.out.println("Status code of Get All request ia: "+rs.statusCode());
		System.out.println("Body of Get All req is: "+rs.asString());
		System.out.println("----------------------------------------------");
	}

}
