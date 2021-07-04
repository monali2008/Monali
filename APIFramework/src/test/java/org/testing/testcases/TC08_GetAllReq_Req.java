package org.testing.testcases;

import java.io.IOException;
import java.util.List;
import java.util.Properties;

import org.testing.teststeps.HTTPMethods;
import org.testing.utilities.JsonParsingUsingOrgJson;
import org.testing.utilities.PropertiesFile;
import org.testng.annotations.Test;

import io.restassured.response.Response;

public class TC08_GetAllReq_Req {
	
	@Test
	public void eightTestCase() throws IOException
	{
		String extractParameter="id";
		
		Properties pr= PropertiesFile.readProperties("../APIFramework/URI.properties");
		HTTPMethods hr=new HTTPMethods(pr);
		Response rs=hr.GetRequestQueryParameter("REQ_URI", "page=2");
		
		System.out.println("Status code of Get all req request ia: "+rs.statusCode());
		System.out.println("Body of Get all req is: "+rs.asString());
		
		List<Object>ob=JsonParsingUsingOrgJson.parseJSONArray(rs, "data", extractParameter);
		for(Object o:ob) {
			System.out.println(extractParameter+" is: "+"'"+o+"'");
		}
		System.out.println("----------------------------------------------");
	}

}
