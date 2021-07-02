package org.testing.testcases;


import java.io.IOException;
import java.util.Properties;

import org.testing.teststeps.HTTPMethods;
import org.testing.utilities.PropertiesFile;
import org.testng.annotations.Test;

import io.restassured.response.Response;

public class TC05_DeleteReq {
	
	@Test
	public void fifthTestCase() throws IOException
	{
		Properties pr= PropertiesFile.readProperties("../APIFramework/URI.properties");
		HTTPMethods hr=new HTTPMethods(pr);
		Response rs=hr.DeleteRequest("QA_URI", TC01_PostReq.responseIdValue);
		System.out.println("Status code of Delete request is: "+rs.statusCode());
		System.out.println("----------------------------------------------");
	}

}
