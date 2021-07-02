package org.testing.testcases;

import java.io.IOException;
import java.util.Properties;

import org.testing.teststeps.HTTPMethods;
import org.testing.utilities.JSONFile;
import org.testing.utilities.JSONVariableReplacement;
import org.testing.utilities.PropertiesFile;
import org.testing.utilities.RandomString;
import org.testng.annotations.Test;

import io.restassured.response.Response;

public class TC09_PutReq_req {
	
	@Test
	public void ninethTestCase() throws IOException
	{
		Properties pr= PropertiesFile.readProperties("../APIFramework/URI.properties");
		String bodyData=JSONFile.readJson("../APIFramework/src/test/java/org/testing/resources/BodyDataForPost_Req.json");
		bodyData=JSONVariableReplacement.jsonReplace(bodyData, "name", RandomString.generateRandomString(6));
		bodyData=JSONVariableReplacement.jsonReplace(bodyData, "job", RandomString.generateRandomString(4));
		HTTPMethods hr=new HTTPMethods(pr);
		Response rs=hr.putRequest(bodyData,"REQ_URI","2");
		System.out.println("Status code of put req req request ia: "+rs.statusCode());
		System.out.println("Body of put req req is: "+rs.asString());
		System.out.println("----------------------------------------------");
	}


}
