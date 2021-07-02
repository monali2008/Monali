package org.testing.testcases;

import java.io.IOException;
import java.util.Properties;

import org.testing.teststeps.HTTPMethods;
import org.testing.utilities.PropertiesFile;
import org.testng.annotations.Test;

import io.restassured.response.Response;

public class TC10_DeleteReq_Req {
	
	@Test
	public void tenthTestCase() throws IOException
	{
		Properties pr= PropertiesFile.readProperties("../APIFramework/URI.properties");
		HTTPMethods hr=new HTTPMethods(pr);
		Response rs=hr.DeleteRequest("REQ_URI","2");
		System.out.println("Status code of Delete req request ia: "+rs.statusCode());
		System.out.println("----------------------------------------------");
	}

}
